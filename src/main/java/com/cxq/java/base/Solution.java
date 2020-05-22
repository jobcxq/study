package com.cxq.java.base;

import java.util.*;

/**
 * @author 8000654471
 * @desc
 * @date 2020/4/8 10:27
 */


public class Solution {

    public int findLHS(int[] nums) {
        int[] resul1t = new int[2];
        int result = 2;
        for(int i = 0; i < nums.length ; i ++){
            int before = nums[i];

            int after = before;
            for(int j = i + 1 ; j < nums.length - i - 1; j ++){
                int sub = getSub(before,after,nums[j]);
                if(sub <= 1){
                    if(result < j - i)
                        result = j - i;
//                    continue;
                }
                after = nums[j + 1];

            }
        }
        return result;
    }

    public int getSub(int before,int after,int temp){
        int max,min;
        if(before > after){
            max = before;
            min = after;
        }else{
            min = before;
            max = after;
        }

        if(temp > max){
            return temp - min;
        }

        if(temp < min){
            return max - temp;
        }
        return max - min;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
//        int[] nums = {1,3,2,2,5,2,3,7};
//        System.out.println(solution.findLHS(nums));

        int[] result = solution.findSwapValues(new int[]{1, 2, 3},new int[]{4, 5, 6});
        System.out.println(result[0] );
        System.out.println(result[1] );
        List<List<Integer>> result1  = new ArrayList<>();
    }

    public int[] findSwapValues(int[] array1, int[] array2) {

        List list = new ArrayList<Integer>();
        int sub = sum(array1, null) - sum(array2,list);
        if(sub % 2 == 1){
            return new int[0];
        }
        sub = sub/2;
        int[] result = new int[2];

        for(int i = 0; i < array1.length; i ++){
            int num2 = array1[i] - sub;
            if(list.contains(num2)){
                result[0] = array1[i];
                result[1] = num2;
                return result;
            }


        }
        return new int[0];
    }

    public int sum(int[] array, List list){
        int count = 0;
        for(int i = 0; i < array.length; i ++){
            count += array[i];
            if(list != null) list.add(array[i]);
        }
        return count;
    }

}
