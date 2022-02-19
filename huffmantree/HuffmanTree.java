package com.lyf.huffmantree;
import java.util.ArrayList;
import java.util.Collections;

/*
 * 		����huffmantree 
 */
public class HuffmanTree {
	public static void main(String[] args) {
		int []arr = {13,7,8,3,29,6,1};
		ArrayList<Node> al = new ArrayList<Node>();
		for (int value : arr) {
			al.add(new Node(value));
		}
		
//		��ʼ����huffmantree
		while(al.size()>1) {
			Collections.sort(al);
			
			Node leftNode = al.get(0);
			Node rightNode = al.get(1);
			
			Node newNode = new Node(leftNode.getValue()+rightNode.getValue());
			
			newNode.setLeft(leftNode);
			newNode.setRight(rightNode);
			
			al.remove(0);
//			ɾ��һ��֮��  �����Ԫ�ػ��Զ���ǰ����  ����ɾ���ڶ�����Ҳ��al.remove(0);
			al.remove(0);
			
			al.add(newNode);
		}
		
		preOrder(al.get(0));
	}

//		�������
	public static void preOrder(Node root) {
		if(root==null) {
			return ;
		}
		
		System.out.println(root.getValue());
		
		if(root.getLeft()!=null) {
			preOrder(root.getLeft());
		}
		
		if(root.getRight()!=null) {
			preOrder(root.getRight());
		}
	}
}	

class Node implements Comparable<Node>{
	private Node left;
	private Node right;
	private int  value;
	
//	���캯��
	public Node(int value) {
		this.value = value;
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
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
//	����
	@Override
	public int compareTo(Node o) {
		return this.value - o.value;
	}

}
