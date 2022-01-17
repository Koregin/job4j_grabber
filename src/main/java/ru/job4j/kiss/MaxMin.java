package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return minMaxSearch(value, (element, minElement) -> comparator.compare(element, minElement) > 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return minMaxSearch(value, (element, minElement) -> comparator.compare(element, minElement) < 0);
    }

    private <T> T minMaxSearch(List<T> value, BiPredicate<T, T> biPredicate) {
        T minmaxElement = value.get(0);
        for (T element : value) {
            if (biPredicate.test(element, minmaxElement)) {
                minmaxElement = element;
            }
        }
        return minmaxElement;
    }
}
