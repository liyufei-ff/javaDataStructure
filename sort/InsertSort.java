package com.lyf.sort;

import java.util.Arrays;

/*
 * 	 ≤Â»Î≈≈–Ú
 * 
 */
public class InsertSort {
	public static void main(String[] args) {
		int arr[] = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*10)+1;
		}
		insertSort(arr);
	}
	
	public static void insertSort(int[] arr) {
		int insertVal = 0;
		int insertIndex = 0;
		
		for (int i = 1; i < arr.length; i++) {
			insertVal = arr[i];
			insertIndex = i - 1;
			
			while(insertIndex >= 0 && insertVal > arr[insertIndex]) {
				arr[insertIndex + 1] = arr[insertIndex];
				insertIndex --;
			}
			arr[++insertIndex] = insertVal;
		}
		
		System.out.println(Arrays.toString(arr));
	}
}
