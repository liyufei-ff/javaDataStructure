package com.lyf.producerConsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liyufei
 * @version 1.0.0
 * @ClassName ProducerConsumerConditionLock.java
 * @createTime 2021年03月06日 20:05:00
 */
public class ProducerConsumerLock {
    public static void main(String[] args) {
        ResourceCondition resource = new ResourceCondition();

        new Thread(()->{
            while(true){
                resource.pro();
            }
        },"producer").start();

        new Thread(()->{
            while(true){
                resource.con();
            }
        },"consumer").start();
    }
}
class ResourceCondition {
    private int account = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public ResourceCondition(){}

    //生产
    public void pro(){
        lock.lock();

        try{
            while(account!=0){
                condition.await();
            }
            account++;
            System.out.println(Thread.currentThread().getName()+"---"+account);
            condition.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    //消费
    public void con(){
        lock.lock();

        try{
            while(account==0){
                condition.await();
            }
            account--;
            System.out.println(Thread.currentThread().getName()+"---"+account);
            condition.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
