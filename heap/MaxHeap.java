package com.lyf.heap;

/**
 * @author liyufei
 * @version 1.0.0
 * @ClassName MaxHeap.java
 * @createTime 2021��03��19�� 19:40:00
 */
//����
public class MaxHeap<T extends Comparable<T>> {
    T []pq; //����ʵ�ʴ洢Ԫ�ص�����Ϊ����
    int N; //��¼����Ԫ�صĸ���

    public MaxHeap(int cap){
        pq = (T[]) new Comparable[cap+1]; //����Ϊ0�� λ�ò���ʹ��
        N = 0; //��ʼ��  �ſ�ʼ����û��Ԫ��
    }

    //���ضѶ������ֵ
    public T getMax(){
        return pq[1];
    }

    //����в���ֵ  �����   ������� Ȼ�������ϸ�
    public void insert(T value){
        pq[++N] = value;
        swim(N);
    }

    //ɾ�����ҷ��ضѶ�����Ԫ��
    public T delMax(){
        T re = pq[1];
        exchange(1,N); //�����Ѷ��Ͷѵ�Ԫ�� Ȼ���öѶ�Ԫ���³������ʵ�λ��
        N--;
        sink(1);
        return re;
    }


    //�³� ��ǰ�ڵ��ֵ��/�Һ���С �����и��ڵ㶼�������Ӻ��Ӵ�
    public void sink(int k){
        //��Ϊ����ȫ�������϶�������������һ����������
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

    //�ϸ�  ���ڵ��ϸ������ʵ�λ��   ������ ���ڵ�����Һ��Ӷ���
    public void swim(int k){
        while (parentIndex(k)>=1&&less(parentIndex(k),k)){
            exchange(parentIndex(k),k);
            k = parentIndex(k); //����k�ڵ��ֵ
        }
    }

    //���������ڵ��ֵ
    public void exchange(int m,int n){
        T temp = pq[m];
        pq[m] = pq[n];
        pq[n] = temp;
    }

    //�жϽڵ��ֵ˭С
    public boolean less(int j,int k){
        return pq[j].compareTo(pq[k])<0;
    }

    //���ص�ǰ����ڵ����������
    public int leftIndex(int nodeIndex){
        return nodeIndex*2;
    }

    //���ص�ǰ����ڵ���Һ�������
    public int rightIndex(int nodeIndex){
        return nodeIndex*2+1;
    }

    //���ص�ǰ����ڵ�ĸ��ڵ������
    public int parentIndex(int nodeIndex){
        return nodeIndex/2;
    }
}
