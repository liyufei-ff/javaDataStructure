package com.lyf;


/**
 * @author liyufei
 * @version 1.0.0
 * @ClassName A.java
 * @createTime 2021年03月16日 19:26:00
 */
// 100 - 200 之间的素数
public class primeNumber {
    public static void main(String[] args) {
        for (int i = 101; i <=200 ; i++) {
            for (int j = 2; j < i; j++) {
                if(i%j==0){
                    break;
                }
            }
            System.out.print(i);
        }
    }
}
