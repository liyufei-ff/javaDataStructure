package com.lyf.jiami;

import java.util.Base64;
/**
 * @author admin
 * @version 1.0.0
 * @ClassName Base64Demo.java
 */
public class Base64Demo {
    public static void main(String[] args) {
        base64("���1803�����");
    }

    public static void base64(String str) {
        //������Ҫ���ܽ��ܵ�����
        System.out.println("��Ҫ���ܽ��ܵ�����Ϊ:"+str);
        // ���ַ���תΪ�ֽ�����
        byte[] bytes = str.getBytes();

        // ����
        String encryption = Base64.getEncoder().encodeToString(bytes);
        System.out.println("Base64����:" + encryption);

        //Base64Demo ����
        byte[] decryption = Base64.getDecoder().decode(encryption);
        // �����ܺ���ֽ�����ת��Ϊ�ַ�����ʾ
        String decodeStr = new String(decryption);
        System.out.println("Base64����:" + decodeStr);

    }

}
