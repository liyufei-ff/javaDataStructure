package com.lyf.test;

import java.util.Arrays;

/**
 * @author liyufei
 * @version 1.0.0
 * @ClassName HeapSort.java
 * @createTime 2021��03��24�� 13:58:00
 */
// ������(����)  ʹ������
public class HeapSort {
    public static void main(String[] args) {
        int []arr = {1,5,2,7,4,1000,0};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //���������� ���ȹ�������  Ȼ��ɾ���Ѷ�Ԫ���ٵ�����Ϊ����ѭ������ֱ��ɾ�����
    public static void heapSort(int []arr){
            buildMaxHeap(arr); //��������
        //ɾ���Ѷ�Ԫ�� ���µ�����
        for (int i = arr.length-1; i >0 ; i--) {
            delMax(arr,i);
        }
    }

    //�������� ���ڴ����������Կ�����һ���������������ʵ���ȫ������   ������е���Ϊ�����
    //����������Ǵӵ�һ����Ҷ�ӽڵ㿪ʼ���������еķ�Ҷ�ӽڵ�����³�����
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

    //�³�����
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
