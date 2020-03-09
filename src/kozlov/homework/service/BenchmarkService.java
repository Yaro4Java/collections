package kozlov.homework.service;

import java.util.Collection;

public interface BenchmarkService<T> {

    void executeBenchmark(Collection<T> firstList, Collection<T> secondList) throws InterruptedException;

}
