package com.lyf.avltree;
/*
 *  		AvlTree
 */
public class AvlTree {
	public static void main(String[] args) {
		int arr[] = {10,11,7,6,8,9};
		Node root = new Node(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			add(root,new Node(arr[i]));
		}
		
		infixOrder(root);
		System.out.println();
		System.out.println(height(root));
		System.out.println(height(root.getLeft()));
		System.out.println(height(root.getRight()));
	}
	
//	����AvlTree
	public static void add(Node root,Node node) {
		if(root==null) {
			root = node;
			return ;
		}
		
		if(root.getValue()<node.getValue()) {
			if(root.getRight()==null) {
				root.setRight(node);				
			}else {
				add(root.getRight(),node);
			}
		}else {
			if(root.getLeft()==null) {
				root.setLeft(node);
			}else {
				add(root.getLeft(),node);
			}
		}
		
//		������ת
		if( height(root.getLeft()) - height(root.getRight()) > 1) {
			if( height(root.getLeft().getRight()) > height(root.getLeft().getLeft()) ) {
				rotateLeft(root.getLeft());
				rotateRight(root);
			}else {
				rotateRight(root);
			}
		}else if( height(root.getRight()) - height(root.getLeft()) > 1) {
			if( height(root.getRight().getLeft()) > height(root.getRight().getRight()) ) {
				rotateRight(root.getRight());
				rotateLeft(root);
			}else {
				rotateLeft(root);
			}					
		}
		else {
			return ;
		}
		
	}
	
//		�������
	public static void infixOrder(Node root) {
		if(root==null) {
			return ;
		}
		
		if(root.getLeft()!=null) {
			infixOrder(root.getLeft());
		}
		System.out.println(root.getValue());
		if(root.getRight()!=null) {
			infixOrder(root.getRight());
		}
	}
	
	
	
//	ͳ������
	public static int height(Node root) {
		if(root == null) {
			return 0;
		}
		return Math.max(root.getLeft()==null? 0:height(root.getLeft()), root.getRight()==null? 0:height(root.getRight()))+1;
	}
	
	
	
//	��������ת
	public static void rotateLeft(Node root) {
//		�����½ڵ�
		Node newNode = new Node(root.getValue());
//		�½ڵ��������  ��Ϊ��ǰ�ڵ��������
		newNode.setLeft(root.getLeft());
//		�½ڵ��������  ��Ϊ��ǰ�ڵ���������������
		newNode.setRight(root.getRight().getLeft());
//		����ǰ�Ľڵ��ֵ �޸�Ϊ��ǰ�ڵ���������ֵ
		root.setValue(root.getRight().getValue());
//		����ǰ�ڵ�������� �޸�Ϊ��ǰ�ڵ� ��������������
		root.setRight(root.getRight().getRight());	
//		����ǰ�ڵ�������� �޸�Ϊ�½ڵ�
		root.setLeft(newNode);
	}
	
//	��������ת
	public static void rotateRight(Node root) {
//		�����½ڵ�
		Node newNode = new Node(root.getValue());
//		�½ڵ��������  ��Ϊ��ǰ�ڵ����������������
		newNode.setLeft(root.getLeft().getRight());
//		�½ڵ��������  ��Ϊ��ǰ�ڵ�������
		newNode.setRight(root.getRight());
//		����ǰ�Ľڵ��ֵ �޸�Ϊ��ǰ�ڵ���������ֵ
		root.setValue(root.getLeft().getValue());
//		����ǰ�ڵ�������� �޸�Ϊ��ǰ�ڵ� ��������������
		root.setLeft(root.getLeft().getLeft());
//		����ǰ�ڵ�������� �޸�Ϊ�½ڵ�
		root.setRight(newNode);	
	}
}

//	����ڵ�
class Node{
	private int value;
	private Node left;
	private Node right;
	
	public Node(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
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
	
}
