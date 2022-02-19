package com.lyf.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/*
 *  ʹ�ú�׺���ʽ�������������ҿ���֧�ֶ�λ��������
 *  
 *  ����ĺ�׺���ʽ  ��������������ַ�֮��Ҫ�ÿո����
 */
public class HzCalculatorPro{
	public static void main(String[] args) {
//		������׺���ʽ
		Scanner sc = new Scanner(System.in);
		String inExp = sc.nextLine();
		sc.close();
//		����׺���ʽ���List����
		List<String> ls = crli(inExp);
		
//		��׺���ʽת��Ϊ��׺���ʽ
		List<String> bs = inTohz(ls);
		
		
//		����һ������ջ���ڴ������ �ַ���
		Stack<String> sta = new Stack<String>();
		
//		����һ���ַ����������ڴ�ŷָ��ı��ʽ
//		String []split = hzExp.split(" ");
		
		int qnum = 0;
		int hnum = 0;
		int res  = 0;
		
//		�����ַ������ʽ����
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
					System.out.println("��������");
					break;
				}
				
				sta.push(""+res);
			}
		}
		System.out.println(Integer.parseInt(sta.pop()));
	}

	
	
	
//	����׺���ʽתΪ��׺���ʽ   ֻ��Ҫһ��ջ ��Ϊ��һ��ջʼ��û�е���Ԫ�ض��������Ҫ����������Կ��Բ���ջ  ��List���ϴ���
	public static List<String> inTohz(List<String> li){
//		����һ��ջ һ������
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
//				��ջ����������Ƚ�С�ڵ���ջ�����ȼ�  ��ջ��Ԫ�ص���������ls  һֱѭ��ֱ������ջ��Ԫ�ػ���ջΪ�����ջ
				while(s1.size()!=0&&pri(ele)<=pri(s1.peek())) {
					ls.add(s1.pop());
				}
				s1.push(ele);
			}
		}
//		������֮�� ��s1�����е�����ȫ���Ž�ls��
		while(s1.size()!=0) {
			ls.add(s1.pop());
		}
		return ls;
	}
	
	
	
	
//	�ж�����������ȼ�
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
	
	
	
//	���������׺���ʽ  ����list������ �������ʹ��
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
