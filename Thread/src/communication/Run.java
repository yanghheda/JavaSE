package communication;

public class Run {
    static void main() {
        Buffer buffer = new Buffer();

        // 创建生产者和消费者线程
        Thread producerThread = new Thread(new Producer(buffer), "生产者线程");
        Thread consumerThread = new Thread(new Consumer(buffer), "消费者线程");

        // 启动线程
        producerThread.start();
        consumerThread.start();
    }
}
