package kozlov.homework.repository;

import java.util.List;

public interface Archive<E> {

    void add(E item);

    E getItemByIndex(int index);

    List<E> asList();

}
