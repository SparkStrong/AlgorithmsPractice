package java8.comm.thread;

public class Test {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        new Thread(mt,"Thread1").start();
        new Thread(mt,"Thread2").start();
    }
}
