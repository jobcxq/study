package com.cxq.java.base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 8000654471
 * @desc
 * @date 2019/12/6 9:33
 */
public class LongTest {

    public static void main(String[] args) {

        LinkedList<Long> longs = new LinkedList<>();
        for (int i = 0; i < 16298; i++) {
            longs.add(new Long(3008786323797062l + i));
        }

        List<Long> result = new ArrayList<>();
        while (result.size() <= 1000 && longs.size() > 0) {
            result.add(longs.removeFirst());
        }
        System.out.println(result);

    }

}
