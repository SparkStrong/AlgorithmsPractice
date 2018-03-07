package java8.comm.threadLocal;

public class TestThread2 extends Thread{

    private NumWithThreadLocal numWithThreadLocal;

    public TestThread2(NumWithThreadLocal numWithThreadLocal) {
        this.numWithThreadLocal = numWithThreadLocal;
    }

    public void run() {
        for (int i = 0; i < 4; i++) {
            System.out.println("thread[" + Thread.currentThread().getName()
                    + "] -----  i = " + numWithThreadLocal.getNextNum());
        }
    }
}
