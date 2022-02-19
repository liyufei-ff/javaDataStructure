package com.lyf.test;

import java.util.Arrays;

/**
 * @author liyufei
 * @version 1.0.0
 * @ClassName HeapSort.java
 * @createTime 2021年03月24日 13:58:00
 */
// 堆排序(升序)  使用最大堆
public class HeapSort {
    public static void main(String[] args) {
        int []arr = {1,5,2,7,4,1000,0};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //堆排序（升序） 首先构建最大堆  然后删除堆顶元素再调整堆为最大堆循环操作直到删除完毕
    public static void heapSort(int []arr){
            buildMaxHeap(arr); //构建最大堆
        //删除堆顶元素 重新调整堆
        for (int i = arr.length-1; i >0 ; i--) {
            delMax(arr,i);
        }
    }

    //构建最大堆 由于传入的数组可以看做是一个不满足二叉堆性质的完全二叉树   将其进行调整为二叉堆
    //具体操作就是从第一个非叶子节点开始，遍历所有的非叶子节点进行下沉操作
    public static void buildMaxHeap(int []arr){
        for (int i = (arr.length-2)/2; i>=0; i--) {
            sink(arr,i,arr.length-1);
        }
    }

    public static void delMax(int []arr,int endIndex){
        int temp = arr[0];
        arr[0] = arr[endIndex];
        arr[endIndex] = temp;
        endIndex--;
        sink(arr,0,endIndex);
    }

    //下沉操作
    public static void sink(int[] arr,int p,int endIndex){
        while(p*2+1<=endIndex){
            int max = p*2+1;
            if(p*2+2<=endIndex){
                max = arr[max]<arr[p*2+2]?p*2+2:max;
            }
            if(arr[p]<arr[max]){
                int temp = arr[p];
                arr[p] = arr[max];
                arr[max] = temp;

                p = max;
            }else{
                break;
            }
        }
    }
}
