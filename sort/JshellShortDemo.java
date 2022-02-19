package com.lyf.sort;

import java.util.Arrays;

public class JshellShortDemo {

    public static void main(String[] args) {
        int[] nums = {3,4,1,8,1};
        jshellShort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void jshellShort(int []nums){
        int temp ;
        for (int step = nums.length/2; step > 0 ; step/=2) {
            for (int i = 0; i <nums.length-step ; i++) {
                for (int j = i; j >=0 ; j-=step) {
                    if (nums[j] >= nums[j+step]) {
                        temp = nums[j];
                        nums[j] = nums[j+step];
                        nums[j+step] = temp;
                    }
                }
            }
        }

    }
}
