package thread_safe;

public class TicketSale implements Runnable {
    private int ticketNum = 10;
    private boolean isRunning = true;

    public synchronized void safeSell() {
        if(ticketNum > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 【安全】卖出第 " + ticketNum-- + " 张票，剩余：" + ticketNum);
        } else{
            isRunning = false;
        }
    }

    @Override
    public void run() {
        while (isRunning) {
            safeSell();
        }
    }
}
