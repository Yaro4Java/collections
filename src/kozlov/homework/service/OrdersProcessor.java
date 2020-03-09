package kozlov.homework.service;

import kozlov.homework.entity.Order;
import kozlov.homework.entity.OrderStatus;

import java.util.concurrent.BlockingQueue;

public class OrdersProcessor {

    private final BlockingQueue<Order> queue;

    public OrdersProcessor(BlockingQueue<Order> queue) {
        this.queue = queue;
    }

    public void processOrdersFromQueue() throws InterruptedException {

        while (true) {

            Order orderToProcess;

            orderToProcess = queue.take();
            orderToProcess.status = OrderStatus.COMPLETED;

            System.out.printf("%n%25s: <-- %s", "[Orders Processor] takes", orderToProcess.toString());

            if (queue.isEmpty() && (Order.getCounter() == 10)){
                System.out.println("\n\n All orders are now completed in parallel - while accepting incoming orders!");
                break;
            }

            Thread.sleep(500);

        }
    }
}
