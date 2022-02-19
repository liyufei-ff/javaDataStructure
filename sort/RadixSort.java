package com.lyf.sort;

import java.util.Arrays;

/*
 * 		基数排序 （此排序不能排带有负数的     但是可以经过改进实现）
 */
public class RadixSort {
	public static void main(String[] args) {
		int arr[] = {2333,1,2,66,96,333,333,333,6666};
		radixSort(arr);
	}
	
	public static void radixSort(int []arr) {
//		二维数组代表十个桶   桶最深为arr.length
		int [][]bucket = new int[10][arr.length];
//		一维数组 代表每个桶中数的个数
		int []counts = new int[10]; 
		
//		求出待排数中  位数的最大值
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if(max < arr[i]) {
				max =  arr[i];
			}
		}
		int weiMax = (max + "").length();
		

//		对每位进行排序
		for (int i = 0, n = 1; i < weiMax; i++ , n*=10) {
			for (int j = 0; j < arr.length; j++) {
				int yu = arr[j]/n%10;
				bucket[yu][counts[yu]] = arr[j];
				counts[yu]++;
			}
			
//			将桶中的数据  放回数组中
//			index = 0 千万不能定义在对每排序的外面  因为每一位排序执行完之后都要 将数据放回数组中  index都要从0开始  每一位排完序 往数组中放数据时index都要从零开始
			int index = 0;
			for (int j = 0; j < counts.length; j++) {
					for (int j2 = 0; j2 < counts[j]; j2++) {
						arr[index++] = bucket[j][j2];
//						数据放回之后 桶中要清除
						bucket[j][j2] = 0;
					}
				
//				每个桶放回完所有数据后    桶计数器 清空
				counts[j] = 0;
			}
			
			
		}
		System.out.println(Arrays.toString(arr));
		
	}
}
