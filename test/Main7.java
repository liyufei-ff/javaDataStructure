package com.lyf.test;

        import java.util.Scanner;

/**
 * @author liyufei
 * @version 1.0.0
 * @ClassName Main7.java
 * @createTime 2021Äê04ÔÂ11ÈÕ 11:54:00
 */
public class Main7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String s = sc.next();

        int cou0 = 0;
        int cou1 = 0;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='0'){
                cou0++;
            }
            if (s.charAt(i)=='1'){
                cou1++;
            }
        }

        System.out.println(cou0>cou1?cou0-cou1:cou1-cou0);
    }
}
