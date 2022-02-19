package com.lyf.test;

/**
 * @author liyufei
 * @version 1.0.0
 * @ClassName test1.java
 * @createTime 2021年04月15日 11:20:00
 */
public class test1 {
    public static void main(String[] args) {
        Resource re = new Resource(0);
        new Thread(()->{  //偶数线程
            re.even();
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            re.odd();
        }).start();
    }
}

class Resource{
    volatile int count;
    volatile int flag;

    public Resource(int count){
        this.count = count;
        this.flag = 0;
    }

    //奇数
    public void odd(){
        while (count<100){
            if(flag==1){
                System.out.println(Thread.currentThread().getName()+count);
                flag--;
                count++;
            }
        }
    }


    //偶数
    public void even(){
        while (count<=100){
            if(flag==0){
                System.out.println(Thread.currentThread().getName()+count);
                flag++;
                count++;
            }
        }
    }
}