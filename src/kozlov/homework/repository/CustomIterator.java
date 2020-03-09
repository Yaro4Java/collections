package kozlov.homework.repository;

import kozlov.homework.entity.Order;
import java.util.Iterator;
import java.util.List;

public class CustomIterator<E> implements Iterator<E> {

    private List<E> orders;

    private int index;

    public CustomIterator(List orders) {
        this.orders = orders;
    }

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        return index != orders.size();
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public E next() {
        return orders.get(index++);
    }
}
