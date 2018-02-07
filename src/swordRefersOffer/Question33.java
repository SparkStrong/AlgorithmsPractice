package swordRefersOffer;

import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Question33 {
    public static void printMinNumber(int[] nums) {
        List<String> arrayStr = Arrays.stream(nums).boxed().map(num -> num.toString()).collect(Collectors.toList());

        arrayStr.forEach(e -> System.out.println("ele = " + e));

//        Collections.sort(arrayStr, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                String s1 = o1 + o2;
//                String s2 = o2 + o1;
//                return s1.compareTo(s2);
//            }
//        });


        arrayStr.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s1.compareTo(s2);
            }
        });

        arrayStr.forEach(e -> System.out.println("ele = " + e));

//        StringBuilder result = new StringBuilder();
//        for (String e: arrayStr) {
//            result.append(e);
//        }

        String res = arrayStr.stream().collect(Collectors.joining());

        System.out.println("res = " + res);

//        System.out.println(result.toString());
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 321, 2, 4, 1};
        printMinNumber(nums);

    }
}
