package com.lyf.map;
public class Test{
    public static void main(String[] args) {
        System.out.println(isPalindrome("1231"));
    }
    public static boolean isPalindrome(String str){
        if(str.length()==0||str.length()==1){
            return true;
        }

        int leftIndex = 0;
        int rightIndex = str.length()-1;

        while (leftIndex<=rightIndex){
            if(str.charAt(leftIndex)!=str.charAt(rightIndex)){
                return false;
            }
            leftIndex++;
            rightIndex--;
        }
        return true;
    }
}