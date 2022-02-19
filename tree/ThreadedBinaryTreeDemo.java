package com.lyf.tree;
/*
 * 			������������
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
	
	
//	����������������
//	!!!!!!!!!!�� ǧ������ �����Ĳ��������pre  ��Ϊ�����������Ĺ������õ���ͬһ��pre ����в��� �����ÿ�ݹ�һ�ξͻ�ʹ��һ��pre
	public void infixThreadedBinaryTree(Node node) {

//		���Ҫ�������Ľڵ�Ϊ��  ���޷�������
		if(node==null) {
			return ;
		}
		
/*
 * 		1.��������������
 * 		2.���������ڵ�����
 * 		3.���������������
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
//		ÿ����һ���ڵ�  ��ִ��pre = node;
		pre = node;
		
		infixThreadedBinaryTree(node.getRight());
		
	}
	
	
	
	
//	����������������
//	!!!!!!!!!!�� ǧ������ �����Ĳ��������pre  ��Ϊ�����������Ĺ������õ���ͬһ��pre ����в��� �����ÿ�ݹ�һ�ξͻ�ʹ��һ��pre
	public void preThreadedBinaryTree(Node node) {

//		���Ҫ�������Ľڵ�Ϊ��  ���޷�������
		if(node==null) {
			return ;
		}
		
/*
 * 		1.�������ڵ�����
 * 		2.������������
 * 		3.������������
 */
		
		if(node.getLeft()==null) {
			node.setLeft(pre);
			node.setLeftType(1);
		}
		if(pre!=null && pre.getRight()==null) {
			pre.setRight(node);
			pre.setRightType(1);
		}
//		ÿ����һ���ڵ�  ��ִ��pre = node;
		pre = node;
		
//		����Ҫ��if(node.getRightType()==0) �ж����� ����Ѿ�������������Ҫ����������
		if(node.getLeftType()==0) {
			preThreadedBinaryTree(node.getLeft());
		}
		
		
			preThreadedBinaryTree(node.getRight());	
		
	}
	
	
	
//	����������������
//	!!!!!!!!!!�� ǧ������ �����Ĳ��������pre  ��Ϊ�����������Ĺ������õ���ͬһ��pre ����в��� �����ÿ�ݹ�һ�ξͻ�ʹ��һ��pre
	public void postThreadedBinaryTree(Node node) {

//		���Ҫ�������Ľڵ�Ϊ��  ���޷�������
		if(node==null) {
			return ;
		}
		
/*
 * 		1.������������
 * 		2.������������
 * 		3.�������ڵ�����
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
//		ÿ����һ���ڵ�  ��ִ��pre = node;
		pre = node;
	}
	

//	�������������������Ķ�����
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
	
	
//	������������������֮���������������
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