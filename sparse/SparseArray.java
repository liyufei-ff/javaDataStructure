package com.lyf.sparse;
/*
 *  将一个数组转换为稀疏数组
 *  再讲稀疏数组转换为数组
 */
public class SparseArray {
	public static void main(String[] args) {
		// 创建一个原始的二维数组 11 * 11
		// 0: 表示没有棋子， 1 表示 黑子 2 表示 白子
		int chessArray1 [][]= new int[11][11];
//		初始化数组将黑子白子放入棋盘
		chessArray1[3][2] = 1;
		chessArray1[6][3] = 2;
		chessArray1[9][7] = 2;
//		转换前的数组为：
		System.out.println("数组为：");
		for (int[] row : chessArray1) {
			System.out.println();
			for (int value : row) {
				System.out.print(" "+value);
			}
		}
//	    统计非零值的个数
		int sum = 0;
		for (int i = 0; i < chessArray1.length; i++) {
			for (int j = 0; j < chessArray1.length; j++) {
				if(chessArray1[i][j]!=0) {
					sum++;
				}
			}
		}
		System.out.println();
		System.out.println(" sum = "+sum);
//		使用sum的值创建稀疏数组
		int sparseArray[][] = new int [sum+1][3];
		sparseArray[0][0] = 11;
		sparseArray[0][1] = 11;
		sparseArray[0][2] = sum;
//		遍历原数组将非零元素的信息存入稀疏数组
		int count = 0;
		for (int i = 0; i < chessArray1.length; i++) {
			for (int j = 0; j < chessArray1.length; j++) {
				if(chessArray1[i][j]!=0) {
					count++;
					sparseArray[count][0] = i;
					sparseArray[count][1] = j;
					sparseArray[count][2] = chessArray1[i][j];
				}
			}
		}
		System.out.println();
//		打印稀疏数组
		System.out.println("稀疏数组为：");
		for (int[] is : sparseArray) {
			System.out.println(is[0]+"\t"+is[1]+"\t"+is[2]+"\n");
		}
		
		
//		将稀疏数组再转回原数组，使用稀疏数组第一行的数据创建数组
		int chessArray2[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
		for (int i = 1; i <sparseArray.length; i++) {
				chessArray2[sparseArray[i][0]][sparseArray[i][1]]=sparseArray[i][2];
		}
		
//		打印原数组
		System.out.println("数组为：");
		for (int i = 0; i < chessArray2.length; i++) {
			System.out.println();
			for (int j = 0; j < chessArray2.length; j++) {
				System.out.print(" "+chessArray2[i][j]);
			}
		}
		
	}
}



