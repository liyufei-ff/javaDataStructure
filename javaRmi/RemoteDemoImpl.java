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
        System.out.println("ִ�еĴ���:"+count);
        System.out.println("��ѯ��Ӱ:aaaaaaaaaaa");
        System.out.println("��ѯ��Ӱ:bbbbbbbbbbb");
        System.out.println("��ѯ��Ӱ:ccccccccccc");
        System.out.println("��ѯ��Ӱ:ddddddddddd");
    }
}
