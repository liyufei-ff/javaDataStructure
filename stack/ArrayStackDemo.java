package com.lyf.stack;

public class ArrayStackDemo {
	public static void main(String[] args) {
		ArrayStack as = new ArrayStack(5);
		as.pushStack(1);
		as.pushStack(2);
		as.pushStack(3);
		as.pushStack(4);
		as.pushStack(5);
		as.showStack();
		System.out.println();
//		³öÕ»(È¡Õ»¶¥)
		System.out.println(as.popStack());
	}
}

class ArrayStack{
	private int MAXSIZE;
	private int [] arr;
	private int top = -1;
	
//	¹¹ÔìÆ÷
	public ArrayStack(int MAXSIZE ) {
		arr = new int[this.MAXSIZE = MAXSIZE];
	}
	
//	ÅÐ¿Õ
	public boolean isEmpty() {
		if(top == -1) {
			return true;
		}else {
			return false;
		}
	}
	
//	ÅÐÂú
	public boolean isFull() {
		if(top == MAXSIZE-1) {
			return true;
		}else {
			return false;
		}
	}
	
//	ÈëÕ»
	public void pushStack(int data) {
		if(isFull()) {
			System.out.println("Õ»ÒÑÂú");
			return ;
		}else {
			top++;
			arr[top] = data;
		}
		
	}
	
//	³öÕ»
	public int popStack() {
		if(isEmpty()) {
			System.out.println("Õ»ÒÑ¿Õ");
			return -1;
		}else {
			int value = arr[top];
			top--;
			return value;
		}
	}
	
//	±éÀúÕ»
	public void showStack() {
		if(isEmpty()) {
			System.out.println("Õ»Îª¿Õ");
			return ;
		}else {
			for (int i = top; i >=0 ; i--) {
				System.out.printf("arr[%d] = %d\n",i,arr[i]);
			}
		}
	}
}
