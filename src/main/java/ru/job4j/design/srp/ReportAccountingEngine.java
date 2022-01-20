package ru.job4j.design.srp;

import java.util.function.Predicate;
import static ru.job4j.design.srp.Constants.*;

public class ReportAccountingEngine implements Report {

    private Store store;

    public ReportAccountingEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;").append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(SDF.format(employee.getHired().getTime())).append(";")
                    .append(SDF.format(employee.getFired().getTime())).append(";")
                    .append(employee.getSalary() * USTORUB).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
