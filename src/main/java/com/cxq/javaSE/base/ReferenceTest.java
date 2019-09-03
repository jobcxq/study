package com.cxq.javaSE.base;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @author cnxqin
 * @desc 引用
 * @date 2019/09/03 21:44
 */
public class ReferenceTest {

    static Object stongObject = new Object();

    public static void main(String[] args){
        //强引用，只有在作用域外才可能被回收
        Object object = stongObject;
        stongObject = null;
        System.gc();
        System.out.println(object);

        //软引用：将要发生内存溢出前进行回收的对象进行第二次回收
        Object softObject = new Object();
        SoftReference softReference = new SoftReference(softObject);
        softObject = null;
        System.gc();
        System.out.println(softReference.get()); //可以获得软引用对象

        //弱引用：只能存活到下次垃圾收集之前
        Object weakObject = new Object();
        WeakReference weakReference = new WeakReference(weakObject);
        weakObject = null;
        System.gc();
        System.out.println(weakReference.get()); //null
        //弱引用引用常量，在 gc 前也不会被回收
        String str = "WeakReference";
        weakReference = new WeakReference(str);
        str = null;
        System.gc();
        System.out.println(weakReference.get()); //不会回收常量池中对象

        //虚引用
        ReferenceQueue queue = new ReferenceQueue();//必须使用队列
        Object phantomObject = new Object();
        PhantomReference phantomReference = new PhantomReference(phantomObject, queue);
        System.out.println(phantomReference.get()); //获取不到对象
        //但 JVM 发现还有虚引用对象时，会将对象放入到虚引用关联的队列中，来进行回收
        phantomObject = null;
        System.gc();
        System.out.println(queue.poll()); //可以获取到值


    }

}
