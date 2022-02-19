package com.lyf.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author liyufei
 * @version 1.0.0
 * @ClassName HeapMax.java
 * @createTime 2021年03月24日 13:19:00
 */
// 构建最大堆
public class HeapMax<T extends Comparable<T>> {

    int n = 0; //记录最后一个元素的下标
    T []arr; //实际存储元素的数组

    public HeapMax(int cap){
        arr = (T[])new Comparable[cap];
    }


    //查看堆顶元素并且返回
    public T peekMax(){
        return arr[0];
    }

    //插入操作
    public void insert(T value){
        arr[++n] = value;
        swim(n);
    }

    //删除堆顶元素 先于最后一个元素进行交换然后在将其删除  再将堆顶元素下沉
    public void delMax(){
        T temp = arr[0];
        arr[0] = arr[n];
        arr[n] = temp;

        arr[n--] = null; //删除 操作
        sink(0);  //下沉堆顶元素
    }


    //上浮操作 只需要与父节点比较
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

    //下沉操作 将当前节点的值与左右节点比较 二叉堆也是完全二叉树因此肯定有左子节点不一定有右子节点
    public void sink(int p){
        int max = leftIndex(p); //先假设左子节点最大 如果后面存在右子节点并且比他大则取较大的
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

    // 判断节点m的值是否比节点n的值小
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
