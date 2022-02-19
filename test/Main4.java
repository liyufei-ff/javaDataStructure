package com.lyf.test;

import java.util.Scanner;

/**
 * @author liyufei
 * @version 1.0.0
 * @ClassName Main4.java
 * @createTime 2021Äê04ÔÂ10ÈÕ 20:45:00
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int []val = new int[n];
        for (int i = 0; i < n; i++) {
            val[i] = sc.nextInt();
        }

        int r = res(val,k);
        System.out.println(r);
    }

    public static int res(int []val,int k){
        int mei = -1;
        for (int i = 0; i < val.length; i++) {
            if(val[i]==0){
                mei = i;
            }
        }

        int le = mei-1;
        int ri = mei+1;

        int res = -1;
        while(le>=0&&ri<=val.length-1){
            if(val[le]<=k){
                res = le+1;
            }else if (val[ri]<=k){
                res = ri+1;
            }
            if(val[le]<=k&&val[ri]<=k){
                res = val[le]<val[ri]? le+1:ri+1;
            }
            le --;
            ri ++;
            if(res!=-1){
                return res;
            }
        }

        while (ri<=val.length-1){
            if (val[ri]<=k){
                res = ri+1;
            }
            ri++;
            if(res!=-1){
                return res;
            }
        }

        while (le>=0){
            if(val[le]<=k){
                res = le+1;
            }
            le --;
            if(res!=-1){
                return res;
            }
        }

        return res;
    }
}