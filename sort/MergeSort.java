package com.lyf.sort;

import java.util.Arrays;

/*
 *  	�鲢���򣨷����㷨��
 */
public class MergeSort {
	public static void main(String[] args) {
		int arr[] = {2,3,1,1,5,0};
		int temp[] = new int[5];
		mergeSort(arr,temp,0,4);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void mergeSort(int []arr,int []temp ,int left,int right) {
//		if(left<right) �����жϺ�ʱ������ɲ��ҽ���������жϱ�׼ ǧ�����٣����������û�����if ��������ֹ�������һֱ������ȥ���³������
		
		if(left<right) {
			int mid = (left+right)/2; //��ֵ�
			
//			�����
			mergeSort(arr,temp,left,mid);
			
//			���ұ�
			mergeSort(arr,temp,mid+1,right);
			
//			��ʼ�ϲ� (�ϲ��Ĺ���������)
			merge(arr,temp,left,mid,right);
		}

	}
	
	
	
	public static void merge(int []arr,int []temp,int left,int mid,int right) {
		int l = left;
		int r = mid+1;
		int t = 0;


		while(l<=mid&&r<=right) {
			if(arr[l]>arr[r]) {
				temp[t++] = arr[r++];
			}else {
				temp[t++] = arr[l++];
			}
		}

		while(l<=mid) {
			temp[t++] = arr[l++];
		}
		while(r<=right) {
			temp[t++] = arr[r++];
		}

//		��temp������arr��Ҳ���ǽ��ź���Ĳ��ַ���arr������
		t = 0;
		int tempLeft = left;
		while(tempLeft <= right) {
			arr[tempLeft++] = temp[t++];
		}
	}
}
