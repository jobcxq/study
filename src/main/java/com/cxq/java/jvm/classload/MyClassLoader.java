package com.cxq.java.jvm.classload;

import java.io.*;
import java.lang.reflect.Method;

/**
 * @author cnxqin
 * @desc 自定义类加载器
 * @date 2019/09/17 19:52
 */
public class MyClassLoader extends ClassLoader {

    private final static String BASE_PATH = "D:/IdeaProjects/study/lib/";

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {

        System.out.println("自定义加载器加载类：" + name);
        return super.loadClass(name);
    }

    MyClassLoader(){
        //自定义父类加载器为 AppClassLoader
        //sun.misc.Launcher$AppClassLoader
        System.out.println("自定义类加载器父类：" + super.getParent());

        //AppClassLoader 父类加载器为 ExtClassLoader
        //sun.misc.Launcher$ExtClassLoader@567d299b
        System.out.println("AppClassLoader 父类加载器：" + super.getParent().getParent());
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte [] bytes = loadClassFromPath(name);
        if(bytes == null || bytes.length == 0){
            return null;
        }
        return this.defineClass(name,bytes,0,bytes.length);
    }

    public static void main(String[] args){
        MyClassLoader classLoader = new MyClassLoader();

        try {
            Class clazz = classLoader.loadClass("com.classload.ClassLoaderTest");
            System.out.println(clazz.getClassLoader());
            Object object = clazz.newInstance();
            Method method = clazz.getMethod("say");
            method.invoke(object);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private byte[] loadClassFromPath(final String name){
        try {
            String path = BASE_PATH + name.replace(".",File.separator) + ".class";
            FileInputStream is = new FileInputStream(new File(path));
            ByteArrayOutputStream os = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int i;
            while ((i = is.read(buffer)) > 0){
                os.write(buffer,0,i);
            }
            return os.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
