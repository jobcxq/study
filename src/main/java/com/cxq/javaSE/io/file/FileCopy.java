package com.cxq.javaSE.io.file;

import java.io.*;

/**
 * @author 8000654471
 * @desc
 * @date 2019/9/3 10:42
 */
public class FileCopy {

    public static void main(String[] args) throws IOException {

        FileInputStream is = new FileInputStream(new File("D:/1.pdf"));
        FileOutputStream os = new FileOutputStream(new File("D:/3.pdf"));

        long t1 = System.currentTimeMillis();

        byte[] buffer = new byte[1024];
        int index = 0;
        while ((index = is.read(buffer)) > 0){
            os.write(buffer,0,index);
        }
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
    }
}
