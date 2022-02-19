package com.lyf.producerConsumer;

/**
 * @author liyufei
 * @version 1.0.0
 * @ClassName ProducerConsumer.java
 * @createTime 2021��03��06�� 19:54:00
 */
public class ProducerConsumer {
    public static void main(String[] args) {
        ResourceCondition resource = new ResourceCondition();
        new Thread(()->{
            while (true){
                resource.pro();
            }
        },"producer0").start();

        new Thread(()->{
            while (true){
                resource.pro();
            }
        },"producer1").start();

        new Thread(()->{
            while (true){
                resource.con();
            }
        },"consumer0").start();

    }
}
class Resource{
    private int account = 0;

    public Resource(){

    }

    //����
    public synchronized void pro(){
        while(account!=0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        account++;
        System.out.println(Thread.currentThread().getName()+"-----"+account);
        this.notifyAll();
    }

    //����
    public synchronized void con(){
        while(account==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        account--;
        System.out.println(Thread.currentThread().getName()+"-----"+account);
        this.notifyAll();
    }
}


