package create;

import org.junit.jupiter.api.Test;

public class TestCreateThread {
    @Test
    void runMyThread() {
        MyThread thread1 = new MyThread("线程A（继承Thread）");
        thread1.start();
    }
    @Test
    void runMyRunnable() {
        MyRunnable runnable = new MyRunnable();
        Thread thread2 = new Thread(runnable, "线程B（实现Runnable）");
        thread2.start();
    }
}
