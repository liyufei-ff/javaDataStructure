package com.lyf.sort;

import java.util.Arrays;

/*
 * 		�������� �����������Ŵ��и�����     ���ǿ��Ծ����Ľ�ʵ�֣�
 */
public class RadixSort {
	public static void main(String[] args) {
		int arr[] = {2333,1,2,66,96,333,333,333,6666};
		radixSort(arr);
	}
	
	public static void radixSort(int []arr) {
//		��ά�������ʮ��Ͱ   Ͱ����Ϊarr.length
		int [][]bucket = new int[10][arr.length];
//		һά���� ����ÿ��Ͱ�����ĸ���
		int []counts = new int[10]; 
		
//		�����������  λ�������ֵ
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if(max < arr[i]) {
				max =  arr[i];
			}
		}
		int weiMax = (max + "").length();
		

//		��ÿλ��������
		for (int i = 0, n = 1; i < weiMax; i++ , n*=10) {
			for (int j = 0; j < arr.length; j++) {
				int yu = arr[j]/n%10;
				bucket[yu][counts[yu]] = arr[j];
				counts[yu]++;
			}
			
//			��Ͱ�е�����  �Ż�������
//			index = 0 ǧ���ܶ����ڶ�ÿ���������  ��Ϊÿһλ����ִ����֮��Ҫ �����ݷŻ�������  index��Ҫ��0��ʼ  ÿһλ������ �������з�����ʱindex��Ҫ���㿪ʼ
			int index = 0;
			for (int j = 0; j < counts.length; j++) {
					for (int j2 = 0; j2 < counts[j]; j2++) {
						arr[index++] = bucket[j][j2];
//						���ݷŻ�֮�� Ͱ��Ҫ���
						bucket[j][j2] = 0;
					}
				
//				ÿ��Ͱ�Ż����������ݺ�    Ͱ������ ���
				counts[j] = 0;
			}
			
			
		}
		System.out.println(Arrays.toString(arr));
		
	}
}
