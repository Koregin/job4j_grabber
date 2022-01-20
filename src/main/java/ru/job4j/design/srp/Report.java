package ru.job4j.design.srp;

import java.text.SimpleDateFormat;
import java.util.function.Predicate;

public interface Report {
    SimpleDateFormat SDF = new SimpleDateFormat("yyy MMM dd");
    String generate(Predicate<Employee> filter);
}
