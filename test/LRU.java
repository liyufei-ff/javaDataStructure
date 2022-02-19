package com.lyf.test;

import java.util.HashMap;

/**
 * @author liyufei
 * @version 1.0.0
 * @ClassName LRU.java
 * @createTime 2021年03月24日 19:36:00
 */
// 该算法使用一个哈希表和一个双向链表
public class LRU {
    private HashMap<Integer,Node> map;
    private DoubleList list;
    private int cap; //LRU的最大容量
    public LRU(int cap){
        this.cap = cap;
        map = new HashMap<>();
        list = new DoubleList();
    }

    //将某个key提升为才使用的状态
    public void makeRecently(int key){
        Node node = map.get(key); //先获取到Key对于的节点
        list.removeNode(node); //删除节点
        list.addLast(node);//插入节点
    }

    //get操作
    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        makeRecently(key);
        return map.get(key).val;
    }

    //put操作
    public void put(int key,int val){
        if(map.containsKey(key)){
            map.get(key).val = val; //替换值
            makeRecently(key);//将刚使用过的key提升为才使用的状态
            return;
        }
        if(cap>=list.size()){
            Node node = list.removeFirstNode();
            map.remove(node.key);
        }
        Node node = new Node(key,val);
            list.addLast(node);
            map.put(key,node);
    }
}

//定义双向链表
class DoubleList{
    private Node head,tail; //双向链表的头尾节点
    private int size; //双向链表中的元素个数

    public DoubleList(){
        //首尾节点只是标志 不存储数据
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    //在双向链表尾部添加节点
    public void addLast(Node node){
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
        size++;
    }

    //删除指定节点
    public void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
        size--;
    }

    //删除链表中的第一个节点并且返回该节点
    public Node removeFirstNode(){
        if(head==tail){
            return null;
        }
        Node first = head.next;
        removeNode(first);
        return first;
    }

    //返回双向链表中的元素个数
    public int size(){
        return size;
    }
}

// 链表中的节点
class Node{
    public Node next,prev;
    public int key,val;
    public Node(int key,int val){
        this.key = key;
        this.val = val;
    }
}
