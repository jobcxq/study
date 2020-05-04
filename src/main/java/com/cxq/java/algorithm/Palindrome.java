package com.cxq.java.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cnxqin
 * @desc 查找给点字符串的回文子串
 * @date 2020/04/08 19:05
 */
public class Palindrome {

    /*
    * 有一串字符串，请通过java程序，找出其中所有的回文字符子串。
    * 比如：输入ABCBDDD，输出：BCB、DD、DD、DDD
    * */

    public static void main(String[] args){
        Palindrome palindrome = new Palindrome();
        String str = "ABCBDDD";
        List<String> result = palindrome.findPalindrome(str);
        for(String str1 : result){
            System.out.println(str1);
        }
    }

    /**
     * 查找给点字符串的回文子串
     * @param str
     * @return
     */
    public List<String> findPalindrome(String str){
        List<String> result = new ArrayList<>();
        for(int i = 0; i < str.length(); i ++ ){
            for(int j = i + 1; j < str.length() && j > i; j ++){
                String sub = str.substring(i, j + 1);
                if (isPalindrome(sub)) { //判断子串是否为回文
                    result.add(sub);
                }
            }
        }
        return result;
    }

    /**
     * 判断给定字符串是否为回文字符串
     * @param str 给定字符串
     * @return 是否回文
     */
    public boolean isPalindrome(String str){
        if(str == null || str.length() <= 1){
            return false;
        }
        char [] ch = str.toCharArray();
        int i = 0, j = ch.length - 1;
        while(i <= j){
            if(ch[i ++] != ch[j --]){ //若出现不等，则不为回文
                return false;
            }
        }

        return true;
    }

}
