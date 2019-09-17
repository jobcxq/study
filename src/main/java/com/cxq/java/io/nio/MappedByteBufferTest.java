package com.cxq.java.io.nio;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author 8000654471
 * @desc 内存映射
 * @date 2019/9/3 16:29
 */
public class MappedByteBufferTest {

    public static void main(String[] args) throws IOException {

        RandomAccessFile accessFile = new RandomAccessFile("D:/test.txt","rw");

        FileChannel fileChannel = accessFile.getChannel();

        MappedByteBuffer byteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE,100,1024);

        byteBuffer.put(100,(byte)1);
        accessFile.close();

    }

}
