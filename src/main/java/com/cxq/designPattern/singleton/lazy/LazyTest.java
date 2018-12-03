package com.cxq.designPattern.singleton.lazy;

public class LazyTest {

    public static void main(String[] args) {

        int count = 200000000;

        long t1 = System.currentTimeMillis();
        LazyOne one = null;
        for(int i = 0 ; i < count; i ++){
            LazyOne lazy = LazyOne.getInstance();
            if( i == 0 ){
                one = lazy;
            }
            if(one != lazy){
                System.out.println("i=" + i +", one=" + one + ", lazy=" + lazy );
            }
        }
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);

        for(int i = 0 ; i < count; i ++){
            LazyOne lazy = LazyOne.getInstance1();
            if( i == 0 ){
                one = lazy;
            }
            if(one != lazy){
                System.out.println("i=" + i +", one=" + one + ", lazy=" + lazy );
            }
        }
        long t3 = System.currentTimeMillis();
        System.out.println(t3-t2);

        LazyTwo two = null;
        for(int i = 0 ; i < count; i ++){
            LazyTwo lazy = LazyTwo.getInstance();
            if( i == 0 ){
                two = lazy;
            }
            if(two != lazy){
                System.out.println("i=" + i +", two=" + two + ", lazy=" + lazy );
            }
        }
        long t4 = System.currentTimeMillis();
        System.out.println(t4-t3);
    }
}
