package com.cxq.javaSE.io.nio.test;

import java.nio.ByteBuffer;

/**
 * @author 8000654471
 * @desc
 * @date 2019/9/3 9:44
 */
public class BufferSliceTest {

    public static void main(String[] args){

        ByteBuffer byteBuffer = ByteBuffer.allocate(10);

        for(int i = 0; i < byteBuffer.capacity(); i ++){
            byteBuffer.put((byte) i);
        }

        byteBuffer.position(3);
        byteBuffer.limit(6);

        ByteBuffer sliceBuffer = byteBuffer.slice();

        for(int i = 0; i < sliceBuffer.capacity(); i ++){
            sliceBuffer.get(i);
            sliceBuffer.put(i, (byte)(sliceBuffer.get(i) * 2));
        }

        byteBuffer.position(0);
        byteBuffer.limit(10);
        while (byteBuffer.hasRemaining()){
            System.out.print(byteBuffer.get() + " ");
        }

    }

}
