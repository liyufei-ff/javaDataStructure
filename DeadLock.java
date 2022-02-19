package com.lyf;

/**
 * @author liyufei
 * @version 1.0.0
 * @ClassName DeadLock.java
 * @createTime 2021年03月06日 17:34:00
 */
// 构造死锁情况
public class DeadLock {
    private static Object o1 = new Object();
    private static Object o2 = new Object();

    public static void main(String[] args) {
        new Thread(()->{
            synchronized (o1){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2){

                }
            }
        }).start();

        new Thread(()->{
            synchronized (o2){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1){

                }
            }
        }).start();
    }
}
