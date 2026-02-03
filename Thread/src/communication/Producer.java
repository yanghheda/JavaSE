package communication;

public class Producer implements Runnable {
    private Buffer buffer;
    private int productId = 1;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            // 生产5个产品
            for (int i = 1; i <= 5; i++) {
                String product = "产品" + productId++;
                buffer.produce(product);
                Thread.sleep(500); // 模拟生产耗时
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
