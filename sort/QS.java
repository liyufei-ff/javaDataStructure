package com.lyf.sort;

import java.util.Arrays;

public class QS {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 3, 4, 5, 6 };
        qs(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    public static void qs(int []nums,int indexLeft,int indexRight){
        int left = indexLeft;
        int right = indexRight;
        int target = nums[left];

        if(indexLeft<indexRight){
            while(left<right){

                while(left<right&&nums[right]>=target){
                    right--;
                }
                if(left<right){
                    nums[left++] = nums[right];
                }


                while(left<right&&nums[left]<target){
                    left++;
                }
                if(left<right){
                    nums[right--] = nums[left];
                }

            }

            nums[left] = target;

//            左右再进行递归
            qs(nums,indexLeft,left-1);
            qs(nums,right+1,indexRight);
        }
    }
}
