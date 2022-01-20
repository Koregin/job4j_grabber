package ru.job4j.design.srp;

import java.util.function.Predicate;
import static ru.job4j.design.srp.Constants.*;

public class ReportProgrammerEngine implements Report {
    private Store store;

    public ReportProgrammerEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<table><tbody><tr><td>Name</td><td>Hired</td><td>Fired</td><td>Salary</td></tr><tr>");
        for (Employee employee : store.findBy(filter)) {
                    text.append("<td>").append(employee.getName()).append("</td>")
                    .append("<td>").append(SDF.format(employee.getHired().getTime())).append("</td>")
                    .append("<td>").append(SDF.format(employee.getFired().getTime())).append("</td>")
                    .append("<td>").append(employee.getSalary());
        }
        text.append("</td></tr></tbody></table>");
        return text.toString();
    }
}
