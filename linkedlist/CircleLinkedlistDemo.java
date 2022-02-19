package com.lyf.linkedlist;

public class CircleLinkedlistDemo {
	public static void main(String[] args) {
		CircleLinkedlist clist = new CircleLinkedlist();
		
//		clist.add(5);
//		clist.show();
		
		clist.josephRing(3, 2, 6);
		
	}
	

}


//	ѭ��������
class CircleLinkedlist{
	private Cnode first = null;
	
	public CircleLinkedlist() {
		
	}
//	�����涨��Ŀѭ��������
	public void add(int num) {
		if(num< 1) {		
			System.out.println("�ڵ��������");
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
	
//	��ʾѭ������
	public void show() {
		Cnode temp = first;
		if(first == null) {
			System.out.println("��ѭ������Ϊ��");
			return ;
		}else {
			System.out.printf("%d ��\n",first.no);
		}
		
		while(true) {
			if(temp.next!=first) {
				System.out.printf("%d ��\n",temp.next.no);
			}else {
				System.out.println("����ѭ�������Ѿ��������");
				break ;
			}
			temp = temp.next;
		}
	}
	
//	josephRing Լɪ������
	public void josephRing(int k,int m,int num) {
		if(k<0||k>num||m<0) {
			System.out.println("����Ĳ�������");
			return ;
		}
//		������������
		add(num);
		
//	 ����helperΪ����first�Ľڵ�
		Cnode helper = null;
		Cnode temp = first;
		while(true) {
			if(temp.next == first) {
				helper = temp;
				break;
			}
			temp = temp.next;
		}
		
//	 ��helper first ָ���Ƶ���ʼ��λ��
		for (int i = 0; i < k-1; i++) {
			first = first.next;
			helper = helper.next;
		}
		
//	 ��ʼ����m�����ƶ�
		while(first != helper) {
			for (int i = 0; i < m-1; i++) {
				first = first.next;
				helper = helper.next;
			}
//			��ӡ��first��ָ��Ľڵ�����
			System.out.print(first.no+" -> ");
			
//			ɾ��first��ָ��Ľڵ�
			first = first.next;
			helper.next = first;
			
		}
		System.out.println(first.no);
		
	}
	
}

//	�ڵ�
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
