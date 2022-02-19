package com.lyf.huffmantreecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
 *  		哈夫曼编码
 */
public class HuffmantreeCodeDemo {
	public static void main(String[] args) {
		String content = "Among thousands of people, you meet those you've met. Through thousands ofyears, "
				+ "with the boundlessness of time you happen to meet them, neither earlier nor abit too late.";
		byte[] bytes = content.getBytes();
		free(huffmantreeZip(content,bytes),hm);
	}
	
//	将所有的方法封装起来 压缩操作
	public static byte[] huffmantreeZip(String content,byte []bytes) {
		getCode(creatHuffmantree(content),"",pre);
		byte[] b =  zip(hm,bytes);
		return b;
	}
	
//	先序遍历
	public static void pre(Node root) {
		System.out.println(root.getWeight()+"  "+root.getData());
		if(root.getLeft()!=null) {
			pre(root.getLeft());
		}
		if(root.getRight()!=null) {
			pre(root.getRight());
		}
	}

//	将字符出现的次数当做权值 创造哈夫曼树
	public static Node creatHuffmantree(String content) {
		byte []bytes = content.getBytes();
		HashMap<Byte,Integer> hm = new HashMap<Byte,Integer>();
		for (int i = 0; i < bytes.length; i++) {
			hm.put(bytes[i], 0);
		}
//		统计字符串中字符出现的频率
		for(Map.Entry<Byte, Integer> entry : hm.entrySet()) {
			Integer in = entry.getValue();
			for (int i = 0; i < bytes.length; i++) {
				if(entry.getKey()==bytes[i]) {
					in++;
				}
			}
			hm.put(entry.getKey(), in);
		}
		
//		放入ArrayList中
		ArrayList<Node> al = new ArrayList<Node>();
		for(Map.Entry<Byte, Integer> entry: hm.entrySet()) {
			al.add(new Node(entry.getKey(),entry.getValue()));
		}
		
//		for (Node node : al) {
//			System.out.println(node.getData()+"  "+node.getWeight());
//		}
		
//		开始构建 哈夫曼树
		while(al.size()>1) {
			Collections.sort(al);
			
			Node leftNode = al.get(0);
			Node rightNode = al.get(1);
			
			Node newNode = new Node(null,leftNode.getWeight()+rightNode.getWeight());
			
			newNode.setLeft(leftNode);
			newNode.setRight(rightNode);
			
			al.remove(leftNode);
			al.remove(rightNode);
			
			al.add(newNode);
		}
		
		return al.get(0);
	}

	
//	进行编码
	static StringBuilder pre = new StringBuilder();
	static HashMap<Byte,StringBuilder> hm = new HashMap<Byte, StringBuilder>();
	public static void getCode(Node node ,String code,StringBuilder pre) {
		StringBuilder now = new StringBuilder(pre);
		if(node!=null) {
			now.append(code);
			if(node.getData()==null) {
				
				getCode(node.getLeft(),"0",now);
				getCode(node.getRight(),"1",now);
				
			}else {
				hm.put(node.getData(), now);
			}
		}else {
			return ;
		}
	}
	

//	将得到的0 1字符编码串 转成字节 放到字节数组中保存    即实现压缩过程
	static Integer count = 0;
	public static byte[] zip(HashMap<Byte,StringBuilder> hm,byte []bytes) {
		StringBuilder sb = new StringBuilder();
//		先转成 0 1字符编码
		for (byte b : bytes) {
			sb.append(hm.get(b));
		}
		int len = (sb.length()+7)/8;
		
		int index = 0;
		String str = "";
		byte []huffmantreeCode = new byte[len];
		
		for (int i = 0; i < sb.length(); i+=8) {
			if(i+8<=sb.length()) {
				str = sb.substring(i,i+8);
			}else {
//				不足八位的必须补成八位 然后再转为字节  不然会造成丢失0 的情况 导致结果出错
				count = (i+8)-sb.length();
				for (int j = 0; j <count; j++) {
					sb.append('0');
				}
				str = sb.substring(i);
			}
			
				huffmantreeCode[index++] = (byte)(Integer.parseInt(str,2));
		}
		System.out.println("压缩后的字节数组:"+Arrays.toString(huffmantreeCode));
		return huffmantreeCode;
	}

	
//	解压操作
	public static void free(byte[] zipByte , Map<Byte,StringBuilder> hm) {
		StringBuilder sb = new StringBuilder();
		int temp = 0;
		String str = "";
		for (int i = 0; i < zipByte.length; i++) {
			temp = zipByte[i];
//				正数需要补位
				if(zipByte[i]>0) {
					temp|=256;
				}
				str = Integer.toBinaryString(temp);
				sb.append(str.substring(str.length()-8));
		}
//		去除在压缩成字节数组的时候 最后不足八位  所添加的0
		sb.delete(sb.length()-count, sb.length());
		System.out.println("由赫夫曼编码得到的0 1字符串:"+sb.toString());

//		对照 赫夫曼编码  将0 1 字符串转成字符
		int count = 0;
		String value = "";
		String s = "";
		ArrayList<Byte> al =new ArrayList<Byte>();
		for (int i = 0; i < sb.length();i+=count) {
//			for循环每执行一次 count必须置为1！！！！！！！！！！！！！！！！！！！！！！
			  count = 1;
			 w: while(true) {
					 s = sb.substring(i,i+count);
				for(Map.Entry<Byte, StringBuilder> entry:hm.entrySet()) {
					value = entry.getValue().toString();
					if(s.equals(value)) {
						al.add(entry.getKey());
						break w;
					}
				}
				count++;
			}
		}
		
		byte []source = new byte[al.size()];
		for (int i = 0; i < al.size(); i++) {
			source[i] = al.get(i);
		}
		String decode = new String(source);
		System.out.println("解压后的数据:"+decode);
	}
}


//	定义节点
class Node implements Comparable<Node>{
	private Byte data;
	private Integer weight;
	private Node left;
	private Node right;
	
	public Node(Byte data,int weight) {
		this.data = data;
		this.weight = weight;
	}
	
	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}


	public Byte getData() {
		return data;
	}

	public void setData(Byte data) {
		this.data = data;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

//	重写compareTo()方法
	public int compareTo(Node o) {
		return this.weight - o.weight;
	}
}
