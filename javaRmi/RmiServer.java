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
            // ע��Զ�̶�����ͻ����ṩ����
            LocateRegistry.createRegistry(1099);

            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Fff",remoteDemo);

            //�����������Ϣ
            System.out.println("��Ӱ��ѯ������Ѿ�׼����:FirstJavaRmi server ok...");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

