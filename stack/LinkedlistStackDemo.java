package com.lyf.stack;
/*
 * 			����ʵ��ջ
 */
public class LinkedlistStackDemo {
	public static void main(String[] args) {
		LinkedlistStack ls = new LinkedlistStack(5);
		ls.pushStack(1);
		ls.pushStack(2);
		ls.pushStack(3);
		ls.pushStack(4);
		ls.pushStack(5);
		
		ls.showStack();
//		System.out.println(ls.popStack());
//		System.out.println(ls.popStack());
//		System.out.println(ls.popStack());
//		System.out.println(ls.popStack());
//		System.out.println(ls.popStack());
		
	}
}

//	����ջ
class LinkedlistStack{
	private Node head;
	private int top = 0;
	private int MAXSIZE;
	
//	������
	public LinkedlistStack(int MAXSIZE) {
		this.MAXSIZE = MAXSIZE;
		head = new Node(0);
	}
	
//	�п�
	public boolean isEmpty() {
		if(head.next == null) {
			return true;
		}else {
			return false;
		}
	}
	
//	����
	public boolean isFull() {
		if(top == MAXSIZE) {
			return true;
		}else {
			return false;
		}
	}
	
//	��ջ
	public void pushStack(int data) {
		if(isFull()) {
			System.out.println("ջ����");
			return ;
		}else {
			Node node = new Node(data);
			Node temp = head;
			while(true) {
				if(temp.next == null) {
					top++;
					temp.next = node;
					break;
				}else {
					temp = temp.next;
				}
			}
			
		}
	}

//	��ջ
	public int popStack() {
		if(isEmpty()) {
			System.out.println("ջΪ��");
			return -1;
		}else {
			Node temp = head;
			int value = 0;
			while(true) {
				if(temp.next.next == null) {
					value = temp.next.data;
					temp.next = null;
					top--;
					return value;
				}else {
					temp = temp.next;
				}
			}
			
		}
		
	}
	
//	��ʾջ����������
	public void showStack() {
		if(isEmpty()) {
			System.out.println("ջΪ��");
			return ;
		}else {
			int []arr = new int[top];
			Node temp = head;
			int i = 0;
			while(true) {
				if(temp.next == null) {
					break;
				}else {
					arr[i] = temp.next.data;
					i++;
					temp = temp.next;
				}
			}
			for (int j = top-1; j >= 0; j--) {
				System.out.println(arr[j]);
			}
			
		}
	}
	
}

//	����ڵ�
class Node{
//	������
	public int data;
//	ָ����
	public Node next;
	
//	������
	public Node(int data){
		this.data = data;
	}

	@Override
	public String toString() {
		return "Node["+data+"]";
	}
	

}
