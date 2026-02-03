package communication;

public class Buffer {
    private Object product; // 存储单个产品（null表示空）

    // 生产者生产产品（同步方法，锁对象是this）
    public synchronized void produce(Object product) throws InterruptedException {
        // 缓冲区满：生产者等待（wait()会释放锁，进入等待队列）
        while (this.product != null) {
            System.out.println(Thread.currentThread().getName() + " → 缓冲区已满，等待消费者消费...");
            this.wait(); // 等待，直到被notify()唤醒
        }

        this.product = product;
        System.out.println(Thread.currentThread().getName() + " → 生产了产品：" + product);

        // 唤醒等待的消费者（notify()：唤醒一个等待线程；notifyAll()：唤醒所有）
        this.notify();
    }

    public synchronized void consume() throws InterruptedException {
        // 缓冲区空：消费者等待
        while (this.product == null) {
            System.out.println(Thread.currentThread().getName() + " → 缓冲区为空，等待生产者生产...");
            this.wait();
        }

        // 消费产品
        Object p = this.product;
        this.product = null; // 清空缓冲区
        System.out.println(Thread.currentThread().getName() + " → 消费了产品：" + p);

        // 唤醒等待的生产者
        this.notify();
    }
}
