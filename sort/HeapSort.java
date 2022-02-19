package com.lyf.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
//import java.util.Arrays;
import java.util.Date;

/*
 * 			堆排序
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
//		将顺序存储的二叉树   调整成大顶堆的形式   (实际上并没有使用树这个数据结构  而是构想出来的顺序存储的二叉树 )
		for (int j = length/2-1; j >=0 ; j--) {
			adjustHeap(arr,j,length);
		}
		
		int temp = 0;
//		进行将堆顶的元素放到 最后
		for (int j = length-1; j >= 0; j--) {
			temp = arr[j];
			arr[j] = arr[0];
			arr[0] = temp;
			adjustHeap(arr,0,j);
		}
	}
	
	
//	 对指定节点的树进行调整(升序排列就是大顶堆  降序排列就是小顶堆)
	public static void adjustHeap(int []arr,int i,int length) {
		int temp = arr[i];
		
		for (int k = 2*i+1; k < length; k=2*k+1) {
			if(k+1<length&&arr[k]<arr[k+1]) {
//				k指向右节点
				k++;
			}
			
			if(arr[i]<arr[k]) {
				arr[i] = arr[k];
//				！！！！！！！！！！i=k千万不能少  
					 i = k;
			}else {
				break;
			}
			arr[k] = temp;
		}
		
	}
}
