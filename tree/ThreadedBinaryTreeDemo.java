package com.lyf.tree;
/*
 * 			线索化二叉树
 */
public class ThreadedBinaryTreeDemo {
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
		
		ThreadedBinaryTree tb = new ThreadedBinaryTree(root);
				
		tb.preThreadedBinaryTree(root);
		System.out.println(n3.getRight().toString());
//		tb.showPreThrBinTree(root);

		
	}
}

class ThreadedBinaryTree{
	private Node root;
	private Node pre;
	public ThreadedBinaryTree(Node root) {
		this.root = root;
	}
	
	
//	中序线索化二叉树
//	!!!!!!!!!!！ 千万不能在 函数的参数中添加pre  因为整个线索化的过程中用的是同一个pre 如果有参数 则就是每递归一次就会使用一个pre
	public void infixThreadedBinaryTree(Node node) {

//		如果要线索化的节点为空  则无法线索化
		if(node==null) {
			return ;
		}
		
/*
 * 		1.先线索化左子树
 * 		2.再线索化节点自身
 * 		3.最后线索化右子树
 */
		infixThreadedBinaryTree(node.getLeft());
		
		if(node.getLeft()==null) {
			node.setLeft(pre);
			node.setLeftType(1);
		}
		
		if(pre!=null && pre.getRight()==null) {
			pre.setRight(node);
			pre.setRightType(1);
		}
//		每处理一个节点  就执行pre = node;
		pre = node;
		
		infixThreadedBinaryTree(node.getRight());
		
	}
	
	
	
	
//	先序线索化二叉树
//	!!!!!!!!!!！ 千万不能在 函数的参数中添加pre  因为整个线索化的过程中用的是同一个pre 如果有参数 则就是每递归一次就会使用一个pre
	public void preThreadedBinaryTree(Node node) {

//		如果要线索化的节点为空  则无法线索化
		if(node==null) {
			return ;
		}
		
/*
 * 		1.线索化节点自身
 * 		2.线索化左子树
 * 		3.线索化右子树
 */
		
		if(node.getLeft()==null) {
			node.setLeft(pre);
			node.setLeftType(1);
		}
		if(pre!=null && pre.getRight()==null) {
			pre.setRight(node);
			pre.setRightType(1);
		}
//		每处理一个节点  就执行pre = node;
		pre = node;
		
//		必须要加if(node.getRightType()==0) 判断条件 如果已经线索化了则不需要继续进行了
		if(node.getLeftType()==0) {
			preThreadedBinaryTree(node.getLeft());
		}
		
		
			preThreadedBinaryTree(node.getRight());	
		
	}
	
	
	
//	后序线索化二叉树
//	!!!!!!!!!!！ 千万不能在 函数的参数中添加pre  因为整个线索化的过程中用的是同一个pre 如果有参数 则就是每递归一次就会使用一个pre
	public void postThreadedBinaryTree(Node node) {

//		如果要线索化的节点为空  则无法线索化
		if(node==null) {
			return ;
		}
		
/*
 * 		1.线索化左子树
 * 		2.线索化右子树
 * 		3.线索化节点自身
 */
		postThreadedBinaryTree(node.getLeft());
		
		postThreadedBinaryTree(node.getRight());
		
		if(node.getLeft()==null) {
			node.setLeft(pre);
			node.setLeftType(1);
		}
		if(pre!=null && pre.getRight()==null) {
			pre.setRight(node);
			pre.setRightType(1);
		}
//		每处理一个节点  就执行pre = node;
		pre = node;
	}
	

//	遍历经过中序线索化的二叉树
	public void showInfixThrBinTree(Node root) {
		Node node = root;
		while(node!=null) {
			while(node.getLeftType()==0) {
				node = node.getLeft();
			}
			
			System.out.println(node.toString());
			
			while(node.getRightType()==1) {
				node = node.getRight();
				System.out.println(node.toString());
			}
			
			node = node.getRight();
		}
	}
	
	
//	遍历经过先序线索化之后的线索化二叉树
//	public void showPreThrBinTree(Node root) {
//		Node node = root;
//		while(node!=null) {
//			System.out.println(node.toString());
//			node = node.getLeft();
//			if(node!=null&&node.getRightType()==1) {
//				System.out.println(node.toString());
//				while(node.getRightType()==1) {
//					node = node.getRight();
//					System.out.println(node.toString());
//				}
//			}
//			node = node.getLeft();
//		}
//	}
	
	

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
}