package com.lyf.recursion;

public class MiGong {
	public static void main(String[] args) {
		int [][]map = new int[11][11];
		map(map);
		show(map);
		System.out.println("找到通路后");
		setWay(map,1,1);
		show(map);
		
	}

//	建立迷宫
	public static void map(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = 0;
			}
		}
		
//		给迷宫添加围墙
		for (int i = 0; i < map.length; i++) {
			map[0][i] = 1;
			map[10][i] = 1;
		}
		
		for (int i = 1; i < map.length; i++) {
			map[i][0] = 1;
			map[i][10] = 1;
		}
		
		for (int i = 1; i <= 3; i++) {
			map[3][i] = 1;
		}
	}
	
	
//	显示迷宫
	public static void show(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	
//	找迷宫通路  0表示没有走过的路 1表示墙 2表示通路 3表示走过但是不通   策略为 上→下→左→右;
	public static boolean setWay(int[][]map ,int i,int j) {
//		map[9][9] == 2  表示已经找到了 通路
		if(map[9][9] == 2) {
			return true;
		}else {
			if(map[i][j] == 0) {
//				先假设可以走通
				map[i][j] = 2;
//				按照策略 探索路线
				if(setWay(map,i+1,j)) {
					return true;
				}
				else if(setWay(map,i-1,j)) {
					return true;
				}
				else if(setWay(map,i,j-1)) {
					return true;
				}
				else if(setWay(map,i-1,j+1)) {
					return true;
				}else {
//					走不通 记为不通 
					map[i][j] = 3;
					return false;
				}
			}else {
				return false;
			}
		}
		
	}
}
