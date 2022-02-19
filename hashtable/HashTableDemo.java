package com.lyf.hashtable;
/*
 * 		��ϣ��
 */
public class HashTableDemo {
	public static void main(String[] args) {
		HashTable ht = new HashTable(6);
		
		Node node = new Node(3,18,"aaa");
		ht.add(node);
		
		Node node1 = new Node(9,19,"bbb");
		ht.add(node1);
		
		Node node2 = new Node(8,20,"bbb");
		ht.add(node2);
		
		Node node3= new Node(15,21,"bbb");
		ht.add(node3);
		ht.show();
	}
}


//	��ϣ��
class HashTable{
	private NodeLinkedList []arr;
	private int maxSize;
	
	
	public HashTable(int maxSize){
		this.maxSize = maxSize;
		arr = new NodeLinkedList[maxSize];
		
//		�������� ����֮�� ���е�Ԫ�س�ʼֵΪnull  ����Ҫ��ʼ������  ��Ȼnullֵ�޷������κ�����
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new NodeLinkedList();
		}
	}
	
//	��ϣɢ�к���
	public int  hashFun(int id) {
		return id%maxSize;
	}
	
//	���
	public void add(Node node) {
		arr[hashFun(node.getId())].add(node);
	}
	
//	�鿴
	public void show() {
		for (int i = 0; i < arr.length; i++) {
			arr[i].show();
		}
	}
}





//	����
class NodeLinkedList{
	private Node head;
	
	public NodeLinkedList() {
		
	}
	
	public void add(Node node){
		if(head==null) {
			head = node;
			return ;
		}
		
		Node temp = head;
		
		while(true) {
			if(temp.getNext()==null) {
				break;
			}
			
			temp = temp.getNext();
		}
		
//		ע�������ʹ�� setNext()��t.next����ֵ    �� getNext()�ǻ�ȡt.next��ֵ��   ��������Ҫ��next����ֵ
		temp.setNext(node);
	}
	
	public void show() {
		if(head==null) {
			System.out.println("����Ϊ�գ�");
			return ;
		}
		Node t  = head;
		while(true) {
			if(t.getNext()==null) {
				System.out.print(t.getId()+" "+t.getAge()+" "+t.getName());
				break;
			}else {
				System.out.print(t.getId()+" "+t.getAge()+" "+t.getName()+"->");
				t = t.getNext();
			}
		}
		System.out.println();
	}
	
	
}



//	�ڵ�
class Node{
	private int id;
	private int age;
	private String name;
	private Node next;

	public Node(int id ,int age ,String name) {
		this.id = id;
		this.age = age;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
}
