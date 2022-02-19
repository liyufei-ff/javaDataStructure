package com.lyf.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
	public static void main(String[] args) {
		CircleArrayQueue circleQueue = new CircleArrayQueue(4);
		Scanner sc = new Scanner(System.in);
		char key = ' ';
		boolean loop = true;
		while(loop) {
			System.out.println("s(show): 显示队列");
			System.out.println("e(exit): 退出程序");
			System.out.println("a(add): 添加数据到队列");
			System.out.println("g(get): 从队列取出数据");
			System.out.println("h(head): 查看队列头的数据");
			key = sc.next().charAt(0);
			switch (key) {
			case 's':
				circleQueue.showQueue();
				break;
			case 'a':
				System.out.println("输出一个数");
				int value = sc.nextInt();
				circleQueue.addQueue(value);
				break;
			case 'g': //取出数据
				try {
					int res = circleQueue.getQueue();
					System.out.printf("取出的数据是%d\n", res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case 'h': //查看队列头的数据
				try {
					circleQueue.headQueue();
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case 'e': //退出
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
	
//	构造器
	public CircleArrayQueue(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int [maxSize];
	}
	
//	判空
	public boolean isEmpty() {
		return front==rear;
	}
	
//	判满
	public boolean isFull() {
		return (rear+1)%maxSize==front;
	}
	
//	入队
	public void addQueue(int data) {
		if(isFull()) {
			System.out.println("队列已满");
			return ;
		}
		arr[rear] = data;
//		循环队列必须考虑取模
		rear = (rear+1)%maxSize;
	}
	
//	出队
	public int getQueue() {
		if(isEmpty()) {
			throw new RuntimeException("队列空，不能取数据");
		}
		int value = arr[front];
		front = (front+1)%maxSize;
		return value;
	}
	
//	显示头部元素
	public void headQueue() {
		if(isEmpty()) {
			throw new RuntimeException("队列为空，不能取数据");
		}
		
		System.out.println(arr[front]);
	}
	
//	统计队列中的有效数据
	public int dataSum() {
		return (rear+maxSize-front)%maxSize;
	}
	
//	显示队列中的所有数据
	public void showQueue() {
		for (int i = front; i < front+dataSum(); i++) {
			System.out.printf("arr[%d] = %d\n",i%maxSize,arr[i%maxSize]);
		}
	}
}