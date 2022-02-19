package com.lyf.test;

/**
 * @author liyufei
 * @version 1.0.0
 * @ClassName BitOperation.java
 * @createTime 2021年04月01日 19:21:00
 */
public class BitOperation {
    public static void main(String[] args) {
        int nums[] = {3,2,3,2,5,5,8,1,6,1,6};
        int res = 0; //用0去异或数组中所有的数
        for (int i = 0; i <nums.length ; i++) {
            res^=nums[i];
        }

        System.out.println(res);
    }
}
