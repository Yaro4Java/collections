package kozlov.homework;

import kozlov.homework.entity.Order;
import kozlov.homework.entity.OrderStatus;
import kozlov.homework.repository.CustomIterator;
import kozlov.homework.repository.OrderArchive;
import kozlov.homework.service.OrdersProcessor;
import kozlov.homework.service.OrdersProducer;
import kozlov.homework.service.SimpleBenchmark;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class HomeWork {

    public static void main(String[] args) throws InterruptedException {

        OrderArchive orders = new OrderArchive();

        // Filling archive with new orders
        for(int i = 0; i < 5; i++){
            orders.add(new Order());
        }

        // Processing orders
        orders.getItemByIndex(2).status = OrderStatus.PROCESSING;
        orders.getItemByIndex(4).status = OrderStatus.PROCESSING;
        orders.getItemByIndex(1).status = OrderStatus.COMPLETED;
        orders.getItemByIndex(3).status = OrderStatus.COMPLETED;

        // Using different ways to iterate over the list of orders
        System.out.println("\n1.ITERATING THROUGH COLLECTION USING DIFFERENT TOOLS:");

        iteratingThroughListUsingBasicForLoop(orders.asList());
        iteratingThroughListUsingEnhancedForLoop(orders.asList());
        iteratingThroughListUsingWhileLoop(orders.asList());
        iteratingThroughListUsingCustomIterator(orders.asList());
        iteratingThroughListUsingListBuiltInIterator(orders.asList());
        iteratingThroughListUsingListForEachMethodWithLambda(orders.asList());
        iteratingThroughListUsingStreamForEachMethodWithLambda(orders.asList());


        System.out.println("\n\n2.FILTERING COLLECTION:");

        System.out.println("\n-Initial list of orders:\n");
        orders.asList().forEach(order -> System.out.println("\t" + order.toString()));

        System.out.println("\n-Filtering (leaving items with ID > 3) and printing the list of orders:\n");
        orders.asList().stream()
                .filter(order -> order.getOrderID() > 3)
                .forEach(order -> System.out.println("\t" + order.toString()));


        System.out.println("\n\n3.WORKING WITH QUEUE IN PARALLEL:");

        BlockingQueue<Order> threadSafeQueue = new LinkedBlockingQueue<>(10);

        new Thread(new OrdersProducer(threadSafeQueue)).start();

        OrdersProcessor processor = new OrdersProcessor(threadSafeQueue);
        processor.processOrdersFromQueue();


        System.out.println("\n\n4.REMOVING DUPLICATES FROM COLLECTION:");

        Collection<String> collection = Arrays.asList("One", "One", "Two", "Three");

        System.out.println("\n-Initial List collection with duplicates:");
        System.out.println(collection.toString());

        Collection<String> collectionWithoutDuplicates = new HashSet<>(collection);

        System.out.println("\n-Ridding of duplicates by converting to a Set collection:");
        System.out.println(collectionWithoutDuplicates.toString());


        // Benchmark test
        System.out.println("\n\n5.TESTING PERFORMANCE OF COLLECTION IMPLEMENTATIONS:");

        SimpleBenchmark benchmark = new SimpleBenchmark();

        benchmark.executeBenchmark(new ArrayList(), new Vector());

        benchmark.executeBenchmark(new ArrayDeque(), new Stack());

    }

    public static void iteratingThroughListUsingBasicForLoop(List<Order> listOfOrders){

        System.out.println("\n-Iterating through list using basic for-loop:\n");

        for(int index = 0; index < listOfOrders.size(); index++){
            System.out.println("\t" + listOfOrders.get(index).toString());
        }
    }

    public static void iteratingThroughListUsingEnhancedForLoop(List<Order> listOfOrders){

        System.out.println("\n-Iterating through list using enhanced for-loop ( for each ):\n");

        for(Order oder : listOfOrders){
            System.out.println("\t" + oder.toString());
        }
    }

    public static void iteratingThroughListUsingWhileLoop(List<Order> listOfOrders){

        System.out.println("\n-Iterating through list using while-loop:\n");

        int index = 0;

        while(index < listOfOrders.size()){
            System.out.println("\t" + listOfOrders.get(index++).toString());
        }
    }

    public static void iteratingThroughListUsingStreamForEachMethodWithLambda(List<Order> listOfOrders){

        System.out.println("\n-Iterating through list using Stream.ForEach() method with Lambda parameter:\n");

        listOfOrders.stream().forEach(order -> System.out.println("\t" + order.toString()));
    }

    public static void iteratingThroughListUsingListBuiltInIterator(List<Order> listOfOrders){

        System.out.println("\n-Iterating through list using List built-in Iterator:\n");

        for (Iterator<Order> iterator = listOfOrders.iterator(); iterator.hasNext();){
            System.out.println("\t" + iterator.next().toString());
        }
    }

    public static void iteratingThroughListUsingListForEachMethodWithLambda(List<Order> listOfOrders){

        System.out.println("\n-Iterating through list using List built-in ForEach() method with Lambda parameter:\n");

        listOfOrders.forEach(order -> System.out.println("\t" + order.toString()));
    }

    public static void iteratingThroughListUsingCustomIterator(List<Order> listOfOrders){

        System.out.println("\n-Iterating through list using own custom Iterator:\n");

        CustomIterator<Order> iterator = new CustomIterator<>(listOfOrders);

        while (iterator.hasNext()){
            System.out.println("\t" + iterator.next().toString());
        }
    }
}
