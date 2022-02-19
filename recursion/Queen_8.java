package com.lyf.recursion;

/*
 *  	�˻ʺ�����  ���еĻʺ��ܷŵ�һ��һ�� ͬһб����
 */
public class Queen_8 {
	public static void main(String[] args) {
		Queen_eight qe = new Queen_eight(8);
		qe.put(0);
		System.out.println("һ����"+qe.count+"�ְڷ�");
		
		System.out.println("judgeһ���ж�"+qe.judgeCount+"��");
	}

}

class Queen_eight {
	int max;
//	��һ����������� ÿһ���ʺ����ڵ�����
	int arr[];
//	ͨ���ж����� �ڷ�
	int count;
//	ͳ�� judge�ж϶��ٴ�
	int judgeCount;

	public Queen_eight(int max) {
		this.max = max;
		arr = new int[max];
	}
	
//	�ݹ���ݷ��ð˻ʺ�   n���㿪ʼ  �ӵ�һ���ʺ�ʼ����
	public void put(int n) {
		if (n == max) {
			print();
			return;
		}

		for (int i = 0; i < max; i++) {
			arr[n] = i;
//			�жϵ�ǰ���õ�λ���Ƿ����Ѿ������˵�  �ʺ������ͻ
//			���û�г�ͻ ���������  �ݹ����
//			���������ͻ �򽫵�ǰ�ʺ�ķ���λ�ý����ƶ�
			if (judge(n)) {
				put(n + 1);
			}

		}

	}

	
	
//	�жϵ�ǰ�ʺ�ķ����Ƿ���ǰ����õĻʺ��ͻ
	public boolean judge(int n) {
		judgeCount++;
		for (int i = 0; i < n; i++) {
			if (arr[n] == arr[i] || (n - i) == Math.abs(arr[n] - arr[i])) {
				return false;
			}  
		}
		return true;
	}

	
	
//	���˻ʺ�İڷŽ����ӡ����
	public void print() {
		count++;
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
