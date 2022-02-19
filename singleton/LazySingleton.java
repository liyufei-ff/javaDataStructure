package com.lyf.singleton;

/**
 * @author liyufei
 * @version 1.0.0
 * @ClassName LazySingleton.java
 * @createTime 2021��03��07�� 16:30:00
 */
//DCL ˫�ؼ������������ʽ����
public class LazySingleton {
    private volatile static LazySingleton instance;

    private LazySingleton() {

    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
