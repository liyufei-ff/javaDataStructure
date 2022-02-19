package com.lyf.javaRmi;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName RmiClient.java
 * @createTime 2020年12月31日 09:12:00
 */
public class RmiClient {
    public static void main(String[] args) {
        Registry registry;

        {
            try {
                //  获取到registry对象
                registry = LocateRegistry.getRegistry("localhost");
                //  从registry中查找到远程对象的代理
                IRemoteDemo remoteDemo = (IRemoteDemo) registry.lookup("Fff");
                // 调用远程对象中的方法
                remoteDemo.first();

            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (NotBoundException e) {
                e.printStackTrace();
            }
        }
    }
}
