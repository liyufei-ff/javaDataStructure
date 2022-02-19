package com.lyf.stack;

import java.util.Scanner;

/*
 * 	使用后缀表达式，进行计算  建立计算器  只能进行一位数字的加减乘除运算
 */
public class HzCalculator {
	public static void main(String[] args) {
//		创建一个栈用来存放数字
		ArrayStack1 sta = new ArrayStack1(10);
		Scanner sc = new Scanner(System.in);
		String hzExp = sc.nextLine();
		sc.close();
		char[] c = hzExp.toCharArray();
		int qnum = 0;
		int hnum = 0;
		int res = 0;
		for (int i = 0; i < c.length; i++) {
			if(sta.isOperator(c[i])) {
					qnum = sta.popStack();
					hnum = sta.popStack();
					res = sta.cal(qnum, hnum, c[i]);
					sta.pushStack(res);
			}else {

				sta.pushStack(c[i] - 48);
			}
		}
		System.out.println(sta.popStack());
	}
}

