package java8.comm.threadLocal;

public class NumNoThreadLocal {
    private int num = 0;

    public int getNextNum() {
        return num++;
    }
}
