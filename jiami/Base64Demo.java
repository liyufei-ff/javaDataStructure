package com.lyf.jiami;

import java.util.Base64;
/**
 * @author admin
 * @version 1.0.0
 * @ClassName Base64Demo.java
 */
public class Base64Demo {
    public static void main(String[] args) {
        base64("软件1803李宇飞");
    }

    public static void base64(String str) {
        //输入需要加密解密的内容
        System.out.println("需要加密解密的内容为:"+str);
        // 将字符串转为字节数组
        byte[] bytes = str.getBytes();

        // 加密
        String encryption = Base64.getEncoder().encodeToString(bytes);
        System.out.println("Base64加密:" + encryption);

        //Base64Demo 解密
        byte[] decryption = Base64.getDecoder().decode(encryption);
        // 将解密后的字节数组转换为字符串显示
        String decodeStr = new String(decryption);
        System.out.println("Base64解密:" + decodeStr);

    }

}
