package com.lyf.test;

import java.util.Scanner;

/**
 * @author liyufei
 * @version 1.0.0
 * @ClassName Main6.java
 * @createTime 2021��04��11�� 11:45:00
 */
public class Main6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //�Ƶĸ���
        int m = sc.nextInt();  //���Ĵ���

        int []an = new int[m]; //ÿ�ΰ��ĵƵı��
        for (int i = 0; i < m; i++) {
            an[i] = sc.nextInt();
        }

        int []time = new int[n+1];
        int t = 1;
        int start = n+1;
        for (int i = 0; i < an.length; i++) {
            if(an[i]<start){
                for (int j = an[i]; j < start; j++) {
                    time[j] = t;
                }
                start = an[i];
            }

            t++;
        }

        for (int i = 1; i < time.length; i++) {
            System.out.print(time[i]);
        }

    }
}
