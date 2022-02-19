package com.lyf.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
	public static void main(String[] args) {
		CircleArrayQueue circleQueue = new CircleArrayQueue(4);
		Scanner sc = new Scanner(System.in);
		char key = ' ';
		boolean loop = true;
		while(loop) {
			System.out.println("s(show): ��ʾ����");
			System.out.println("e(exit): �˳�����");
			System.out.println("a(add): ������ݵ�����");
			System.out.println("g(get): �Ӷ���ȡ������");
			System.out.println("h(head): �鿴����ͷ������");
			key = sc.next().charAt(0);
			switch (key) {
			case 's':
				circleQueue.showQueue();
				break;
			case 'a':
				System.out.println("���һ����");
				int value = sc.nextInt();
				circleQueue.addQueue(value);
				break;
			case 'g': //ȡ������
				try {
					int res = circleQueue.getQueue();
					System.out.printf("ȡ����������%d\n", res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case 'h': //�鿴����ͷ������
				try {
					circleQueue.headQueue();
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case 'e': //�˳�
				sc.close();
				loop = false;
				break;
			default:
				break;
			}
		}
	}
}
class CircleArrayQueue{
	private int maxSize;
	private int front;
	private int rear;
	private int	[] arr;
	
//	������
	public CircleArrayQueue(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int [maxSize];
	}
	
//	�п�
	public boolean isEmpty() {
		return front==rear;
	}
	
//	����
	public boolean isFull() {
		return (rear+1)%maxSize==front;
	}
	
//	���
	public void addQueue(int data) {
		if(isFull()) {
			System.out.println("��������");
			return ;
		}
		arr[rear] = data;
//		ѭ�����б��뿼��ȡģ
		rear = (rear+1)%maxSize;
	}
	
//	����
	public int getQueue() {
		if(isEmpty()) {
			throw new RuntimeException("���пգ�����ȡ����");
		}
		int value = arr[front];
		front = (front+1)%maxSize;
		return value;
	}
	
//	��ʾͷ��Ԫ��
	public void headQueue() {
		if(isEmpty()) {
			throw new RuntimeException("����Ϊ�գ�����ȡ����");
		}
		
		System.out.println(arr[front]);
	}
	
//	ͳ�ƶ����е���Ч����
	public int dataSum() {
		return (rear+maxSize-front)%maxSize;
	}
	
//	��ʾ�����е���������
	public void showQueue() {
		for (int i = front; i < front+dataSum(); i++) {
			System.out.printf("arr[%d] = %d\n",i%maxSize,arr[i%maxSize]);
		}
	}
}