package com.lyf.sort;

import java.util.Arrays;

/*
 *   ц╟ещеепР
 */
public class BubbleSort {
	public static void main(String[] args) {
		int arr[] = new int[6000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*6000)+1;
		}
		
		bubbleSort(arr);
	}
	
	public static void bubbleSort(int []arr) {
		boolean flag = true;
		for (int i = 0; i < arr.length-1&&flag; i++) {
			flag = false;
			for (int j = 0; j < arr.length-1-i; j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					flag = true;
				}
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}
}
