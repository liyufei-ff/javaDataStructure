package com.lyf.javaRmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName RemoteDemoImpl.java
 */
public class RemoteDemoImpl extends UnicastRemoteObject implements IRemoteDemo{
    private int count;

    protected RemoteDemoImpl() throws RemoteException {
        count = 0;
    }

    @Override
    public void first() throws RemoteException {
        count++;
        System.out.println("执行的次数:"+count);
        System.out.println("查询电影:aaaaaaaaaaa");
        System.out.println("查询电影:bbbbbbbbbbb");
        System.out.println("查询电影:ccccccccccc");
        System.out.println("查询电影:ddddddddddd");
    }
}
