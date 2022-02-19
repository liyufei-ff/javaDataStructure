package com.lyf.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/*
 *   希尔排序 （移位法）
 */
public class YshellSort {
	public static void main(String[] args) {
//		SimpleDateFormat sld = new SimpleDateFormat("yyyy-MM-DD- HH:mm:ss");
//
//		int arr[] = new int[100000];
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = (int)(Math.random()*100000)+1;
//		}
//
//		Date qTime = new Date();
//		System.out.println(sld.format(qTime));
//
//		yshellSort(arr);
//
//		Date hTime= new Date();
//		System.out.println(sld.format(hTime));

		int []nums = {4,2,3,1,6};
		yshellSort(nums);
		System.out.println(Arrays.toString(nums));

	}
	
	public static void yshellSort(int []arr) {
//			确定分组的步幅
		for (int grap = arr.length/2; grap>0; grap/=2) {
//			移位式 （和插入法原理类似 思想一样）
			for (int i = 0; i < arr.length-grap; i++) {
				int index = i+grap;
				int value = arr[i];

				if(arr[index]<arr[index-grap]){
					while(index<= arr.length-1 && arr[index]<value) {
						arr[index-grap] = arr[index];
						index+=grap;
					}
						arr[index-grap] = value;

				}

			}
		}

	}

//	public static void shellSort(int[] arr) {
//		int length = arr.length;
//		int temp;
//		for (int step = length / 2; step >= 1; step /= 2) {
//			for (int i = step; i < length; i++) {
//				temp = arr[i];
//				int j = i - step;
//				while (j >= 0 && arr[j] > temp) {
//					arr[j + step] = arr[j];
//					j -= step;
//				}
//				arr[j + step] = temp;
//			}
//		}
//	}


}
