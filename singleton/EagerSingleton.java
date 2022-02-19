package com.lyf.singleton;

/**
 * @author liyufei
 * @version 1.0.0
 * @ClassName EagerSingleton.java
 * @createTime 2021年03月07日 16:25:00
 */
// 饿汉式单例
public class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton(){

    }
    public static EagerSingleton getInstance(){
        return instance;
    }
}
