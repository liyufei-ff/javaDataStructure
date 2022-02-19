package com.lyf.search;
/*
 *			���ֲ���
 */
public class BinarySearch {
	public static void main(String[] args) {
		int []arr = {1,3,2,6,5};
		int t = binarySearch(arr,0,arr.length-1,2);
		if(t==-1) {
			System.out.println("δ�ҵ�");
		}else {
			System.out.println(t);
		}
	}
	
	public static int  binarySearch(int []arr,int left ,int right, int value) {
//		���left > right ���ֵ������
		if(left > right) {
			return -1;
		}
		
		int mid = (left+right)/2;
		
		if(arr[mid] > value) {									//		������� ����ҵ��� �����ҵ���ֵ
			return binarySearch(arr,left , mid -1 ,value);
		}else if(arr[mid] < value) {   							//		���Ҳ��� ����ҵ��� �����ҵ���ֵ
			return binarySearch(arr ,mid+1,right,value);
		}else {
			return mid;
		}
		
	}
}
