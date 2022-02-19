package com.lyf.test;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author liyufei
 * @version 1.0.0
 * @ClassName Main2.java
 * @createTime 2021Äê03ÔÂ31ÈÕ 10:00:00
 */
public class Main2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int count = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        while(sc.hasNextInt()){
            arr.add(sc.nextInt());
        }

        int [][]map = new int[arr.size()-1][arr.size()];
        for (int i = 0; i < arr.size()-1; i++) {
            for (int j = 0; j < arr.size(); j++) {
                map[i][j] = sc.nextInt();
            }
        }
    }

}
