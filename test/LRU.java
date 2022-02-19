package com.lyf.test;

import java.util.HashMap;

/**
 * @author liyufei
 * @version 1.0.0
 * @ClassName LRU.java
 * @createTime 2021��03��24�� 19:36:00
 */
// ���㷨ʹ��һ����ϣ���һ��˫������
public class LRU {
    private HashMap<Integer,Node> map;
    private DoubleList list;
    private int cap; //LRU���������
    public LRU(int cap){
        this.cap = cap;
        map = new HashMap<>();
        list = new DoubleList();
    }

    //��ĳ��key����Ϊ��ʹ�õ�״̬
    public void makeRecently(int key){
        Node node = map.get(key); //�Ȼ�ȡ��Key���ڵĽڵ�
        list.removeNode(node); //ɾ���ڵ�
        list.addLast(node);//����ڵ�
    }

    //get����
    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        makeRecently(key);
        return map.get(key).val;
    }

    //put����
    public void put(int key,int val){
        if(map.containsKey(key)){
            map.get(key).val = val; //�滻ֵ
            makeRecently(key);//����ʹ�ù���key����Ϊ��ʹ�õ�״̬
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

//����˫������
class DoubleList{
    private Node head,tail; //˫�������ͷβ�ڵ�
    private int size; //˫�������е�Ԫ�ظ���

    public DoubleList(){
        //��β�ڵ�ֻ�Ǳ�־ ���洢����
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    //��˫������β����ӽڵ�
    public void addLast(Node node){
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
        size++;
    }

    //ɾ��ָ���ڵ�
    public void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
        size--;
    }

    //ɾ�������еĵ�һ���ڵ㲢�ҷ��ظýڵ�
    public Node removeFirstNode(){
        if(head==tail){
            return null;
        }
        Node first = head.next;
        removeNode(first);
        return first;
    }

    //����˫�������е�Ԫ�ظ���
    public int size(){
        return size;
    }
}

// �����еĽڵ�
class Node{
    public Node next,prev;
    public int key,val;
    public Node(int key,int val){
        this.key = key;
        this.val = val;
    }
}
