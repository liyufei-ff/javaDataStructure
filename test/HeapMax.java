package com.lyf.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author liyufei
 * @version 1.0.0
 * @ClassName HeapMax.java
 * @createTime 2021��03��24�� 13:19:00
 */
// ��������
public class HeapMax<T extends Comparable<T>> {

    int n = 0; //��¼���һ��Ԫ�ص��±�
    T []arr; //ʵ�ʴ洢Ԫ�ص�����

    public HeapMax(int cap){
        arr = (T[])new Comparable[cap];
    }


    //�鿴�Ѷ�Ԫ�ز��ҷ���
    public T peekMax(){
        return arr[0];
    }

    //�������
    public void insert(T value){
        arr[++n] = value;
        swim(n);
    }

    //ɾ���Ѷ�Ԫ�� �������һ��Ԫ�ؽ��н���Ȼ���ڽ���ɾ��  �ٽ��Ѷ�Ԫ���³�
    public void delMax(){
        T temp = arr[0];
        arr[0] = arr[n];
        arr[n] = temp;

        arr[n--] = null; //ɾ�� ����
        sink(0);  //�³��Ѷ�Ԫ��
    }


    //�ϸ����� ֻ��Ҫ�븸�ڵ�Ƚ�
    public void swim(int p){
        int parIndex = parIndex(p);
        while(p>0){
            if(less(parIndex,p)){
                T temp = arr[parIndex];
                arr[parIndex] = arr[p];
                arr[p] = temp;
                p = parIndex;
            }else{
                break;
            }
        }
    }

    //�³����� ����ǰ�ڵ��ֵ�����ҽڵ�Ƚ� �����Ҳ����ȫ��������˿϶������ӽڵ㲻һ�������ӽڵ�
    public void sink(int p){
        int max = leftIndex(p); //�ȼ������ӽڵ���� �������������ӽڵ㲢�ұ�������ȡ�ϴ��
        while(leftIndex(p)<=n){
            if(rightIndex(p)<=n){
                max = less(max,rightIndex(p))?rightIndex(p):max;
            }

            if(less(p,max)){
                T temp = arr[p];
                arr[p] = arr[max];
                arr[max] = temp;
                p = max;
            }else{
                break;
            }
        }
    }

    // �жϽڵ�m��ֵ�Ƿ�Ƚڵ�n��ֵС
    public boolean less(int m,int n){
        return arr[m].compareTo(arr[n])<0;
    }

    public int parIndex(int index){
        return (index-1)/2;
    }

    public int leftIndex(int index){
        return index*2+1;
    }

    public int rightIndex(int index){
        return index*2+2;
    }
}
