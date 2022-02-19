package com.lyf.test;

import java.lang.reflect.Method;

/**
 * @author liyufei
 * @version 1.0.0
 * @ClassName Re.java
 * @createTime 2021Äê04ÔÂ16ÈÕ 21:09:00
 */
public class Re {
    public static void main(String[] args) {
        Class<Ref> refClass = Ref.class;
        Method[] declaredMethods = refClass.getDeclaredMethods();
        try {
            Ref ref = refClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}

class Ref{
    private int a = 10;

    public Ref(){

    }

    public Ref(int a){
        this.a = a;
    }

    public void me(){
        System.out.println("hh");
    }
}
