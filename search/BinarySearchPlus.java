package com.lyf.search;

import java.util.ArrayList;

/*
 * 		���Ҫ���ҵ��������������ж��  ����Խ����еĶ����ҳ���
 * 		!!!�������ҪΪ��������
 */
class BinarySearchPlus {
	public static void main(String[] args) {
		int []arr = {1,2,3,3,6,6,6,6,6,6,6,6,6,6,8};
		ArrayList<Integer> al = binarySearchPlus(arr,0,arr.length-1,6);
		
		if(al.size()==0) {
			System.out.println("û���ҵ�");
		}else {
			System.out.println(al);
		}
	}
	
	public static ArrayList<Integer> binarySearchPlus(int []arr , int left ,int right ,int value) {
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		if(left > right) {
			return new ArrayList<Integer>();
		}
		
			int mid = (left+right)/2;
			
		if(arr[mid] > value) {									//		������� ����ҵ��� �����ҵ���ֵ
			return binarySearchPlus(arr,left , mid -1 ,value);
		}else if(arr[mid] < value) {   							//		���Ҳ��� ����ҵ��� �����ҵ���ֵ
			return binarySearchPlus(arr ,mid+1,right,value);
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
