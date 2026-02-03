package thread_safe;

public class run {
    static void main(String[] args) {
        TicketSale ticketSale = new TicketSale();
        Thread t1 = new Thread(ticketSale, "窗口1");
        Thread t2 = new Thread(ticketSale, "窗口2");
        Thread t3 = new Thread(ticketSale, "窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
