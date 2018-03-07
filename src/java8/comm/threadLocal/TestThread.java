package java8.comm.threadLocal;

public class TestThread extends Thread {
    private NumNoThreadLocal numNoThreadLocal;

    public TestThread(NumNoThreadLocal numNoThreadLocal) {
        this.numNoThreadLocal = numNoThreadLocal;
    }

    @Override
    public void run() {
        super.run();
        for(int i = 0; i < 4; i++) {
            System.out.println("thread[" + Thread.currentThread().getName()
                    + "] -----  i = " + numNoThreadLocal.getNextNum());
        }
    }
}
