package MethodDemo;

public class Run {
    static void main() {
        Thread thread1 = new Thread(new MethodDemos(), "线程C（yield演示）");
        Thread thread2 = new Thread(new MethodDemos(), "线程D（yield演示）");

        thread1.start();
        thread2.start();
    }
}
