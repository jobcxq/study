package com.cxq.java.test;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author cnxqin
 * @desc
 * @date 2020/05/30 22:00
 */
class Solution {

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("cbbd"));

    }

    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        int start = 0, max = 1;
        char [] chars = s.toCharArray();
        for(int i = 0; i < s.length() - 1; i ++){
            for(int j = i + 1; j < s.length(); j ++){
                if(j - i + 1 > max && this.isPalindrome(chars, i, j)){
                    start = i;
                    max = j - i + 1;
                }
            }
        }
        return s.substring(start, start + max);
    }

    /**
     * 判断给定字符串是否为回文字符串
     */
    public boolean isPalindrome(char[] chars, int start, int end){
        while(start < end){
            if(chars[start ++] != chars[end --]){ //若出现不等，则不为回文
                return false;
            }
        }
        return true;
    }

}
