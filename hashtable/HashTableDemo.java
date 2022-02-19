package com.lyf.hashtable;
/*
 * 		哈希表
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


//	哈希表
class HashTable{
	private NodeLinkedList []arr;
	private int maxSize;
	
	
	public HashTable(int maxSize){
		this.maxSize = maxSize;
		arr = new NodeLinkedList[maxSize];
		
//		链表数组 创建之后 所有的元素初始值为null  必须要初始化处理  不然null值无法接受任何数据
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new NodeLinkedList();
		}
	}
	
//	哈希散列函数
	public int  hashFun(int id) {
		return id%maxSize;
	}
	
//	添加
	public void add(Node node) {
		arr[hashFun(node.getId())].add(node);
	}
	
//	查看
	public void show() {
		for (int i = 0; i < arr.length; i++) {
			arr[i].show();
		}
	}
}





//	链表
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
		
//		注意这里得使用 setNext()给t.next设置值    而 getNext()是获取t.next的值的   在这里是要给next设置值
		temp.setNext(node);
	}
	
	public void show() {
		if(head==null) {
			System.out.println("链表为空！");
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



//	节点
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
