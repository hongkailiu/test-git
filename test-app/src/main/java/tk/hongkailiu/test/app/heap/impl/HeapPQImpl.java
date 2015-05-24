package tk.hongkailiu.test.app.heap.impl;

import tk.hongkailiu.test.app.heap.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapPQImpl<T extends Comparable<T>> implements Heap<T> {

    private PriorityQueue<T> pq = new PriorityQueue<T>(11, new MyComparator());

    @Override public boolean insert(T t) {
        return pq.offer(t);
    }

    @Override public T remove() {
        return pq.poll();
    }

    public class MyComparator implements Comparator<T> {

        @Override public int compare(T t1, T t2) {
            return t2.compareTo(t1);
        }

    }
}
