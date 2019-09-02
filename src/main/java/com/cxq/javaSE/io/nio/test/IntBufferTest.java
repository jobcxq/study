package com.cxq.javaSE.io.nio.test;

import java.nio.IntBuffer;

/**
 * @author cnxqin
 * @desc
 * @date 2019/09/02 22:15
 */
public class IntBufferTest {

    public static void main(String[] args){

        IntBuffer intBuffer = IntBuffer.allocate(10);
        for(int i = 0; i < intBuffer.capacity(); i ++){
            intBuffer.put(i * 2);
        }
        intBuffer.flip();
        while (intBuffer.hasRemaining()){
            System.out.print(intBuffer.get() + " ");
        }

    }

}
