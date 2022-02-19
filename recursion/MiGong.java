package com.lyf.recursion;

public class MiGong {
	public static void main(String[] args) {
		int [][]map = new int[11][11];
		map(map);
		show(map);
		System.out.println("�ҵ�ͨ·��");
		setWay(map,1,1);
		show(map);
		
	}

//	�����Թ�
	public static void map(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = 0;
			}
		}
		
//		���Թ����Χǽ
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
	
	
//	��ʾ�Թ�
	public static void show(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	
//	���Թ�ͨ·  0��ʾû���߹���· 1��ʾǽ 2��ʾͨ· 3��ʾ�߹����ǲ�ͨ   ����Ϊ �ϡ��¡������;
	public static boolean setWay(int[][]map ,int i,int j) {
//		map[9][9] == 2  ��ʾ�Ѿ��ҵ��� ͨ·
		if(map[9][9] == 2) {
			return true;
		}else {
			if(map[i][j] == 0) {
//				�ȼ��������ͨ
				map[i][j] = 2;
//				���ղ��� ̽��·��
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
//					�߲�ͨ ��Ϊ��ͨ 
					map[i][j] = 3;
					return false;
				}
			}else {
				return false;
			}
		}
		
	}
}
