package com.lyf.stack;
/*
 * 			链表实现栈
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

//	定义栈
class LinkedlistStack{
	private Node head;
	private int top = 0;
	private int MAXSIZE;
	
//	构造器
	public LinkedlistStack(int MAXSIZE) {
		this.MAXSIZE = MAXSIZE;
		head = new Node(0);
	}
	
//	判空
	public boolean isEmpty() {
		if(head.next == null) {
			return true;
		}else {
			return false;
		}
	}
	
//	判满
	public boolean isFull() {
		if(top == MAXSIZE) {
			return true;
		}else {
			return false;
		}
	}
	
//	入栈
	public void pushStack(int data) {
		if(isFull()) {
			System.out.println("栈已满");
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

//	出栈
	public int popStack() {
		if(isEmpty()) {
			System.out.println("栈为空");
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
	
//	显示栈中所有数据
	public void showStack() {
		if(isEmpty()) {
			System.out.println("栈为空");
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

//	定义节点
class Node{
//	数据域
	public int data;
//	指针域
	public Node next;
	
//	构造器
	public Node(int data){
		this.data = data;
	}

	@Override
	public String toString() {
		return "Node["+data+"]";
	}
	

}
