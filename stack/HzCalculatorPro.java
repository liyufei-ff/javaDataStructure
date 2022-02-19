package com.lyf.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/*
 *  使用后缀表达式建立计算器并且可以支持多位数的运算
 *  
 *  输入的后缀表达式  参与运算的数与字符之间要用空格隔开
 */
public class HzCalculatorPro{
	public static void main(String[] args) {
//		输入中缀表达式
		Scanner sc = new Scanner(System.in);
		String inExp = sc.nextLine();
		sc.close();
//		将中缀表达式存进List集合
		List<String> ls = crli(inExp);
		
//		中缀表达式转换为后缀表达式
		List<String> bs = inTohz(ls);
		
		
//		创建一个数字栈用于存放数字 字符串
		Stack<String> sta = new Stack<String>();
		
//		创建一个字符串数组用于存放分割后的表达式
//		String []split = hzExp.split(" ");
		
		int qnum = 0;
		int hnum = 0;
		int res  = 0;
		
//		遍历字符串表达式数组
		for (String bc : bs) {
			if(bc.matches("\\d+")) {
				sta.push(bc);
			}else {
				qnum = Integer.parseInt(sta.pop());
				hnum = Integer.parseInt(sta.pop());
				switch(bc) {
				case "+":
					res = hnum + qnum;
					break;
				case "-":
					res = hnum - qnum;
					break;
				case "*":
					res = hnum * qnum;
					break;
				case "/":
					res = hnum / qnum;
					break;
				default :
					System.out.println("参数有误");
					break;
				}
				
				sta.push(""+res);
			}
		}
		System.out.println(Integer.parseInt(sta.pop()));
	}

	
	
	
//	将中缀表达式转为后缀表达式   只需要一个栈 因为另一个栈始终没有弹出元素而且最后需要逆序输出所以可以不用栈  用List集合代替
	public static List<String> inTohz(List<String> li){
//		定义一个栈 一个集合
		Stack<String> s1 = new Stack<String>();
		List<String> ls = new ArrayList<String>();
		for (String ele : li) {
			if(ele.matches("\\d+")) {
				ls.add(ele);
			}else if(ele.equals("(")) {
				s1.push(ele);
			}else if(ele.equals(")")){
				while(!s1.peek().equals("(") ){
					ls.add(s1.pop());
				}
				s1.pop();
			}else {
//				与栈顶的运算符比较小于等于栈顶优先级  则栈顶元素弹出并进入ls  一直循环直到大于栈顶元素或者栈为空则进栈
				while(s1.size()!=0&&pri(ele)<=pri(s1.peek())) {
					ls.add(s1.pop());
				}
				s1.push(ele);
			}
		}
//		遍历完之后 将s1中所有的数据全部放进ls中
		while(s1.size()!=0) {
			ls.add(s1.pop());
		}
		return ls;
	}
	
	
	
	
//	判断运算符的优先级
	public static int  pri(String ele) {
		int y = -1;
		switch (ele) {
		case "+":
			y = 0;
			break;
		case "-":
			y = 0;
			break;
		case "*":
			y = 1;
			break;
		case "/":
			y = 1;
			break;
		default :
			y = -1;
			break;
		}
		return y;
	}
	
	
	
//	将输入的中缀表达式  存入list集合中 方便遍历使用
	public static List<String> crli(String inExp){
		List<String> li = new ArrayList<String>();
		int i  = 0;
		String keepNum = "";
		while(i<inExp.length()) {
			if(inExp.charAt(i) >= '0'&&inExp.charAt(i) <='9') {
				while(i < inExp.length()&&inExp.charAt(i) >= '0'&&inExp.charAt(i) <='9') {
					keepNum = keepNum + inExp.charAt(i);
					i++;
				}
				li.add(keepNum);
					keepNum ="";
				}else {
				li.add(""+inExp.charAt(i));
				i++;
			}
		}
		return li;
	}
}
