package kozlov.homework.repository;

import kozlov.homework.entity.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderArchive implements Archive<Order>{

    private List<Order> listOfOrders = new ArrayList<>();

    @Override
    public void add(Order item) {
        listOfOrders.add(item);
    }

    @Override
    public Order getItemByIndex(int index) {
        return listOfOrders.get(index);
    }

    @Override
    public List<Order> asList() {
        return listOfOrders;
    }
}
