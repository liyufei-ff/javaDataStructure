package com.lyf.test;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author liyufei
 * @version 1.0.0
 * @ClassName Main8.java
 * @createTime 2021年04月11日 16:57:00
 */
public class Main8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt(); //字符串长度
        int k = sc.nextInt(); //修改次数

        String str = sc.next();

        //统计字符种类
        HashSet<Character> kind = new HashSet<>();
        for (int i = 0; i < len; i++) {
            kind.add(str.charAt(i));
        }

        int r = score(str,k,kind);
        System.out.println(r);

    }

    public static int score(String str,int k,HashSet<Character> kind){
        int le = 0;
        int ri = 0;
        int temp = k;
        int res = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for (Character c:kind){
            while (ri<str.length()){
                if(str.charAt(ri)!=c){
                    k--;
                }
                if(++ri==str.length()){
                    res = Math.max(res,ri-le);
                    break;
                }

                while(k==0&&str.charAt(ri)!=c){
                    res = Math.max(res,ri-le);
                    if(str.charAt(le)!=c){
                        k++;
                    }
                    le++;
                }
            }

            max = Math.max(max,res);
            le = 0;
            ri = 0;
            res = 0;
            k = temp;
        }
        return max;
    }
}
