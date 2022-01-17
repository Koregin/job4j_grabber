package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        T maxElement = value.get(0);
        for (T element : value) {
            if (comparator.compare(element, maxElement) > 0) {
                maxElement = element;
            }
        }
        return maxElement;
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        T minElement = value.get(0);
        for (T element : value) {
            if (comparator.compare(element, minElement) < 0) {
                minElement = element;
            }
        }
        return minElement;
    }
}
