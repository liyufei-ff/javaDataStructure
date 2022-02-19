package com.lyf.search;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * 		쳲��������ң��ƽ�ָ���ң� ���ҵ�����Ҳ����ҪΪ�����
 */
public class FibonacciSearch {
	public static int maxSize = 20;
	public static void main(String[] args) {
		int []arr = {1,2,3,3,6,8,8,8,8,8,8};
		ArrayList<Integer> al = fibonacciSearch(arr,0,arr.length-1,8);
		System.out.println(al);
	}
	
//		����쳲���������
	public static int[] fibonacciSeq() {
		int []fib = new int[maxSize];
		fib[0] = 1;
		fib[1] = 1;
		for (int i = 2; i < fib.length; i++) {
			fib[i] = fib[i-1] + fib[i-2];
		}
		return fib;
	}
	
	public static ArrayList<Integer> fibonacciSearch(int []arr,int low,int hight,int value) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		int []fib = fibonacciSeq();
		int k = 0;
//		int mid = low+fib[k-1]-1	�ҵ� K��ֵ
		while(arr.length > fib[k]-1) {
			k++;
		}
		
//		��Ϊfib[k]-1 ���ܴ��� arr.length ��ԭ����arr���Ƶ�һ������Ϊfib[k]-1��������   ���ҽ�������Ĳ���  ȫ������Ϊ ԭ�������Ԫ�ص�ֵ	
		int temp[] = Arrays.copyOf(arr, fib[k]-1);
		
		for (int i = arr.length; i < temp.length; i++) {
			temp[i] = arr[arr.length-1];
		}
		
//		��ʼ���в���
		int mid = 0;
		while(low<=hight) {
			mid = low + fib[k-1]-1;
			
//			���ҽ��в���
			if(temp[mid] < value) {
				low = mid+1;
				k = k -2;
			}
//			������в���
			else if(temp[mid] > value) {			
				k--;
			}else {
//				��Ϊ��������������temp�н��е�   �����Ҳ��ҵĹ����� mid��ֵ����>=ԭ����hight��ֵ	
				int t = 0;
				if(mid < hight) {
					al.add(mid);
					 t = mid;
					while(true) {
						if(temp[mid-1]==value) {
							al.add(mid-1);
							mid --;
						}else {
							break;
						}
					}
					
					mid = t;
					while(true) {
						if(temp[mid+1]==value) {
							al.add(mid+1);
							
							if(mid+1==hight) {
								break;
							}else {
								mid++;
							}
							
						}else {
							break;
						}
					}
					return al;
				}else {
					while(true) {
						if(temp[hight-1]==value) {
							al.add(hight-1);
							hight --;
						}else {
							break;
						}
					}
					return al;
				}
			}
		}
		return new ArrayList<Integer>();
	}
}
