package com.cxq.java.algorithm;

import java.util.Stack;

/**
 * @author cnxqin
 * @desc 10进制转换
 * @date 2020/04/08 19:05
 */
public class DecimalConvert {

    /**
     * 进制转换，请设计一个函数，输入10进制的数字，输出它的62进制表达方式。
     * @param args
     */
    public static void main(String[] args){
        DecimalConvert convert = new DecimalConvert();
        System.out.println(convert.convert10To2(15));
        System.out.println(convert.convert10To62(62));
    }

    /**
     * 将给点的10进制数转换为62进制数
     * @param num
     * @return
     */
    public String convert10To2(int num){
        Stack<Integer> stack = new Stack<Integer>();
        StringBuilder result = new StringBuilder("");
        int x;
        while (num != 0) {
            x= num%2;
            stack.push(x);
            num /= 2;
        }
        while(!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }


    /**
     * 将给点的10进制数转换为62进制数
     * @param num
     * @return
     */
    public String convert10To62(long num) {
        //64 进制对应编码
        char[] charSet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
        Stack<Character> stack = new Stack<Character>();
        StringBuilder result = new StringBuilder();
        while (num != 0) {
            //计算出 62 倍数所在的编码
            stack.add(charSet[new Long(num % 62).intValue()]);
            num = num / 62; //处理剩余数据
        }
        while(!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }


}
