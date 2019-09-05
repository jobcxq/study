package com.cxq.java.io.file.application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by alm.ccic.chenxiaoq on 2018-06-28.
 */
public class FileCombine {

    public final static String DESTINATION_PATH = "D:/Combine/";
    public final static String DESTINATION_FILE_NAME = "result";


    public void combine(File path,File desFile){
        FileOutputStream os = null;
        FileInputStream is = null;
        try{
            os = new FileOutputStream(desFile);
            if(path.exists() && path.isDirectory()){
                File[] files = path.listFiles();
                for(File file : files){
                    if(!DESTINATION_FILE_NAME.equalsIgnoreCase(file.getName())){
                        System.out.println("begin combine file : " + file.getAbsolutePath());
                        byte[] buffer = new byte[1024];
                        is = new FileInputStream(file);
                        int count = 0;
                        while((count = is.read(buffer,0,1024)) > 0){
                            os.write(buffer,0,count);
                        }
                        System.out.println("end combine file : " + file.getAbsolutePath());
                    }
                }
                os.flush();
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args){
        FileCombine fileCombine = new FileCombine();
        try{
            File desFile = new File(DESTINATION_PATH + DESTINATION_FILE_NAME);
            if(!desFile.exists()){
                System.out.println("========== create destination file :" + desFile.getAbsolutePath());
                desFile.createNewFile();
            }

            File path = new File(DESTINATION_PATH);
            System.out.println("========== begin combine to file : " + desFile.getAbsolutePath());
            fileCombine.combine(path,desFile);
            System.out.println("========== end combine to file : " + desFile.getAbsolutePath());

        }catch (Exception e){

        }
    }
}
