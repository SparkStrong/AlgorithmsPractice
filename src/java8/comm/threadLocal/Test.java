package java8.comm.threadLocal;

import java.lang.ref.Reference;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Test {

    public static void main(String[] args) {
//        NumNoThreadLocal numNoThreadLocal = new NumNoThreadLocal();
//        TestThread t1 = new TestThread(numNoThreadLocal);
//        TestThread t2 = new TestThread(numNoThreadLocal);
//        TestThread t3 = new TestThread(numNoThreadLocal);
//
//        t1.start();
//        t2.start();
//        t3.start();

//        NumWithThreadLocal numWithThreadLocal = new NumWithThreadLocal();
//        TestThread2 tt1 = new TestThread2(numWithThreadLocal);
//        TestThread2 tt2 = new TestThread2(numWithThreadLocal);
//        TestThread2 tt3 = new TestThread2(numWithThreadLocal);
//
//        tt1.start();
//        tt2.start();
//        tt3.start();

//        Hashtable<Integer, Integer> num = new Hashtable<>();
//        for (int i = 0; i < 16; i++) {
//            num.put(i, i);
//        }
        WeakHashMap<Integer, Integer> weakHashMap = new WeakHashMap<>();
        weakHashMap.put(1, 2);
    }
}
