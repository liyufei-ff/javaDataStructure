package com.lyf.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/*
 *  交换式 希尔排序（交换法）
 */
public class JshellSort {
	 public static void main(String[] args) {
//		 SimpleDateFormat sld = new SimpleDateFormat("yyyy-MM-DD- HH:mm:ss");
//
//			int arr[] = new int[100000];
//			for (int i = 0; i < arr.length; i++) {
//				arr[i] = (int)(Math.random()*100000)+1;
//			}
//
//			Date qTime = new Date();
//			System.out.println(sld.format(qTime));
//
//			jshellSort(arr);
//
//			Date hTime= new Date();
//			System.out.println(sld.format(hTime));

		 int[] nums = {5,3,1,8};
		 jshellSort(nums);
		 System.out.println(Arrays.toString(nums));
	}
	 
	public static void jshellSort(int []arr) {
		int temp = 0;
//		分组的步数
		for (int grap = arr.length/2; grap >= 1; grap/=2) {
			
//			组内排序(交换式)
			for (int i = 0; i < arr.length - grap; i++) {
				for (int j = i; j >=0 ; j-=grap) {
					if(arr[j] > arr[j+grap]) {
						temp = arr[j];
						arr[j] = arr[j+grap];
						arr[j+grap] = temp;
					}
				}
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}
}
