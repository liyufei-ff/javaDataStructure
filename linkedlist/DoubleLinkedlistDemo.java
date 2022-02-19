package com.lyf.linkedlist;

public class DoubleLinkedlistDemo {
	public static void main(String[] args) {
		DoubleLinkedlist dlist = new DoubleLinkedlist();
		
		Dnode hero1 = new Dnode(1,"lll","111");
		Dnode hero2 = new Dnode(2,"qqq","222");
		Dnode hero3 = new Dnode(3,"aaa","333");
		Dnode hero4 = new Dnode(4,"ddd","444");
		
		dlist.add(hero1);
		dlist.add(hero2);
		dlist.add(hero3);
		dlist.add(hero4);
		
		dlist.show(dlist.getHead());
		System.out.println();
		
		Dnode data = new Dnode(1,"xxx","mmm");
		dlist.update(data);
		dlist.show(dlist.getHead());
		
		System.out.println();
//		dlist.deleteBynum(4);
//		dlist.show(dlist.getHead());
		
		System.out.println(dlist.length());
		
		System.out.println();
		
		Dnode dd = new Dnode(100,"asd","xzc");
		dlist.addBynum(3, dd);
		dlist.show(dlist.getHead());
	}
}

//	双向链表类
class DoubleLinkedlist{
//	创建头节点
	private Dnode head = new Dnode(0,"","");
//	无参构造
	public DoubleLinkedlist() {
		
	}
	
//	获取头结点
	public Dnode getHead() {
		return head;
	}

//	向双向链表最后添加节点
	public void add(Dnode node) {
		if(head.next == null) {
			head.next = node;
			return ;
		}
		
		Dnode temp = head.next;
		while(true) {
			if(temp.next == null) {
				temp.next = node;
				node.prime = temp;
				break;
			}
			temp = temp.next;
		}
	}
	
//	按照序号在指定的位置添加节点
	public void addBynum(int index,Dnode node) {
		if(head.next == null) {
			System.out.println("此双向链表为空");
			return ;
		}
		
		Dnode temp = head.next;
		int count = length();
		if(index<0 || index>count) {
			System.out.println("不存在此位置的节点");
			return ;
		}
		
		for (int i = 0; i < index-1; i++) {
			temp = temp.next;
		}
		
		node.next = temp;
		temp.prime.next = node;
		node.prime = temp.prime;
		temp.prime = node;
		
	}
	
//	修改双向链表中的节点数据
	public void update(Dnode data) {
		if(head.next == null) {
			System.out.println("此双向链表为空链表");
			return ;
		}
		
		Dnode temp = head.next;
		while(true) {
			if(temp == null) {
				System.out.println("没有找到要修改的节点");
				break ;
			}else if(temp.no == data.no) {
				temp.name = data.name;
				temp.nickName = data.nickName;
				break;
			}else {
				temp = temp.next;
			}
		}
	}
	
//	删除双向链表中的指定的节点
	public void deleteBynum(int index) {
		if(head.next == null) {
			System.out.println("此双向链表为空");
			return ;
		}
		
		Dnode temp = head.next;
		while(true) {
			if(temp == null) {
				System.out.println("没要找到要删除的节点");
				return ;
			}else if(temp.no == index) {
				temp.prime.next = temp.next;
				if(temp.next!=null) {
					temp.next.prime = temp.prime;
				}
				break;
			}else {
				temp = temp.next;
			}
		}
	}
	
//	显示双向链表
	public void show(Dnode head) {
		if(head.next == null) {
			System.out.println("此双向链表为空");
			return ;
		}
		
		Dnode temp = head.next;
		while(temp!=null) {
			System.out.println(temp.tosString());
			temp = temp.next;
		}
	}
	
//	 统计双向链表中的有效节点
	public int length() {
		if(head.next == null) {
			System.out.println("此双向链表为空");
			return 0;
		}
		
		Dnode temp = head.next;
		int count = 0;
		while(temp!=null) {
			count++;
			temp = temp.next;
		}
		return count;
	}
	
}

//	节点类
class Dnode{
//	数据域
	public int no;
	public String name;
	public String nickName;
//	指针域
	public Dnode prime;
	public Dnode next;
//	构造器
	public Dnode(int no , String name ,String nickName) {
		this.no = no;
		this.name = name;
		this.nickName = nickName;
	}
	
//	重写toString();
	public String tosString() {
		return "Dnode [no=" + no + ", name=" + name + ", nickname=" + nickName + "]";
	}
}
