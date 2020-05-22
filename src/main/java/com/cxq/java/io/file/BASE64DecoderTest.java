package com.cxq.java.io.file;

import sun.misc.BASE64Decoder;

import java.io.*;

/**
 * @author 8000654471
 * @desc
 * @date 2019/9/19 18:13
 */
public class BASE64DecoderTest {

    public static void main(String[] args) throws IOException {

        FileInputStream is = new FileInputStream(new File("D:/1.txt"));
        FileOutputStream os = new FileOutputStream(new File("D:/1.pdf"));

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

//        byte[] buffer = new byte[1024];
//        int index;
//        while ((index = is.read(buffer)) > 0){
//            bos.write(buffer,0,index);
//        }
//        BASE64Decoder decoder = new BASE64Decoder();
//        byte[] decodeBuffer = decoder.decodeBuffer(new String(bos.toByteArray()));
//        os.write(decodeBuffer);

        byte[] buffer = new byte[1024];
        BASE64Decoder decoder = new BASE64Decoder();
        while ((is.read(buffer)) > 0){
            byte[] decodeBuffer = decoder.decodeBuffer(new String(buffer));
            os.write(decodeBuffer,0,decodeBuffer.length);
        }

        os.flush();
        os.close();
        System.out.println("ok");
    }

}
