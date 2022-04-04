package com.xingzhou.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author xingzhou
 * @version 1.0.0
 * @ClassName com.xingzhou.algorithm.Test.java
 * @Description TODO
 * @createTime 2022年03月26日 17:03:00
 */
public class Test {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> map1 = null;
        HashMap<Integer, Integer> map2 = new HashMap<>();

        map.putAll(map2);
        System.out.println("~~~~");
        List<String> list1 = Arrays.asList("1", "2", "3");
        List<String> lista = Arrays.asList("1", "2", "3", "d");

//        List<String> collect = IntStream.range(0, lista.size()).filter(i -> (i > list1.size() || list1.get(i) == null)).mapToObj(i -> lista.get(i)).collect(Collectors.toList());
//        lista.stream().filter(i -> !list1.contains(i) || list.get)

//        System.out.println(collect);
        long l = System.currentTimeMillis();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long l1 = System.currentTimeMillis() - l;
        System.out.println(l1);
    }
}
