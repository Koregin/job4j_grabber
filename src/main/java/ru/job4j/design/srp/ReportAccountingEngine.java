package ru.job4j.design.srp;

import java.text.SimpleDateFormat;
import java.util.function.Predicate;

public class ReportAccountingEngine implements Report {

    private Store store;
    private static final double USTORUB = 75.5;

    public ReportAccountingEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("yyy MMM dd");
        text.append("Name; Hired; Fired; Salary;").append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(sdf.format(employee.getHired().getTime())).append(";")
                    .append(sdf.format(employee.getFired().getTime())).append(";")
                    .append(employee.getSalary() * USTORUB).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
