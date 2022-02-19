package com.lyf.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author liyufei
 * @version 1.0.0
 * @ClassName Main5.java
 * @createTime 2021年04月11日 11:03:00
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt(); //M队射中人数
        int m = sc.nextInt(); //T队射中人数

        No[] arr = new No[n+m];


        for (int i = 0; i < n; i++) {
            arr[i] = new No();
            arr[i].data = sc.nextInt();
            arr[i].flag = 0;
        }

        for (int i = n; i < m+n; i++) {
            arr[i] = new No();
            arr[i].data = sc.nextInt();
            arr[i].flag = 1;
        }

        Arrays.sort(arr, new Comparator<No>() {
            @Override
            public int compare(No o1, No o2) {
                return o1.data-o2.data;
            }
        });

        int scoT = 0;
        int scoM = 0;
        int Max = Integer.MIN_VALUE;
        for (int dinx = -1; dinx <= arr.length; dinx++) {
            for (int i = 0; i < arr.length; i++) {
                if(i<=dinx){
                    if(arr[i].flag==0){
                        scoM +=1;
                    }else if(arr[i].flag==1){
                        scoT+=1;
                    }
                }else{
                    if(arr[i].flag==0){
                        scoM +=2;
                    }else if(arr[i].flag==1){
                        scoT+=2;
                    }
                }
            }
            Max = Math.max(Max,scoT-scoM);
            scoT = 0;
            scoM = 0;
        }

        System.out.println(Max);
    }
}
class No{
    Integer data;
    Integer flag;
}

