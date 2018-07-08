package org.dmc.algos;

import java.util.ArrayList;
import java.util.List;

public class QuickSort implements SortingAlgorithm {
    
    public <T extends Comparable<? super T>> List<T> sort(List<T> list) {
        
        if (list == null || list.size() < 2) {
            return list;
        }
        
        List<T> left = new ArrayList<>();
        List<T> right = new ArrayList<>();
        T pivot = list.get(0);
        
        for (int i = 1; i < list.size(); i++) {
            T item = list.get(i);
            
            if (item.compareTo(pivot) < 0) {
                left.add(item);
            } else {
                right.add(item);
            }
        }

        List<T> sorted = new ArrayList<>();
        sorted.addAll(sort(left));
        sorted.add(pivot);
        sorted.addAll(sort(right));
        return sorted;
    }


    public <T extends Comparable<? super T>> List<T> sortInPlace(T[] array) {
        throw new UnsupportedOperationException();
    }
}
