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

//	˫��������
class DoubleLinkedlist{
//	����ͷ�ڵ�
	private Dnode head = new Dnode(0,"","");
//	�޲ι���
	public DoubleLinkedlist() {
		
	}
	
//	��ȡͷ���
	public Dnode getHead() {
		return head;
	}

//	��˫�����������ӽڵ�
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
	
//	���������ָ����λ����ӽڵ�
	public void addBynum(int index,Dnode node) {
		if(head.next == null) {
			System.out.println("��˫������Ϊ��");
			return ;
		}
		
		Dnode temp = head.next;
		int count = length();
		if(index<0 || index>count) {
			System.out.println("�����ڴ�λ�õĽڵ�");
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
	
//	�޸�˫�������еĽڵ�����
	public void update(Dnode data) {
		if(head.next == null) {
			System.out.println("��˫������Ϊ������");
			return ;
		}
		
		Dnode temp = head.next;
		while(true) {
			if(temp == null) {
				System.out.println("û���ҵ�Ҫ�޸ĵĽڵ�");
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
	
//	ɾ��˫�������е�ָ���Ľڵ�
	public void deleteBynum(int index) {
		if(head.next == null) {
			System.out.println("��˫������Ϊ��");
			return ;
		}
		
		Dnode temp = head.next;
		while(true) {
			if(temp == null) {
				System.out.println("ûҪ�ҵ�Ҫɾ���Ľڵ�");
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
	
//	��ʾ˫������
	public void show(Dnode head) {
		if(head.next == null) {
			System.out.println("��˫������Ϊ��");
			return ;
		}
		
		Dnode temp = head.next;
		while(temp!=null) {
			System.out.println(temp.tosString());
			temp = temp.next;
		}
	}
	
//	 ͳ��˫�������е���Ч�ڵ�
	public int length() {
		if(head.next == null) {
			System.out.println("��˫������Ϊ��");
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

//	�ڵ���
class Dnode{
//	������
	public int no;
	public String name;
	public String nickName;
//	ָ����
	public Dnode prime;
	public Dnode next;
//	������
	public Dnode(int no , String name ,String nickName) {
		this.no = no;
		this.name = name;
		this.nickName = nickName;
	}
	
//	��дtoString();
	public String tosString() {
		return "Dnode [no=" + no + ", name=" + name + ", nickname=" + nickName + "]";
	}
}
