package java8.comm.threadLocal;

public class NumWithThreadLocal {
    private ThreadLocal<Integer> num = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public int getNextNum() {
        Integer a = num.get();
        if (a == null) {
            a = 0;
            num.set(a);
        }

        num.set(++a);

        return num.get();
    }
}
