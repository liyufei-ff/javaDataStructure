package com.lyf.javaRmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName IRemoteDemo.java
 */
public interface IRemoteDemo extends Remote {

    void first() throws RemoteException;
}
