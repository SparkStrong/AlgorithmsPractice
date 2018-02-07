package java8.comm.thread;

/**
 * 通过继承Thread，重写run()方法来实现
 */
public class ThreadTest1 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread name " + getName() + " i = " + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ": i = " + i);

            if (i == 5) {
                new ThreadTest1().start();
                new ThreadTest1().start();
            }
        }
    }
}
