package java8.comm.thread;

import java.util.PrimitiveIterator;

public class MyThread implements Runnable {

    private static int NUM = 3;
    private String name = "test";

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        if(name.equals("Thread1")){
            synMethod();
        }
        else if(name.equals("Thread2")){
            notSynMethod();
        }
    }

    private void synMethod() {
        synchronized (this) {
            for (int i = 0; i < NUM; i++) {
                System.out.println("syn: " + Thread.currentThread().getName() + "  running. i = " + i);
                func1("syn");  //  不能保证func1 的执行会同步
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    private void notSynMethod() {
        for(int i = 0; i < NUM; i++){
            System.out.println("not syn: " + Thread.currentThread().getName()+"  running.  i = " + i);
            func1("notSyn");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void func1(String funcName) {
        for (int i = 0; i < NUM; i++) {
            System.out.println(funcName +  " func1 i = " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
