package com.lyf.binarysorttree;
/*
 * 		二叉排序数
 */
public class BinarySortTreeDemo {
	public static void main(String[] args) {
		int []arr = {1,3,2,0,9,6};
		Node root = new Node(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			add(root,new Node(arr[i]));
		}

		infixOrder(root);
	}
	
//	向二叉排序树中添加节点
	public static void add(Node root,Node node) {
		if(root==null) {
			root = node;
			return ;
		}
		if(node.getValue()<root.getValue()) {
			if(root.getLeft()==null) {
				root.setLeft(node);
			}else {
				add(root.getLeft(),node);
			}
		}else {
			if(root.getRight()==null) {
				root.setRight(node);
			}else {
				add(root.getRight(),node);
			}
		}
	}
	
//	中序遍历
	public static void infixOrder(Node root) {
		if(root == null) {
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
}
//	定义节点
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

	@Override
	public String toString() {
		return "Node["+value+"]";
	}
	
	
}
