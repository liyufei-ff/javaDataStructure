package com.lyf.test;

import java.util.Scanner;


/**
 * @author liyufei
 * @version 1.0.0
 * @ClassName Main.java
 * @createTime 2021��03��28�� 20:25:00
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //����
        int M = sc.nextInt(); //����
        int K = sc.nextInt(); //��������

        int [][]bao = new int[N][2];
        for (int i = 0; i <N ; i++) {
            bao[i][0] = sc.nextInt();
            bao[i][1] = sc.nextInt();
        }

        int res = bao[0][1];

        int index = 0;
       m: for (int i = 0; i < N; i=index) {
            int max = 0;
            if(K--<0){
                break;
            }
            int f = bao[i][0]+M;
            for (int j = i+1;j<N;j++) {
                if(bao[i+1][0]>f){
                    break m;
                }
                if(bao[j][0]<=f){
                    if(max<bao[j][1]){
                        max = bao[j][1];
                        index = j;
                    }
                }
            }
            res+=max;
        }
        System.out.println(res);
    }
}
