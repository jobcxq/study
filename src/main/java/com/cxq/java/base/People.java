package com.cxq.java.base;

/**
 * @author 8000654471
 * @desc
 * @date 2019/9/20 14:03
 */
public class People {

    private int a;

    public int change(int m) {
        return m;
    }

    public static int getA() throws Exception {
        throw new Exception("23445");
    }

    public static void main(String[] args) {

        try {
            getA();
        } catch (Exception e) {
            System.out.println("sdsd::" + e);
            e.printStackTrace();
        }

        int[] x = new int[24];
        System.out.println(x[1]);

        retry:
            for (int i = 0; i < 100 ; i ++ ) {
                System.out.println("i = " + i);
                if(i == 10)
                continue retry;
            }

         System.out.println("ok");

    }



}
