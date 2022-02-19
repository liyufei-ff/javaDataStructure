package com.lyf.search;

import java.util.ArrayList;

/*
 * 		插值查找  			int mid = left+(right-left)*(findValue-arr[left])/(arr[right]-arr[left])
 * 		!!!数组必须要为有序数组
 */
public class InsertValueSearch {
	public static void main(String[] args) {
		int []arr = {1,2,3,3,6,6,6,6,6,6,6,6,6,6,8};
		ArrayList<Integer> al = insertValueSearch(arr,0,arr.length-1,6);
		
		if(al.size()==0) {
			System.out.println("没有找到");
		}else {
			System.out.println(al);
		}
		
		
	}
	
	
	public static ArrayList<Integer> insertValueSearch(int []arr , int left ,int right ,int value) {
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		if(left > right) {
			return new ArrayList<Integer>();
		}
		
	      int mid = left+(right-left)*(value-arr[left])/(arr[right]-arr[left]);
		
		if(arr[mid] > value) {									//		向左查找 如果找到了 返回找到的值
			return insertValueSearch(arr,left , mid -1 ,value);
		}else if(arr[mid] < value) {   							//		向右查找 如果找到了 返回找到的值
			return insertValueSearch(arr ,mid+1,right,value);
		}else {
			al.add(mid);
			int t = mid;
			while(true) {
				if(arr[mid-1] == value) {
					al.add(mid - 1);
					mid --;
				}else {
					break;
				}
			}
			mid = t;
			while(true) {
				if(arr[mid+1] == value) {
					al.add(mid + 1);
					mid ++;
				}else {
					break;
				}
			}
			
			return al;
		}
	}
}
