package ru.job4j.design.srp;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReportHREngine implements Report {

    private Store store;

    public ReportHREngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;").append(System.lineSeparator());
        List<Employee> employeeList = store.findBy(filter).stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.toList());
        for (Employee employee : employeeList) {
                    text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
