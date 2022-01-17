package ru.job4j.kiss;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class MaxMinTest {

    @Test
    public void whenFindMaxIntegerValueInTheList() {
        List<Integer> list = List.of(4, 10, 26, 1, 0, 33, 12);
        assertThat(33, is(new MaxMin().max(list, Integer::compareTo)));
    }

    @Test
    public void whenFindMaxLengthStringValueInTheList() {
        List<String> stringList = List.of(
                "Hello",
                "hell",
                "executions"
        );
        assertEquals("executions", new MaxMin().max(stringList, Comparator.comparingInt(String::length)));
    }

    @Test
    public void whenFindMinIntegerValueInTheList() {
        List<Integer> list = List.of(4, 10, 26, 1, 0, 33, 12);
        assertThat(0, is(new MaxMin().min(list, Integer::compareTo)));
    }

    @Test
    public void whenFindMinLengthStringValueInTheList() {
        List<String> stringList = List.of(
                "Hello",
                "hell",
                "executions"
        );
        assertEquals("hell", new MaxMin().min(stringList, Comparator.comparingInt(String::length)));
    }

}