package com.lyf.tree;
/*
 * 		������   ǰ�к�  �����
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
//			System.out.println("û���ҵ�");
//		}else {
//			System.out.println(t.toString());
//		}
		
	}
}

//		����һ����������
class BinaryTreeDemo{
	private Node root;
	
	public BinaryTreeDemo(Node root) {
		this.root = root;
	}
	
	
//	˳��洢�������ı���
	public void arrPreOrder(int []arr , int index) {
		if(index<0||index>arr.length) {
			System.out.println("����Ĳ�������");
		}
		
		System.out.println(arr[index]);
		
//		��ݹ�
		if((index*2+1)<arr.length) {
			arrPreOrder(arr , index*2+1);
		}else {
			return ;
		}
		
//		�ҵݹ�
		if((index*2+2)<arr.length) {
			arrPreOrder(arr , index*2+2);
		}else {
			return ;
		}
		
	}
	
//	�������
	public void preOrder(Node root) {
		System.out.println(root.toString());
		
		if(root.getLeft()!=null) {
			preOrder(root.getLeft());
		}
		
		if(root.getRight()!=null) {
			preOrder(root.getRight());
		}
	}
	
//	�������
	public void infixOrder(Node root) {
		
		if(root.getLeft()!=null) {
			infixOrder(root.getLeft());
		}
		
		System.out.println(root.toString());
		
		if(root.getRight()!=null) {
			infixOrder(root.getRight());
		}
	}
	
	
//	�������
	public void postOrder(Node root) {
		
		if(root.getLeft()!=null) {
			postOrder(root.getLeft());
		}
		
		if(root.getRight()!=null) {
			postOrder(root.getRight());
		}
		System.out.println(root.toString());
	}
	
//	�������
//	�����ڷ�����ʹ��this thisʼ�մ�����ǵ��õ�ǰ�������Ǹ�����      �ݹ��this�����Ҳ�ǵ�ǰ���÷����Ķ���
	public Node preSearch(int no , Node root) {
		Node temp = null;
		if(root.getNo()==no) {
			return root;
		}
//		��������������
		if(root.getLeft()!=null) {
			temp = preSearch(no,root.getLeft());
		}
		if(temp!=null) {
			return temp;
		}
		
//		��������������
		if(root.getRight()!=null) {
			temp = preSearch(no,root.getRight());
		}
//		������֮�� ֱ�ӷ���temp  ��ʱ����Ҫ�ж�temp�Ƿ�Ϊ��  ��Ϊ�Ѿ��ҵ������
		return temp;
	}
	
	
	public Node infixSearch(int no , Node root) {
		Node temp = null;
	
//		��������������
		if(root.getLeft()!=null) {
			temp = preSearch(no,root.getLeft());
		}
		if(temp!=null) {
			return temp;
		}
		
//		���Ҹ��ڵ�
		if(root.getNo()==no) {
			return root;
		}
		
//		��������������
		if(root.getRight()!=null) {
			temp = preSearch(no,root.getRight());
		}
//		������֮�� ֱ�ӷ���temp  ��ʱ����Ҫ�ж�temp�Ƿ�Ϊ��  ��Ϊ�Ѿ��ҵ������
		return temp;
	}
	
	
	public Node postSearch(int no , Node root) {
		Node temp = null;

//		��������������
		if(root.getLeft()!=null) {
			temp = preSearch(no,root.getLeft());
		}
		if(temp!=null) {
			return temp;
		}
		
//		��������������
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
	
//		ɾ���ڵ�
	public void delNode(Node root , int no) {
//		�������root! = null  ��Ȼ�п��ܳ��ֿ�ָ���쳣
		if(root!=null&&root.getNo()==no) {
			root = null;
			return ;
		}
		
//		����Ҫ����root.getLeft()!=null   ��Ȼ�п��ܻ���ȿ�ָ���쳣
		if(root.getLeft()!=null&&root.getLeft().getNo()==no) {
			root.setLeft(null);
			return ;
		}
		
//		����Ҫ����root.getRight()!=null   ��Ȼ�п��ܻ���ȿ�ָ���쳣
		if(root.getRight()!=null&&root.getRight().getNo()==no) {
			root.setRight(null);
			return ;
		}
		
//		�ݹ�ɾ����ڵ�
		if(root.getLeft()!=null) {
			delNode(root.getLeft(),no);
		}
		
//		�ݹ�ɾ���ҽڵ�
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


//		�������Ľڵ�
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

//	��дtoString()����
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
