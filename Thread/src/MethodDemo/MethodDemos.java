package MethodDemo;

public class MethodDemos implements Runnable {

    @Override
    public void run() {
        for(int i=0;i<3;i++){
            System.out.println(Thread.currentThread().getName() + "执行中...");
            if (i == 2) {
                System.out.println(Thread.currentThread().getName() + " 主动让步（yield）");
                Thread.yield(); // 线程让步
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
