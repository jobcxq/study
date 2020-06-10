package com.cxq.java.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author cnxqin
 * @desc
 * @date 2020/06/06 13:58
 */
public class Main {

    public static void main(String[] args){
        test3();
    }

    /**
     * 测试题3-模拟九宫格的按键输入，输出正确的数据
     */
    public static void test3(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String input = sc.nextLine();

            if(!input.startsWith("#")){ //# 开头，代表输入因为，否则输入数字
                System.out.println(input.replaceAll("/",""));
                continue;
            }

            int start = 1; //#2222/22 #2222/2 #2 #223 #2233 #34657
            String result = "";
            for(int i = 1; i < input.length(); i ++){
                if(input.charAt(i) != input.charAt(start)){
                    result += getChar(input.charAt(start),( i -1 - start));
                    start = i;
                    if(input.charAt(i) == '/'){
                        start ++;
                    }
                }
            }
            if(start <= input.length() - 1) {
                result += getChar(input.charAt(start), (input.length() - start - 1));
            }
            System.out.println(result);
        }
    }


    //缓存按键对于内容
    static Map<Character,String> map = new HashMap<>();
    static {
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
    }

    /**
     * 根据下数字字符及其长度，计算对于的英文字符
     * @param ch 数组字符
     * @param length 长度
     * @return
     */
    public static String getChar(char ch, int length){
        if(ch == '1'){
            return ",";
        }
        if((ch >= '2' && ch <='6')|| ch == '8'){
            length = length % 3;
        }else {
            length = length % 4;
        }

        String str = map.get(ch);
        return String.valueOf(str.charAt(length));
    }

    /**
     * 测试题2-对给点字符串按照指定规则进行加密，并输出加密后字符串
     */
    public static void test2(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = Integer.parseInt(sc.nextLine());
            for(int i = 0; i < n ; i ++){
                String str = sc.nextLine();
                char[] result = new char[str.length()];
                for(int j = 0; j < str.length() ; j ++){
                    result[j] = getDeviation(j,str.charAt(j));
                }
                System.out.println(result);
            }
        }
    }

    /**
     * 根据下标值 i 及字符 ch 计算偏移后的字符来进行加密
     * @param i
     * @param ch
     * @return 加密后的字符
     */
    public static char getDeviation(int i, char ch){
        long count = getCount(i) % 26;
        count += ch;
        if(count > 122){
            // 123 - 122 + 96 : 97 - a，122-z
            count = count - 122 + 96;
        }
        return (char) count;
    }

    //使用静态变量缓存偏移量，防止重复计算，Integer 会出现越界问题
    static Map<Long, Long> deviationMap = new HashMap<>();
    static {
        deviationMap.put(0l,1l);
        deviationMap.put(1l,2l);
        deviationMap.put(2l,4l);
    }

    /**
     * 递归计算偏移量，并将结果缓存在 Map 中
     * i >= 3 : a[i] = a[i - 1] + a[i - 2] + a[i - 3]
     * @param i 需要计算便宜量的下标
     * @return
     */
    public static long getCount(long i){
        if(deviationMap.containsKey(i)){
            return deviationMap.get(i);
        }
        long result1 = getCount(i -1);
        long result2 = getCount(i -2);
        long result3 = getCount(i -3);
        deviationMap.put(i-1,result1);
        deviationMap.put(i-2,result2);
        deviationMap.put(i-3,result3);
        return result1 + result2 + result3 ;
    }


    /**
     * 测试题1—将输入的字符串中小写字母、大写字母及数字进行反转
     */
    public static void test1(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String[] line = sc.nextLine().split(" ");
            char[] chars = line[0].toCharArray();
            int flag = Integer.parseInt(line[1]);

            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < chars.length; i ++){
                if(shouldReversal(flag,chars[i])){
                    stack.push(chars[i]); //将需要反转的字符进栈
                }
            }

            for(int i = 0; i < chars.length; i ++){
                if(shouldReversal(flag,chars[i])){
                    char ch = stack.pop(); //将需要反转的字符出栈，替换原字符串数组对应下标字符串
                    chars[i] = ch;
                }
            }
            System.out.println(chars);
        }
    }

    /**
     * 根据给定的标志及字符判断是否需要进行反转
     * @param flag 标志位
     * @param ch 字符
     * @return
     */
    public static boolean shouldReversal(int flag, char ch){
        switch (flag){
            case 1 : //小写字母
                if(ch >= 'a' && ch <= 'z'){
                    return true;
                }
                break;
            case 2 : //反转大写字母
                if(ch >= 'A' && ch <= 'Z'){
                    return true;
                }
                break;
            case 3 : //反转数字
                if(ch >= '0' && ch <= '9'){
                    return true;
                }
                break;
        }
        return false;
    }
}
