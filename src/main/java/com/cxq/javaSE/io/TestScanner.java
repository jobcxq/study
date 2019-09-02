package com.cxq.javaSE.io;


import java.io.InputStream;
import java.util.Scanner;

/**
 * @author cnxqin
 * @desc
 * @date 2019/09/01 21:00
 */
public class TestScanner {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
//        System.out.println(scanner.nextLine());
        while(scanner.hasNext()){
            System.out.println(scanner.nextLine());
        }
    }
}
