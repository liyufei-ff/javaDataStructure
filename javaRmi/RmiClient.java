package com.lyf.javaRmi;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName RmiClient.java
 * @createTime 2020��12��31�� 09:12:00
 */
public class RmiClient {
    public static void main(String[] args) {
        Registry registry;

        {
            try {
                //  ��ȡ��registry����
                registry = LocateRegistry.getRegistry("localhost");
                //  ��registry�в��ҵ�Զ�̶���Ĵ���
                IRemoteDemo remoteDemo = (IRemoteDemo) registry.lookup("Fff");
                // ����Զ�̶����еķ���
                remoteDemo.first();

            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (NotBoundException e) {
                e.printStackTrace();
            }
        }
    }
}
