package com.lyf.stack;

import java.util.Scanner;

/*
 *  使用中缀表达式 利用栈建立计算器
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
		
//		遍历表达式并且进行入栈操作
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
//				如果判断出是数字就直接入栈 则会出现无法进行多位数的运算
//				判断出是数字之后再向后判断一位 如果是数字则拼接起来 如果不是数字则直接入栈
//				如果ope 已经是最后一位 则不需要判断就直接入栈
				
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
		
		
		
//		进行计算
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
	
//	构造器
	public ArrayStack1(int MAXSIZE ) {
		arr = new int[this.MAXSIZE = MAXSIZE];
	}
	
//	判空
	public boolean isEmpty() {
		if(top == -1) {
			return true;
		}else {
			return false;
		}
	}
	
//	判满
	public boolean isFull() {
		if(top == MAXSIZE-1) {
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
			top++;
			arr[top] = data;
		}
		
	}
	
//	出栈
	public int popStack() {
		if(isEmpty()) {
			System.out.println("栈已空");
			return -1;
		}else {
			int value = arr[top];
			top--;
			return value;
		}
	}
	
//	显示出栈顶数据
	public int showHead() {
		return arr[top];
	}
	
//	遍历栈
	public void showStack() {
		if(isEmpty()) {
			System.out.println("栈为空");
			return ;
		}else {
			for (int i = top; i >=0 ; i--) {
				System.out.printf("arr[%d] = %d\n",i,arr[i]);
			}
		}
	}
	
//	判断是否为运算符
	public boolean isOperator(int op) {
		if(op == '+' || op == '-' || op == '*' || op == '/') {
			return true;
		}else {
			return false;
		}
	}
	
//	用数字大小标注运算符的优先级，进而进行运算符优先级的比较
	public int priority(int op) {
		if(op == '*' || op == '/') {
			return 1;
		}else if(op == '+' || op == '-') {
			return 0;
		}else {
			
			return -1;
		}
	}
	
//	弹出两个数字和一个运算符进行计算
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
