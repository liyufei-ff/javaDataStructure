package com.lyf.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
//import java.util.Arrays;
import java.util.Date;

/*
 * 			������
 */
public class HeapSort {
	public static void main(String[] args) {
		 SimpleDateFormat sld = new SimpleDateFormat("yyyy-MM-DD- HH:mm:ss");
			
			int arr[] = new int[100000000];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = (int)(Math.random()*100000000)+1;
			}
			
			Date qTime = new Date();
			System.out.println(sld.format(qTime));
			
			heapSort(arr,arr.length);
//			System.out.println(Arrays.toString(arr));

			Date hTime= new Date();
			System.out.println(sld.format(hTime));
	}
	
	
	public static void heapSort(int []arr,int length) {
//		��˳��洢�Ķ�����   �����ɴ󶥶ѵ���ʽ   (ʵ���ϲ�û��ʹ����������ݽṹ  ���ǹ��������˳��洢�Ķ����� )
		for (int j = length/2-1; j >=0 ; j--) {
			adjustHeap(arr,j,length);
		}
		
		int temp = 0;
//		���н��Ѷ���Ԫ�طŵ� ���
		for (int j = length-1; j >= 0; j--) {
			temp = arr[j];
			arr[j] = arr[0];
			arr[0] = temp;
			adjustHeap(arr,0,j);
		}
	}
	
	
//	 ��ָ���ڵ�������е���(�������о��Ǵ󶥶�  �������о���С����)
	public static void adjustHeap(int []arr,int i,int length) {
		int temp = arr[i];
		
		for (int k = 2*i+1; k < length; k=2*k+1) {
			if(k+1<length&&arr[k]<arr[k+1]) {
//				kָ���ҽڵ�
				k++;
			}
			
			if(arr[i]<arr[k]) {
				arr[i] = arr[k];
//				��������������������i=kǧ������  
					 i = k;
			}else {
				break;
			}
			arr[k] = temp;
		}
		
	}
}
