package com.zmj.viewpagertest.utils;

import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/3/11
 * Description :
 */
public class AesHelper {
    /**
     * 加密
     * @param content
     * @param password
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(String content,String password) throws Exception {
        byte[] passbyte = password.getBytes();
        //创建AES密钥
        SecretKeySpec key = new SecretKeySpec(password.getBytes(),"AES/CBC/PKCS5PADDING");
        //创建密码器
        Cipher cipher = Cipher.getInstance("AES");
        //初始化加密器
        cipher.init(Cipher.ENCRYPT_MODE,key);
        //加密
        return cipher.doFinal(content.getBytes("UTF-8"));
    }

    public static byte[] decrypt(byte[] content,String password) throws Exception {
        //创建AES密钥
        SecretKeySpec key = new SecretKeySpec(password.getBytes(),"AES/CBC/PKCS5PADDING");
        //创建密码器
        Cipher cipher = Cipher.getInstance("AES");
        //初始化解码器
        cipher.init(Cipher.DECRYPT_MODE,key);
        //解密
        return cipher.doFinal(content);
    }
}
