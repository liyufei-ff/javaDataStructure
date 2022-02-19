package com.lyf.sort;

import java.util.Arrays;

/*
 *   —°‘Ò≈≈–Ú
 */
public class SelectSort {
	public static void main(String[] args) {
		int arr[] = new int[600];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*600)+1;
		}
		selectSort(arr);
	}
	
	
	public static void selectSort(int []arr) {
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}
}
