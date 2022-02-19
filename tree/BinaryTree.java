package com.lyf.tree;
/*
 * 		二叉树   前中后  序遍历
 */
public class BinaryTree {
	public static void main(String[] args) {
		Node root = new Node(1,"aa");
		Node n1 = new Node(2,"bb");
		Node n2 = new Node(3,"cc");
		Node n3 = new Node(4,"dd");
		Node n4 = new Node(5,"ee");
		
		root.setLeft(n1);
		root.setRight(n2);
		n1.setLeft(n3);
		n1.setRight(n4);
		
		int []arr = {1,2,3,4,5};
		BinaryTreeDemo bt = new BinaryTreeDemo(root);
		bt.arrPreOrder(arr, 0);
//		bt.delNode(root, 3);
//		bt.preOrder(root);
		
		
//		bt.preOrder(root);
//		System.out.println();
//		bt.infixOrder(root);
//		System.out.println();
//		bt.postOrder(root);
		
//		Node t = bt.postSearch(6,root);
//		if(t == null) {
//			System.out.println("没有找到");
//		}else {
//			System.out.println(t.toString());
//		}
		
	}
}

//		定义一个二叉树类
class BinaryTreeDemo{
	private Node root;
	
	public BinaryTreeDemo(Node root) {
		this.root = root;
	}
	
	
//	顺序存储二叉树的遍历
	public void arrPreOrder(int []arr , int index) {
		if(index<0||index>arr.length) {
			System.out.println("传入的参数有误");
		}
		
		System.out.println(arr[index]);
		
//		左递归
		if((index*2+1)<arr.length) {
			arrPreOrder(arr , index*2+1);
		}else {
			return ;
		}
		
//		右递归
		if((index*2+2)<arr.length) {
			arrPreOrder(arr , index*2+2);
		}else {
			return ;
		}
		
	}
	
//	先序遍历
	public void preOrder(Node root) {
		System.out.println(root.toString());
		
		if(root.getLeft()!=null) {
			preOrder(root.getLeft());
		}
		
		if(root.getRight()!=null) {
			preOrder(root.getRight());
		}
	}
	
//	中序遍历
	public void infixOrder(Node root) {
		
		if(root.getLeft()!=null) {
			infixOrder(root.getLeft());
		}
		
		System.out.println(root.toString());
		
		if(root.getRight()!=null) {
			infixOrder(root.getRight());
		}
	}
	
	
//	后序遍历
	public void postOrder(Node root) {
		
		if(root.getLeft()!=null) {
			postOrder(root.getLeft());
		}
		
		if(root.getRight()!=null) {
			postOrder(root.getRight());
		}
		System.out.println(root.toString());
	}
	
//	先序查找
//	不能在方法中使用this this始终代表的是调用当前方法的那个对象      递归后this代表的也是当前调用方法的对象
	public Node preSearch(int no , Node root) {
		Node temp = null;
		if(root.getNo()==no) {
			return root;
		}
//		遍历查找左子树
		if(root.getLeft()!=null) {
			temp = preSearch(no,root.getLeft());
		}
		if(temp!=null) {
			return temp;
		}
		
//		遍历查找右子树
		if(root.getRight()!=null) {
			temp = preSearch(no,root.getRight());
		}
//		查找完之后 直接返回temp  此时不需要判断temp是否为空  因为已经找到了最后
		return temp;
	}
	
	
	public Node infixSearch(int no , Node root) {
		Node temp = null;
	
//		遍历查找左子树
		if(root.getLeft()!=null) {
			temp = preSearch(no,root.getLeft());
		}
		if(temp!=null) {
			return temp;
		}
		
//		查找根节点
		if(root.getNo()==no) {
			return root;
		}
		
//		遍历查找右子树
		if(root.getRight()!=null) {
			temp = preSearch(no,root.getRight());
		}
//		查找完之后 直接返回temp  此时不需要判断temp是否为空  因为已经找到了最后
		return temp;
	}
	
	
	public Node postSearch(int no , Node root) {
		Node temp = null;

//		遍历查找左子树
		if(root.getLeft()!=null) {
			temp = preSearch(no,root.getLeft());
		}
		if(temp!=null) {
			return temp;
		}
		
//		遍历查找右子树
		if(root.getRight()!=null) {
			temp = preSearch(no,root.getRight());
		}
		if(temp!=null) {
			return temp;
		}
		
		
		if(root.getNo()==no) {
			return root;
		}
		
		return temp;
	}
	
//		删除节点
	public void delNode(Node root , int no) {
//		必须加上root! = null  不然有可能出现空指针异常
		if(root!=null&&root.getNo()==no) {
			root = null;
			return ;
		}
		
//		必须要加上root.getLeft()!=null   不然有可能会出先空指针异常
		if(root.getLeft()!=null&&root.getLeft().getNo()==no) {
			root.setLeft(null);
			return ;
		}
		
//		必须要加上root.getRight()!=null   不然有可能会出先空指针异常
		if(root.getRight()!=null&&root.getRight().getNo()==no) {
			root.setRight(null);
			return ;
		}
		
//		递归删除左节点
		if(root.getLeft()!=null) {
			delNode(root.getLeft(),no);
		}
		
//		递归删除右节点
		if(root.getRight()!=null) {
			delNode(root.getRight(),no);
		}
		
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
}


//		定义树的节点
class Node{
	private int no;
	private String name;
	private Node left;
	private Node right;
	private int leftType;
	private int rightType;
	
	
	public Node(int no , String name) {
		this.no = no;
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

//	重写toString()方法
	public String toString() {
		return "[Node:no:"+no+"name:"+name+"]";
	}

	public int getLeftType() {
		return leftType;
	}

	public void setLeftType(int leftType) {
		this.leftType = leftType;
	}

	public int getRightType() {
		return rightType;
	}

	public void setRightType(int rightType) {
		this.rightType = rightType;
	}
	
	
}
