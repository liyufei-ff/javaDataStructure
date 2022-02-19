package com.lyf.search;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * 		斐波那契查找（黄金分割法查找） 查找的数组也必须要为有序的
 */
public class FibonacciSearch {
	public static int maxSize = 20;
	public static void main(String[] args) {
		int []arr = {1,2,3,3,6,8,8,8,8,8,8};
		ArrayList<Integer> al = fibonacciSearch(arr,0,arr.length-1,8);
		System.out.println(al);
	}
	
//		创建斐波那契数列
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
//		int mid = low+fib[k-1]-1	找到 K的值
		while(arr.length > fib[k]-1) {
			k++;
		}
		
//		因为fib[k]-1 可能大于 arr.length 将原数组arr复制到一个长度为fib[k]-1的新数组   并且将多出来的部分  全部设置为 原数组最后元素的值	
		int temp[] = Arrays.copyOf(arr, fib[k]-1);
		
		for (int i = arr.length; i < temp.length; i++) {
			temp[i] = arr[arr.length-1];
		}
		
//		开始进行查找
		int mid = 0;
		while(low<=hight) {
			mid = low + fib[k-1]-1;
			
//			向右进行查找
			if(temp[mid] < value) {
				low = mid+1;
				k = k -2;
			}
//			向左进行查找
			else if(temp[mid] > value) {			
				k--;
			}else {
//				因为查找是在新数组temp中进行的   在向右查找的过程中 mid的值可能>=原数组hight的值	
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
