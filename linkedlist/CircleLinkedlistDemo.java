package com.lyf.linkedlist;

public class CircleLinkedlistDemo {
	public static void main(String[] args) {
		CircleLinkedlist clist = new CircleLinkedlist();
		
//		clist.add(5);
//		clist.show();
		
		clist.josephRing(3, 2, 6);
		
	}
	

}


//	循环单链表
class CircleLinkedlist{
	private Cnode first = null;
	
	public CircleLinkedlist() {
		
	}
//	构建规定数目循环单链表
	public void add(int num) {
		if(num< 1) {		
			System.out.println("节点个数错误");
			return ;
		}
		Cnode temp = null;
		for (int i = 1; i <= num; i++) {
			Cnode node = new Cnode(i);
			if(i == 1) {
				first = node;
				node.next = node;
				temp = first;
			}else {
				temp.next = node;
				node.next = first;
				temp = temp.next;
			}
			
		}
	}
	
//	显示循环链表
	public void show() {
		Cnode temp = first;
		if(first == null) {
			System.out.println("此循环链表为空");
			return ;
		}else {
			System.out.printf("%d 号\n",first.no);
		}
		
		while(true) {
			if(temp.next!=first) {
				System.out.printf("%d 号\n",temp.next.no);
			}else {
				System.out.println("单向循环链表已经遍历完毕");
				break ;
			}
			temp = temp.next;
		}
	}
	
//	josephRing 约瑟夫环问题
	public void josephRing(int k,int m,int num) {
		if(k<0||k>num||m<0) {
			System.out.println("输入的参数有误");
			return ;
		}
//		建立环形链表
		add(num);
		
//	 创建helper为紧跟first的节点
		Cnode helper = null;
		Cnode temp = first;
		while(true) {
			if(temp.next == first) {
				helper = temp;
				break;
			}
			temp = temp.next;
		}
		
//	 将helper first 指针移到开始的位置
		for (int i = 0; i < k-1; i++) {
			first = first.next;
			helper = helper.next;
		}
		
//	 开始按照m进行移动
		while(first != helper) {
			for (int i = 0; i < m-1; i++) {
				first = first.next;
				helper = helper.next;
			}
//			打印出first所指向的节点的序号
			System.out.print(first.no+" -> ");
			
//			删除first所指向的节点
			first = first.next;
			helper.next = first;
			
		}
		System.out.println(first.no);
		
	}
	
}

//	节点
class Cnode{
	public int no;
	public Cnode next;
	
	public Cnode(int no) {
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Cnode getNext() {
		return next;
	}

	public void setNext(Cnode next) {
		this.next = next;
	}
	
}
