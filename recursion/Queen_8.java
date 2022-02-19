package com.lyf.recursion;

/*
 *  	八皇后问题  所有的皇后不能放到一行一列 同一斜线上
 */
public class Queen_8 {
	public static void main(String[] args) {
		Queen_eight qe = new Queen_eight(8);
		qe.put(0);
		System.out.println("一共有"+qe.count+"种摆法");
		
		System.out.println("judge一共判断"+qe.judgeCount+"次");
	}

}

class Queen_eight {
	int max;
//	用一个数组来存放 每一个皇后所在的列数
	int arr[];
//	通计有多少种 摆法
	int count;
//	统计 judge判断多少次
	int judgeCount;

	public Queen_eight(int max) {
		this.max = max;
		arr = new int[max];
	}
	
//	递归回溯放置八皇后   n从零开始  从第一个皇后开始放置
	public void put(int n) {
		if (n == max) {
			print();
			return;
		}

		for (int i = 0; i < max; i++) {
			arr[n] = i;
//			判断当前放置的位置是否与已经放置了的  皇后产生冲突
//			如果没有冲突 则继续放置  递归调用
//			如果产生冲突 则将当前皇后的放置位置进行移动
			if (judge(n)) {
				put(n + 1);
			}

		}

	}

	
	
//	判断当前皇后的放置是否与前面放置的皇后冲突
	public boolean judge(int n) {
		judgeCount++;
		for (int i = 0; i < n; i++) {
			if (arr[n] == arr[i] || (n - i) == Math.abs(arr[n] - arr[i])) {
				return false;
			}  
		}
		return true;
	}

	
	
//	将八皇后的摆放结果打印出来
	public void print() {
		count++;
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
