package com.lyf.sort;

import java.security.spec.RSAOtherPrimeInfo;
import java.text.SimpleDateFormat;
//import java.util.Arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class QuickSort {
	public static void main(String[] args) {
//		 SimpleDateFormat sld = new SimpleDateFormat("yyyy-MM-DD- HH:mm:ss");
			
//			int arr[] = new int[1000000];
//			for (int i = 0; i < arr.length; i++) {
//				arr[i] = (int)(Math.random()*1000000)+1;
//			}
//
//			Date qTime = new Date();
//			System.out.println(sld.format(qTime));
//
//			quickSort1(arr,0,arr.length-1);
//			System.out.println(Arrays.toString(arr));
//
//			Date hTime= new Date();
//			System.out.println(sld.format(hTime));
//
			int []nums = { 5,3,2,7,8 };
			quicklySort1(nums,0,nums.length-1);
			System.out.println(Arrays.toString(nums));

	}
	
	public static void quicklySort1(int []arr, int indexLeft , int indexRight) {
		int l = indexLeft;
		int r = indexRight;
		int flag = arr[indexLeft];

		if(indexLeft<indexRight){
			while (l<r){
				while (l<r&&arr[r]>=flag){
					r--;
				}
				if(l<r){
					arr[l++] = arr[r];
				}

				while(l<r&&arr[l]<flag){
					l++;
				}
				if(l<r){
					arr[r--] = arr[l];
				}
			}

			arr[l] = flag;

			quicklySort1(arr,indexLeft,l-1);
			quicklySort1(arr,l+1,indexRight);

		}
	}


	public static void quicklySort(int indexLeft,int indexRight,int []array){
		int l = indexLeft;
		int r = indexRight;
		int flag = array[indexLeft];
		if(indexLeft<indexRight){
			while(l<r){
				while(l<r && array[r]>=flag){
					r--;
				}
				if(l<r){
					array[l++] = array[r];
				}

				while(l<r && array[l]< flag){
					l++;
				}
				if(l<r){
					array[r--] = array[l];
				}
			}
			array[l] = flag;

			quicklySort(indexLeft,l-1,array);
			quicklySort(l+1,indexRight,array);
		}
	}
}
