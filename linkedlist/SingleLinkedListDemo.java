package com.lyf.linkedlist;

import java.util.Stack;

/*
 * 	  使用链表存储水浒英雄的信息
 */
public class SingleLinkedListDemo {
	public static void main(String[] args) {
//		创建四个节点
		HeroNode hero1 = new HeroNode(1,"lll","111");
		HeroNode hero2 = new HeroNode(2,"qqq","222");
		HeroNode hero3 = new HeroNode(3,"aaa","333");
		HeroNode hero4 = new HeroNode(4,"ddd","444");
//		创建链表
		SingleLinkedList list = new SingleLinkedList();

//		向链表中添加节点
		list.addNode(hero1);
		list.addNode(hero2);
		list.addNode(hero3);
		list.addNode(hero4);
		
//		按照序号顺序向单链表中添加数据
		list.addByNum(hero2);
		list.addByNum(hero1);
		list.addByNum(hero4);
		list.addByNum(hero3);
	


		
		list.showList();
		System.out.println("修改后的单链表为：");
		
//		修改单链表中的节点数据
		HeroNode newNode = new HeroNode(4,"DDD","四四四");

		list.update(newNode);
		
//		显示链表
		list.showList();
		
//		删除单链表中的指定节点
		list.delete(1);
		list.delete(4);
		list.delete(2);
		list.delete(3);
		
		System.out.println("删除后的单链表为：");
		list.showList();
		
//		查询链表中的节点
		list.look(2);
		
//		统计单链表中有效节点的个数
		System.out.println("单链表中有效节点的个数为:"+SingleLinkedList.length(list.getHead()));
		
//		查找单链表中倒数第K个节点
		System.out.print("链表中倒数第K个节点为： ");
		SingleLinkedList.lookBynum(list.getHead(), 3);
//		
//		反转单链表
		SingleLinkedList.reverse(list.getHead());
		list.showList();
		
//		从尾到头打印单链表
		SingleLinkedList.reversePrint(list.getHead());
		
		
		
	}
}



//	创建含头结点的单链表
class SingleLinkedList{
//	创建头结点
	private HeroNode head = new HeroNode(0,"","");
//	无参构造
	public SingleLinkedList() {
		
	}
//	返回头结点
	public HeroNode getHead() {
		return head;
	}
	
//	向链表中添加结点
	public void addNode(HeroNode node) {
		if(head.next==null) {
			head.next = node;
		}else {
//			创建一个中间节点
			HeroNode temp = head;
			while(temp.next!=null) {
				temp = temp.next;
			}
			temp.next = node;
		}
	}
	
//	按照序号向单链表中添加数据
	public void addByNum(HeroNode node) {
//		立一个标识，标识单链表中是否已经存在要加入的元素
		boolean flag = false;
		HeroNode temp = head;
		while(true){
			if(temp.next==null) {
				flag  = false;
				break;
			}else if(temp.next.no > node.no) {
				flag  = false;
				break;
			}else if(temp.next.no == node.no){
				flag = true;
				break;
			}
			
			temp = temp.next;
		}
		
		if(flag) {
			System.out.println("数据单链表中已经存在");
		}else {
			node.next = temp.next;
			temp.next = node;
		}
	}
	
//	按照序号删除单链表中的节点
	public void delete(int num) {
		if(head.next == null) {
			System.out.println("链表为空！！");
			return ;
		}
		HeroNode temp = head;
		while(true) {
			if(temp.next == null) {
				System.out.println("没有找到要删除的节点");
				return ;
			}else if(temp.next.no == num) {
				temp.next = temp.next.next;
				return ;
			}
			temp = temp.next;
		}
	}
	
//	按照序号查询链表中的节点
	public void look(int num) {
		if(head.next == null) {
			System.out.println("此链表为空");
			return ;
		}
		HeroNode temp = head;
		while(true) {
			if(temp.next == null) {
				System.out.println("没有找到要查看的节点");
				return ;
			}else if(temp.next.no == num) {
				System.out.println("查询到的节点为： "+temp.next.toString());
				return ;
			}
			temp = temp.next;
		}
	}
	
//	修改单链表中的数据
	public void update(HeroNode newNode) {
		if(head.next == null ) {
			System.out.println("此链表为一个空链表");
			return ;
		}
		HeroNode temp = head;
		while(true) {
		if(temp.next == null) {
			System.out.println("没有找到要修改的节点");
			break;
		}else if(temp.next.no == newNode.no) {
			temp.next.name = newNode.name;
			temp.next.nickName = newNode.nickName;
			return ;
		}
			temp = temp.next;
		}
	}

//	遍历链表
	public void showList(){
		HeroNode temp = head;
		while(true) {
			if(temp.next!=null) {
				System.out.println(temp.next.toString());
			}else {
				break;
			}
			temp = temp.next;
		}
	}
	
//	统计单链表中有效节点的个数
	public static int length(HeroNode head) {
		if(head.next == null) {
			return 0;
		}
		int count = 0;
		HeroNode temp = head;
		while(temp.next!=null) {
			count++;
			temp = temp.next;
		}
		return count;
	}
	
//	查找单链表中倒数第K个节点（新浪面试题）
	public static void lookBynum(HeroNode head , int k) {
		if(head.next == null) {
			System.out.println("此链表为空");
			return ;
		}
		int length = length(head);
		HeroNode temp = head;
		for (int i = 0; i < length - k+1; i++) {
			temp = temp.next;
		}
		System.out.println(temp.toString());
	}
	
//	反转单链表（腾讯面试题）
	public static void reverse(HeroNode head) {
		if(head.next == null || head.next.next == null) {
			System.out.println("此单链表不需要反转");
			return ;
		}
		HeroNode newHead = new HeroNode(0,"","");
		HeroNode temp = head.next;
		HeroNode Ntemp = null;
		while(temp!=null) {
			Ntemp = temp.next;
			temp.next = newHead.next;
			newHead.next = temp;
			temp = Ntemp;
		}
		head.next = newHead.next;
	}
	
//	从尾到头打印单链表,不能改变单链表的结构 （百度面试题 要求1.反向遍历 2.使用栈）
	public static void reversePrint(HeroNode head) {
		if(head.next == null) {
			System.out.println("此单链表为空");
			return ;
		}
//		创建一个栈对象
		Stack<HeroNode> stack = new Stack<HeroNode>();
//		遍历单链表将节点全部进栈
		HeroNode temp = head.next;
		while(temp!=null) {
			stack.push(temp);
			temp = temp.next;
		}
//		出栈
		while(stack.size()>0) {
			System.out.println(stack.pop());
		}
		
	}
}


//	定义节点
class HeroNode{
//	数据域
	public int no;
	public String name;
	public String nickName;
//	节点域
	public HeroNode next;
	
//	构造器
	public HeroNode(int no,String name ,String nickName) {
		this.no = no;
		this.name = name;
		this.nickName = nickName;
	}
//	重写tostring方法
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickName + "]";
	}
}
