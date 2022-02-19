package com.lyf.search;
/*
 *			二分查找
 */
public class BinarySearch {
	public static void main(String[] args) {
		int []arr = {1,3,2,6,5};
		int t = binarySearch(arr,0,arr.length-1,2);
		if(t==-1) {
			System.out.println("未找到");
		}else {
			System.out.println(t);
		}
	}
	
	public static int  binarySearch(int []arr,int left ,int right, int value) {
//		如果left > right 则该值不存在
		if(left > right) {
			return -1;
		}
		
		int mid = (left+right)/2;
		
		if(arr[mid] > value) {									//		向左查找 如果找到了 返回找到的值
			return binarySearch(arr,left , mid -1 ,value);
		}else if(arr[mid] < value) {   							//		向右查找 如果找到了 返回找到的值
			return binarySearch(arr ,mid+1,right,value);
		}else {
			return mid;
		}
		
	}
}
