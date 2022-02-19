package com.lyf.test;


import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author liyufei
 * @version 1.0.0
 * @ClassName Main1.java
 * @createTime 2021Äê03ÔÂ31ÈÕ 09:11:00
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        byte[] key = new byte[n];
        for (int i = 0; i < n; i++) {
            char s = sc.next().charAt(0);
            if(s>64){
                key[i] = (byte) s;
            }else{
                key[i] = (byte) s;
            }
        }


        LinkedList<Byte> track = new LinkedList<>();
        LinkedList<LinkedList<Byte>> res = new LinkedList<>();

        backTrack(key,0,track,m);

    }

    public static void backTrack(byte[] arr,int start,LinkedList<Byte> track,int m){
        if(track.size()==m){
            track.sort(null);
            for (byte b:track){
                char c = (char)b;
                System.out.print(c);
            }
            System.out.println();
            return;
        }

        for (int i = start; i < arr.length; i++) {
            track.add(arr[i]);
            backTrack(arr,i+1,track,m);
            track.removeLast();
        }
    }
}
