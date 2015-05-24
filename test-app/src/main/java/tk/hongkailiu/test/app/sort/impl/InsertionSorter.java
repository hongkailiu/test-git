package tk.hongkailiu.test.app.sort.impl;

import tk.hongkailiu.test.app.sort.Sorter;

/**
 * ref.
 * P Lafore 99
 *
 * @param <T>
 * @author Liu
 */
public class InsertionSorter<T extends Comparable<T>> implements Sorter<T> {

    @Override public void sort(final T[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            T t = array[i];
            while (j >= 0 && array[j].compareTo(t) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = t;
        }
    }
}
