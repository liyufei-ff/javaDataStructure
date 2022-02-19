package com.lyf.map;

import java.util.ArrayList;

/*
 * 		使用邻接表存储图
 */
public class MapDemoTwo {
	public static void main(String[] args) {
		String []data = {"A","B","C","D","E"};
		MapTwo mt = new MapTwo(5);
		for (String str : data) {
			mt.addData(str);
		}
		
		mt.addSide("A", "C");
		mt.addSide("B", "A");
		mt.addSide("B", "C");
		mt.addSide("B", "D");
		mt.addSide("B", "E");
		
		mt.show();
	}
}

//	定义图
class MapTwo{
	private ArrayList<String> al;
	private Linkedlist[] arr;
	private int nodeC;
	private int sideC;
	
	public MapTwo(int nodeC) {
		this.nodeC = nodeC;
		al = new ArrayList<String>(nodeC);
		arr = new Linkedlist[nodeC];
//		将链表数组中的 各个链表初始化                 如果不初始化则都为null  会出现空指针异常的情况
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Linkedlist();
		}
	}
	
//	将节点存储到 集合中
	public void addData(String data) {
		al.add(data);
	}
	
//	获取节点在 集合中的下标
	public int index(String value) {
		for (int i = 0; i < al.size(); i++) {
			if(al.get(i).equals(value)) {
				return i;
			}
		}
		return -1;
	}

//	添加节点之间的边
	public void addSide(String v1,String v2) {
		int v1Index = index(v1);
		int v2Index = index(v2);
		arr[v1Index].addNode(new Node(v2));
		arr[v2Index].addNode(new Node(v1));
		sideC++;
	}
	
//	显示图
	public void show() {
		for (int i = 0; i < arr.length; i++) {
			arr[i].showl();
			System.out.println();
		}
	}

	public int getNodeC() {
		return nodeC;
	}

	public void setNodeC(int nodeC) {
		this.nodeC = nodeC;
	}

	public int getSideC() {
		return sideC;
	}

	public void setSideC(int sideC) {
		this.sideC = sideC;
	}
	
}

//	链表数组
class Linkedlist{
	private Node root;
//	构造方法
	public Linkedlist() {
		root = null;
	}
	
//	项链表中 添加节点
	public void addNode(Node node) {
		if(root==null) {
			root = node;
			return ;
		}
		Node temp = root;
		while(temp.getNext()!=null) {
			temp = temp.getNext();
		}
		temp.setNext(node);
	}
	
//	显示链表
	public void showl() {
		Node temp = root;
		while(temp!=null) {
			System.out.print(temp.getValue()+" ");
			temp = temp.getNext();
		}
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	
}

//	节点
class Node{
	private String value;
	private Node next;
	
	public Node(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node node) {
		this.next = node;
	}
	
}