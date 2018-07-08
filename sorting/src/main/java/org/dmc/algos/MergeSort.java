package org.dmc.algos;

import java.util.ArrayList;
import java.util.List;

public class MergeSort implements SortingAlgorithm {

    public <T extends Comparable<? super T>> List<T> sort(List<T> list) {
        
        if (list == null || list.size() < 2) {
            return list;
        }
        
        int middle = list.size() / 2;
        List<T> left = sort(list.subList(0, middle));
        List<T> right = sort(list.subList(middle, list.size()));
        
        List<T> sorted = new ArrayList<>();
        
        int l = 0;
        int r = 0;
        
        while (l < left.size() && r < right.size()) {
            T leftItem = left.get(l);
            T rightItem = right.get(r);
            
            if (leftItem.compareTo(rightItem) < 0) {
                sorted.add(leftItem);
                l++;
            } else {
                sorted.add(rightItem);
                r++;
            }
        }
        
        while (l < left.size()) {
            sorted.add(left.get(l));
            l++;
        }
        
        while (r < right.size()) {
            sorted.add(right.get(r));
            r++;
        }
        
        return sorted;
    }
    
    public <T extends Comparable<? super T>> List<T> sortInPlace(T[] array) {
        throw new UnsupportedOperationException();
    }
}
