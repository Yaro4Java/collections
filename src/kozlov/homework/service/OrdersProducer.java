package kozlov.homework.service;

import kozlov.homework.entity.Order;
import java.util.concurrent.BlockingQueue;

public class OrdersProducer implements  Runnable{

    private final BlockingQueue<Order> queue;

    public OrdersProducer(BlockingQueue<Order> queue) {
        this.queue = queue;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {

        try {
            createOrder();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

    private void createOrder() throws InterruptedException {

        Order.resetCounter();

        // Putting 10 orders into Queue
        for (int i = 0; i < 10; i++) {

            Order order = new Order();

            System.out.printf("%n%25s: --> %s", "[Orders Producer] puts", order.toString());
            queue.put(order);

            Thread.sleep(100);
        }
    }
}
