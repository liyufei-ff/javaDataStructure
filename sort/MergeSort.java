package com.lyf.sort;

import java.util.Arrays;

/*
 *  	归并排序（分治算法）
 */
public class MergeSort {
	public static void main(String[] args) {
		int arr[] = {2,3,1,1,5,0};
		int temp[] = new int[5];
		mergeSort(arr,temp,0,4);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void mergeSort(int []arr,int []temp ,int left,int right) {
//		if(left<right) 这是判断何时分组完成并且结束分组的判断标准 千万不能少！！！！如果没有这个if 将会无休止无意义的一直分组下去导致程序出错
		
		if(left<right) {
			int mid = (left+right)/2; //拆分点
			
//			分左边
			mergeSort(arr,temp,left,mid);
			
//			分右边
			mergeSort(arr,temp,mid+1,right);
			
//			开始合并 (合并的过程中排序)
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

//		将temp拷贝到arr中也就是将排好序的部分放入arr数组中
		t = 0;
		int tempLeft = left;
		while(tempLeft <= right) {
			arr[tempLeft++] = temp[t++];
		}
	}
}
