package com.lyf.test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author liyufei
 * @version 1.0.0
 * @ClassName Main3.java
 * @createTime 2021Äê04ÔÂ10ÈÕ 19:54:00
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int []nums = new int[count];

        for (int i = 0; i < count; i++) {
            nums[i] = sc.nextInt();
        }

        boolean []vis = new boolean[nums.length];
        LinkedList<Integer> sta = new LinkedList<>();
        Arrays.sort(nums);

        dfs(nums,sta,vis,0);

        System.out.println(res.toString());
    }

    static LinkedList<LinkedList<Integer>> res = new LinkedList<>();
    public static void dfs(int []nums,LinkedList<Integer> sta,boolean []vis,int ind){
        if(ind==nums.length){
            res.add(new LinkedList<>(sta));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(vis[i]||(i>0&&nums[i]==nums[i-1]&&!vis[i-1])){
                continue;
            }

            sta.add(nums[i]);
            vis[i] = true;
            dfs(nums,sta,vis,ind+1);
            sta.remove(ind);
            vis[i] = false;
        }
    }
}
