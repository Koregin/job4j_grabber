package ru.job4j.design.srp;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static ru.job4j.design.srp.Constants.*;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(SDF.format(worker.getHired().getTime())).append(";")
                .append(SDF.format(worker.getFired().getTime())).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        System.out.println(engine.generate(em -> true));
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenRequirementsForProgrammers() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Petr", now, now, 1000);
        store.add(worker);
        Report engine = new ReportProgrammerEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("<table><tbody><tr><td>Name</td><td>Hired</td><td>Fired</td><td>Salary</td></tr><tr>")
                .append("<td>").append(worker.getName()).append("</td>")
                .append("<td>").append(SDF.format(worker.getHired().getTime())).append("</td>")
                .append("<td>").append(SDF.format(worker.getFired().getTime())).append("</td>")
                .append("<td>").append(worker.getSalary()).append("</td></tr></tbody></table>");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void wnenRequirementsForAccounting() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Evgeny", now, now, 5000);
        double uStoRUB = 75.5;
        store.add(worker);
        Report engine = new ReportAccountingEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(SDF.format(worker.getHired().getTime())).append(";")
                .append(SDF.format(worker.getFired().getTime())).append(";")
                .append(worker.getSalary() * uStoRUB).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

   @Test
   public void whenRequirementsForHR() {
       MemStore store = new MemStore();
       Calendar now = Calendar.getInstance();
       Employee worker1 = new Employee("Ivan", now, now, 100);
       Employee worker2 = new Employee("Petr", now, now, 1000);
       Employee worker3 = new Employee("Evgeny", now, now, 5000);
       store.add(worker1);
       store.add(worker2);
       store.add(worker3);
       Report engine = new ReportHREngine(store);
       StringBuilder expect = new StringBuilder()
               .append("Name; Salary;")
               .append(System.lineSeparator())
               .append(worker3.getName()).append(";")
               .append(worker3.getSalary()).append(";")
               .append(System.lineSeparator())
               .append(worker2.getName()).append(";")
               .append(worker2.getSalary()).append(";")
               .append(System.lineSeparator())
               .append(worker1.getName()).append(";")
               .append(worker1.getSalary()).append(";")
               .append(System.lineSeparator());
       assertThat(engine.generate(em -> true), is(expect.toString()));
   }
}