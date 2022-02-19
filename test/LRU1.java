package com.lyf.test;

import java.util.LinkedHashMap;

/**
 * @author liyufei
 * @version 1.0.0
 * @ClassName LRU1.java
 * @createTime 2021年03月24日 20:57:00
 */
// 使用LinkedHashMap实现LRU
public class LRU1 {
    private int cap;
    private LinkedHashMap<Integer,Integer> cache;

    public LRU1(int cap){
        this.cap = cap;
        cache = new LinkedHashMap<>();
    }

    //将Key提升为才使用过的状态
    public void makeRecently(int key){
        cache.remove(key);
        cache.put(key,cache.get(key));
    }

    //get操作
    public int get(int key){
        if(!cache.containsKey(key)){
            return -1;
        }
        makeRecently(key); //将key提升为才使用的状态
        return cache.get(key);
    }

    //put操作
    public void put(int key,int val){
        if(cache.containsKey(key)){ //如果集合中已经有了则替换值 并且将其状态提升
            cache.put(key,val); //替换值
            makeRecently(key); //提升状态
        }
        if(cache.size()>=cap){// 判断空间是否已满  满了就删除最久未使用的
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        cache.put(key,val);
    }
}
