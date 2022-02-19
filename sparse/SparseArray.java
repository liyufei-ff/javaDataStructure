package com.lyf.sparse;
/*
 *  ��һ������ת��Ϊϡ������
 *  �ٽ�ϡ������ת��Ϊ����
 */
public class SparseArray {
	public static void main(String[] args) {
		// ����һ��ԭʼ�Ķ�ά���� 11 * 11
		// 0: ��ʾû�����ӣ� 1 ��ʾ ���� 2 ��ʾ ����
		int chessArray1 [][]= new int[11][11];
//		��ʼ�����齫���Ӱ��ӷ�������
		chessArray1[3][2] = 1;
		chessArray1[6][3] = 2;
		chessArray1[9][7] = 2;
//		ת��ǰ������Ϊ��
		System.out.println("����Ϊ��");
		for (int[] row : chessArray1) {
			System.out.println();
			for (int value : row) {
				System.out.print(" "+value);
			}
		}
//	    ͳ�Ʒ���ֵ�ĸ���
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
//		ʹ��sum��ֵ����ϡ������
		int sparseArray[][] = new int [sum+1][3];
		sparseArray[0][0] = 11;
		sparseArray[0][1] = 11;
		sparseArray[0][2] = sum;
//		����ԭ���齫����Ԫ�ص���Ϣ����ϡ������
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
//		��ӡϡ������
		System.out.println("ϡ������Ϊ��");
		for (int[] is : sparseArray) {
			System.out.println(is[0]+"\t"+is[1]+"\t"+is[2]+"\n");
		}
		
		
//		��ϡ��������ת��ԭ���飬ʹ��ϡ�������һ�е����ݴ�������
		int chessArray2[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
		for (int i = 1; i <sparseArray.length; i++) {
				chessArray2[sparseArray[i][0]][sparseArray[i][1]]=sparseArray[i][2];
		}
		
//		��ӡԭ����
		System.out.println("����Ϊ��");
		for (int i = 0; i < chessArray2.length; i++) {
			System.out.println();
			for (int j = 0; j < chessArray2.length; j++) {
				System.out.print(" "+chessArray2[i][j]);
			}
		}
		
	}
}



