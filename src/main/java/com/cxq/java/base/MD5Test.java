package com.cxq.java.base;

import sun.security.provider.MD5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author 8000654471
 * @desc
 * @date 2020/4/28 11:18
 */
public class MD5Test {

    static String PATH = "C:\\Users\\8000654471\\Downloads\\PDEA20510183514999990068.pdf";

    public static void main(String[] args){

        File file = new File(PATH);
        try {
            FileInputStream is = new FileInputStream(file);

            byte[] bytes = new byte[is.available()];

            is.read(bytes);

            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(bytes);

            byte[] byteArray = md5.digest();

            StringBuilder sb = new StringBuilder();
            for (byte b : byteArray) {
                // 一个byte格式化成两位的16进制，不足两位高位补零
                sb.append(String.format("%02x", b));
            }
            System.out.println(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


    }
}
