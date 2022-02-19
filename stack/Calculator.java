package com.lyf.stack;

import java.util.Scanner;

/*
 *  ʹ����׺���ʽ ����ջ����������
 */
public class Calculator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String exp = sc.nextLine();
		sc.close();
		
		int ope = ' ';
		int y1 = -1;
		int y2 = -1;
		int num1 = -1;
		int num2 = -1;
		int zf = ' ';
		int res = 0;
		String keepNum = "";
		
		ArrayStack1 numStack = new ArrayStack1(10);
		ArrayStack1 opStack = new ArrayStack1(10);
		
//		�������ʽ���ҽ�����ջ����
		for (int i = 0; i < exp.length(); i++) {
			ope = exp.charAt(i);
			if(numStack.isOperator(ope)) {
				if(opStack.isEmpty()) {
					opStack.pushStack(ope);
				}else {
					y1 = numStack.priority(ope);
					y2 = numStack.priority(opStack.showHead());
					if(y1 > y2) {
						opStack.pushStack(ope);
					}else {
						num1 = numStack.popStack();
						num2 = numStack.popStack();
						 zf  = opStack.popStack();
						 res = numStack.cal(num1, num2, zf);
						 numStack.pushStack(res);
						 opStack.pushStack(ope);
					}
				}
			}else {
//				����жϳ������־�ֱ����ջ �������޷����ж�λ��������
//				�жϳ�������֮��������ж�һλ �����������ƴ������ �������������ֱ����ջ
//				���ope �Ѿ������һλ ����Ҫ�жϾ�ֱ����ջ
				
				keepNum = keepNum+(ope-48);
				if(i == exp.length() -1) {
					numStack.pushStack(Integer.parseInt(keepNum));
				}else {
					if(numStack.isOperator(exp.charAt(i+1))) {
					numStack.pushStack(Integer.parseInt(keepNum));
					keepNum = "";
				}
				
			}
			
		 }
		}
		
		
		
//		���м���
		while(!opStack.isEmpty()) {
			num1 = numStack.popStack();
			num2 = numStack.popStack();
			 zf  = opStack.popStack();
			 res = numStack.cal(num1, num2, zf);
			 numStack.pushStack(res);
		}
		System.out.println("="+numStack.popStack());
	}
	
}

class ArrayStack1{
	private int MAXSIZE;
	private int [] arr;
	private int top = -1;
	
//	������
	public ArrayStack1(int MAXSIZE ) {
		arr = new int[this.MAXSIZE = MAXSIZE];
	}
	
//	�п�
	public boolean isEmpty() {
		if(top == -1) {
			return true;
		}else {
			return false;
		}
	}
	
//	����
	public boolean isFull() {
		if(top == MAXSIZE-1) {
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
			top++;
			arr[top] = data;
		}
		
	}
	
//	��ջ
	public int popStack() {
		if(isEmpty()) {
			System.out.println("ջ�ѿ�");
			return -1;
		}else {
			int value = arr[top];
			top--;
			return value;
		}
	}
	
//	��ʾ��ջ������
	public int showHead() {
		return arr[top];
	}
	
//	����ջ
	public void showStack() {
		if(isEmpty()) {
			System.out.println("ջΪ��");
			return ;
		}else {
			for (int i = top; i >=0 ; i--) {
				System.out.printf("arr[%d] = %d\n",i,arr[i]);
			}
		}
	}
	
//	�ж��Ƿ�Ϊ�����
	public boolean isOperator(int op) {
		if(op == '+' || op == '-' || op == '*' || op == '/') {
			return true;
		}else {
			return false;
		}
	}
	
//	�����ִ�С��ע����������ȼ�������������������ȼ��ıȽ�
	public int priority(int op) {
		if(op == '*' || op == '/') {
			return 1;
		}else if(op == '+' || op == '-') {
			return 0;
		}else {
			
			return -1;
		}
	}
	
//	�����������ֺ�һ����������м���
	public int cal(int num1 , int num2 , int op) {
			int result = 0;
		switch (op) {
		case '+':
			result = num2+num1;
			break ;
		case '-':
			result = num2 - num1;
			break ;
		case '*':
			result = num2*num1;
			break;
		case '/':
			result = num2/num1;
			break;
		default :
			break ;
		}
		return result;
	}
	
	
}
