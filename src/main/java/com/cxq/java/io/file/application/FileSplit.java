package com.cxq.java.io.file.application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by alm.ccic.chenxiaoq on 2018-06-27.
 */
public class FileSplit {

    public final static long FILE_SIZE = 8 * 1024 * 1024 ; //  8M
    public final static String SOURCE_PATH = "D:/FileSplit";
    public final static String DESTINATION_PATH = "D:/Combine/";
    public final static String DESTINATION_FILE_NAME = "result";

    public void mkdir(File path){
        if(!path.exists()){
            if(!path.getParentFile().exists()){
                mkdir(path.getParentFile());
            }else{
                path.mkdir();
            }
        }
    }

    public void doFileSplit(File file){
        FileInputStream is = null;
        FileOutputStream os = null;
        try{
            System.out.println("The source file length is [" + file.length() + "]");
            is = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int count = 0, index = 0, sum = 0;
            File path = new File(DESTINATION_PATH);
            this.mkdir(path);
            File out = new File(DESTINATION_PATH + File.separator + index);
            os = new FileOutputStream(out);
            while((count = is.read(buffer,0,1024)) > 0){
                os.write(buffer,0,count);
                sum += count;
                if(sum >= FILE_SIZE){
                    System.out.println("The file number is [" + index + "] , file length is [" + out.length() + "]");
                    out = new File(DESTINATION_PATH + File.separator + (++ index));
                    os = new FileOutputStream(out);
                    sum = 0;
                }
            }
            System.out.println("The file number is [" + index + "] , file length is [" + out.length() + "]");
            os.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ;
            }
        }
    }

    public static void main(String[] args){
        FileSplit fileSplit = new FileSplit();
        File path = new File(SOURCE_PATH);
        if(path.exists() && path.isDirectory()){
            File desFile = new File(DESTINATION_PATH + DESTINATION_FILE_NAME);
            if(desFile.exists()){
                System.out.println("========== delete destination file :" + desFile.getAbsolutePath());
                desFile.delete();
            }
            for(File file : path.listFiles()){
                System.out.println("========== begin split file : " + file.getAbsolutePath());
                fileSplit.doFileSplit(file);
                System.out.println("========== end split file : " + file.getAbsolutePath());
            }
            System.out.println("=============== working done!");
        }else{
            System.out.println(SOURCE_PATH + " isn't existed or a directory!");
            fileSplit.mkdir(path);
            System.out.println("create directory [" + SOURCE_PATH + "] finished!" );
        }

    }
}
