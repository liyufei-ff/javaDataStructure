package com.lyf.test;

import java.util.LinkedHashMap;

/**
 * @author liyufei
 * @version 1.0.0
 * @ClassName LRU1.java
 * @createTime 2021��03��24�� 20:57:00
 */
// ʹ��LinkedHashMapʵ��LRU
public class LRU1 {
    private int cap;
    private LinkedHashMap<Integer,Integer> cache;

    public LRU1(int cap){
        this.cap = cap;
        cache = new LinkedHashMap<>();
    }

    //��Key����Ϊ��ʹ�ù���״̬
    public void makeRecently(int key){
        cache.remove(key);
        cache.put(key,cache.get(key));
    }

    //get����
    public int get(int key){
        if(!cache.containsKey(key)){
            return -1;
        }
        makeRecently(key); //��key����Ϊ��ʹ�õ�״̬
        return cache.get(key);
    }

    //put����
    public void put(int key,int val){
        if(cache.containsKey(key)){ //����������Ѿ��������滻ֵ ���ҽ���״̬����
            cache.put(key,val); //�滻ֵ
            makeRecently(key); //����״̬
        }
        if(cache.size()>=cap){// �жϿռ��Ƿ�����  ���˾�ɾ�����δʹ�õ�
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        cache.put(key,val);
    }
}
