package com.lyf.heap;

/**
 * @author liyufei
 * @version 1.0.0
 * @ClassName MaxHeap.java
 * @createTime 2021年03月19日 19:40:00
 */
//最大堆
public class MaxHeap<T extends Comparable<T>> {
    T []pq; //堆中实际存储元素的容器为数组
    int N; //记录堆中元素的个数

    public MaxHeap(int cap){
        pq = (T[]) new Comparable[cap+1]; //索引为0的 位置不能使用
        N = 0; //初始化  才开始堆中没有元素
    }

    //返回堆顶的最大值
    public T getMax(){
        return pq[1];
    }

    //向堆中插入值  向插入   插入最后 然后让其上浮
    public void insert(T value){
        pq[++N] = value;
        swim(N);
    }

    //删除并且返回堆顶最大的元素
    public T delMax(){
        T re = pq[1];
        exchange(1,N); //交换堆顶和堆底元素 然后让堆顶元素下沉到合适的位置
        N--;
        sink(1);
        return re;
    }


    //下沉 当前节点的值左/右孩子小 最大堆中根节点都比左右子孩子大
    public void sink(int k){
        //因为是完全二叉树肯定有左子树但不一定有右子树
        while(leftIndex(k)<=N){
            int max = leftIndex(k);

            if(rightIndex(k)<=N){
                max = Math.max(max,rightIndex(k));
            }

            if(less(k,max)){
                exchange(k,max);
                k = max;
            }else{
                break;
            }
        }
    }

    //上浮  将节点上浮到合适的位置   最大堆中 根节点比左右孩子都大
    public void swim(int k){
        while (parentIndex(k)>=1&&less(parentIndex(k),k)){
            exchange(parentIndex(k),k);
            k = parentIndex(k); //更新k节点的值
        }
    }

    //交换两个节点的值
    public void exchange(int m,int n){
        T temp = pq[m];
        pq[m] = pq[n];
        pq[n] = temp;
    }

    //判断节点的值谁小
    public boolean less(int j,int k){
        return pq[j].compareTo(pq[k])<0;
    }

    //返回当前传入节点的左孩子索引
    public int leftIndex(int nodeIndex){
        return nodeIndex*2;
    }

    //返回当前传入节点的右孩子索引
    public int rightIndex(int nodeIndex){
        return nodeIndex*2+1;
    }

    //返回当前传入节点的根节点的索引
    public int parentIndex(int nodeIndex){
        return nodeIndex/2;
    }
}
