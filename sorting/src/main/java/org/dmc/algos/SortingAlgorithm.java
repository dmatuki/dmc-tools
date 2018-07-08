package org.dmc.algos;

import java.util.List;

public interface SortingAlgorithm {

    <T extends Comparable<? super T>> List<T> sort(List<T> list);

    <T extends Comparable<? super T>> List<T> sortInPlace(T[] array);
}
