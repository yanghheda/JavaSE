package communication;

public class Consumer implements Runnable {
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            // 消费5个产品
            for (int i = 1; i <= 5; i++) {
                buffer.consume();
                Thread.sleep(800); // 模拟消费耗时
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
