package com.lyf.linkedlist;

import java.util.Stack;

/*
 * 	  ʹ������洢ˮ�Ӣ�۵���Ϣ
 */
public class SingleLinkedListDemo {
	public static void main(String[] args) {
//		�����ĸ��ڵ�
		HeroNode hero1 = new HeroNode(1,"lll","111");
		HeroNode hero2 = new HeroNode(2,"qqq","222");
		HeroNode hero3 = new HeroNode(3,"aaa","333");
		HeroNode hero4 = new HeroNode(4,"ddd","444");
//		��������
		SingleLinkedList list = new SingleLinkedList();

//		����������ӽڵ�
		list.addNode(hero1);
		list.addNode(hero2);
		list.addNode(hero3);
		list.addNode(hero4);
		
//		�������˳�����������������
		list.addByNum(hero2);
		list.addByNum(hero1);
		list.addByNum(hero4);
		list.addByNum(hero3);
	


		
		list.showList();
		System.out.println("�޸ĺ�ĵ�����Ϊ��");
		
//		�޸ĵ������еĽڵ�����
		HeroNode newNode = new HeroNode(4,"DDD","������");

		list.update(newNode);
		
//		��ʾ����
		list.showList();
		
//		ɾ���������е�ָ���ڵ�
		list.delete(1);
		list.delete(4);
		list.delete(2);
		list.delete(3);
		
		System.out.println("ɾ����ĵ�����Ϊ��");
		list.showList();
		
//		��ѯ�����еĽڵ�
		list.look(2);
		
//		ͳ�Ƶ���������Ч�ڵ�ĸ���
		System.out.println("����������Ч�ڵ�ĸ���Ϊ:"+SingleLinkedList.length(list.getHead()));
		
//		���ҵ������е�����K���ڵ�
		System.out.print("�����е�����K���ڵ�Ϊ�� ");
		SingleLinkedList.lookBynum(list.getHead(), 3);
//		
//		��ת������
		SingleLinkedList.reverse(list.getHead());
		list.showList();
		
//		��β��ͷ��ӡ������
		SingleLinkedList.reversePrint(list.getHead());
		
		
		
	}
}



//	������ͷ���ĵ�����
class SingleLinkedList{
//	����ͷ���
	private HeroNode head = new HeroNode(0,"","");
//	�޲ι���
	public SingleLinkedList() {
		
	}
//	����ͷ���
	public HeroNode getHead() {
		return head;
	}
	
//	����������ӽ��
	public void addNode(HeroNode node) {
		if(head.next==null) {
			head.next = node;
		}else {
//			����һ���м�ڵ�
			HeroNode temp = head;
			while(temp.next!=null) {
				temp = temp.next;
			}
			temp.next = node;
		}
	}
	
//	����������������������
	public void addByNum(HeroNode node) {
//		��һ����ʶ����ʶ���������Ƿ��Ѿ�����Ҫ�����Ԫ��
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
			System.out.println("���ݵ��������Ѿ�����");
		}else {
			node.next = temp.next;
			temp.next = node;
		}
	}
	
//	�������ɾ���������еĽڵ�
	public void delete(int num) {
		if(head.next == null) {
			System.out.println("����Ϊ�գ���");
			return ;
		}
		HeroNode temp = head;
		while(true) {
			if(temp.next == null) {
				System.out.println("û���ҵ�Ҫɾ���Ľڵ�");
				return ;
			}else if(temp.next.no == num) {
				temp.next = temp.next.next;
				return ;
			}
			temp = temp.next;
		}
	}
	
//	������Ų�ѯ�����еĽڵ�
	public void look(int num) {
		if(head.next == null) {
			System.out.println("������Ϊ��");
			return ;
		}
		HeroNode temp = head;
		while(true) {
			if(temp.next == null) {
				System.out.println("û���ҵ�Ҫ�鿴�Ľڵ�");
				return ;
			}else if(temp.next.no == num) {
				System.out.println("��ѯ���Ľڵ�Ϊ�� "+temp.next.toString());
				return ;
			}
			temp = temp.next;
		}
	}
	
//	�޸ĵ������е�����
	public void update(HeroNode newNode) {
		if(head.next == null ) {
			System.out.println("������Ϊһ��������");
			return ;
		}
		HeroNode temp = head;
		while(true) {
		if(temp.next == null) {
			System.out.println("û���ҵ�Ҫ�޸ĵĽڵ�");
			break;
		}else if(temp.next.no == newNode.no) {
			temp.next.name = newNode.name;
			temp.next.nickName = newNode.nickName;
			return ;
		}
			temp = temp.next;
		}
	}

//	��������
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
	
//	ͳ�Ƶ���������Ч�ڵ�ĸ���
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
	
//	���ҵ������е�����K���ڵ㣨���������⣩
	public static void lookBynum(HeroNode head , int k) {
		if(head.next == null) {
			System.out.println("������Ϊ��");
			return ;
		}
		int length = length(head);
		HeroNode temp = head;
		for (int i = 0; i < length - k+1; i++) {
			temp = temp.next;
		}
		System.out.println(temp.toString());
	}
	
//	��ת��������Ѷ�����⣩
	public static void reverse(HeroNode head) {
		if(head.next == null || head.next.next == null) {
			System.out.println("�˵�������Ҫ��ת");
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
	
//	��β��ͷ��ӡ������,���ܸı䵥����Ľṹ ���ٶ������� Ҫ��1.������� 2.ʹ��ջ��
	public static void reversePrint(HeroNode head) {
		if(head.next == null) {
			System.out.println("�˵�����Ϊ��");
			return ;
		}
//		����һ��ջ����
		Stack<HeroNode> stack = new Stack<HeroNode>();
//		�����������ڵ�ȫ����ջ
		HeroNode temp = head.next;
		while(temp!=null) {
			stack.push(temp);
			temp = temp.next;
		}
//		��ջ
		while(stack.size()>0) {
			System.out.println(stack.pop());
		}
		
	}
}


//	����ڵ�
class HeroNode{
//	������
	public int no;
	public String name;
	public String nickName;
//	�ڵ���
	public HeroNode next;
	
//	������
	public HeroNode(int no,String name ,String nickName) {
		this.no = no;
		this.name = name;
		this.nickName = nickName;
	}
//	��дtostring����
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickName + "]";
	}
}
