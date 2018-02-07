package java8.comm.thread;

/**
 * （1）定义runnable接口的实现类，并重写该接口的run()方法，该run()方法的方法体同样是该线程的线程执行体。

 （2）创建 Runnable实现类的实例，并依此实例作为Thread的target来创建Thread对象，该Thread对象才是真正的线程对象。

 （3）调用线程对象的start()方法来启动该线程。
 */
public class RunnableThreadTest implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread name " + Thread.currentThread().getName() + " run i = " + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ": i = " + i);

            if (i == 5) {
                RunnableThreadTest rtt = new RunnableThreadTest();
                new Thread(rtt, "thread1 ").start();
                new Thread(rtt, "thread2 ").start();
            }
        }
    }
}
