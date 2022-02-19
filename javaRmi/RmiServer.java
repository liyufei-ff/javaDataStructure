package com.lyf.javaRmi;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName RmiServer.java
 */
public class RmiServer {

    public static void main(String[] args)  {
        try {

            IRemoteDemo remoteDemo = new RemoteDemoImpl();
            // 注册远程对象向客户端提供服务
            LocateRegistry.createRegistry(1099);

            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Fff",remoteDemo);

            //输出服务器信息
            System.out.println("电影查询服务端已经准备好:FirstJavaRmi server ok...");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

