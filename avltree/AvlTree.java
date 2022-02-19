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
	
//	创建AvlTree
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
		
//		进行旋转
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
	
//		中序遍历
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
	
	
	
//	统计树高
	public static int height(Node root) {
		if(root == null) {
			return 0;
		}
		return Math.max(root.getLeft()==null? 0:height(root.getLeft()), root.getRight()==null? 0:height(root.getRight()))+1;
	}
	
	
	
//	进行左旋转
	public static void rotateLeft(Node root) {
//		创建新节点
		Node newNode = new Node(root.getValue());
//		新节点的左子树  就为当前节点的左子树
		newNode.setLeft(root.getLeft());
//		新节点的右子树  就为当前节点右子树的左子树
		newNode.setRight(root.getRight().getLeft());
//		将当前的节点的值 修改为当前节点右子树的值
		root.setValue(root.getRight().getValue());
//		将当前节点的右子树 修改为当前节点 右子树的右子树
		root.setRight(root.getRight().getRight());	
//		将当前节点的左子树 修改为新节点
		root.setLeft(newNode);
	}
	
//	进行右旋转
	public static void rotateRight(Node root) {
//		创建新节点
		Node newNode = new Node(root.getValue());
//		新节点的左子树  就为当前节点的左子树的右子树
		newNode.setLeft(root.getLeft().getRight());
//		新节点的右子树  就为当前节点右子树
		newNode.setRight(root.getRight());
//		将当前的节点的值 修改为当前节点左子树的值
		root.setValue(root.getLeft().getValue());
//		将当前节点的左子树 修改为当前节点 左子树的左子树
		root.setLeft(root.getLeft().getLeft());
//		将当前节点的右子树 修改为新节点
		root.setRight(newNode);	
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
	
}
