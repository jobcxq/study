package com.cxq.java.io.nio.test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author 8000654471
 * @desc 直接缓冲区 - 文件复制
 * @date 2019/9/3 10:17
 */
public class DirectBufferTest {

    public static void main(String[] args) throws IOException {

        FileInputStream is = new FileInputStream(new File("D:/1.pdf"));
        FileOutputStream os = new FileOutputStream(new File("D:/2.pdf"));

        long t1 = System.currentTimeMillis();

        FileChannel inChannel = is.getChannel();
        FileChannel osChannel = os.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1023);
        while(true){
            int i = inChannel.read(byteBuffer);
            if(i == -1){
                break;
            }
            byteBuffer.flip();
            osChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        long t2 = System.currentTimeMillis();

        System.out.println(t2 - t1);
    }

}
