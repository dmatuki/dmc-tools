package org.dmc.algos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class MergeSortTest {
    
    private SortingAlgorithm sorting = new MergeSort();
    
    @Test
    public void sort() throws Exception {
        List<Integer> unsorted = Arrays.asList(5,4,3,2,1);
        assertSameOrder(Arrays.asList(1,2,3,4,5), sorting.sort(unsorted));
    }

    @Test
    public void sort_smallLists() throws Exception {
        assertSameOrder(Collections.singletonList(5), sorting.sort(Collections.singletonList(5)));
        assertSameOrder(Arrays.asList(1,2), sorting.sort(Arrays.asList(2,1)));
        assertSameOrder(Arrays.asList(3,3), sorting.sort(Arrays.asList(3,3)));
        assertSameOrder(Arrays.asList(1,4,4), sorting.sort(Arrays.asList(4,4,1)));
    }

    @Test
    public void sort_emptyLists() throws Exception {
        assertTrue(sorting.sort(new ArrayList<Integer>()).isEmpty());
        assertNull(sorting.sort(null));
    }
    
    private void assertSameOrder(List a, List b) {
        assertNotNull(a);
        assertNotNull(b);
        assertEquals(a.size(), b.size());
        for (int i = 0; i < a.size(); i++) {
            assertEquals(a.get(i), b.get(i));
        }
    }

}