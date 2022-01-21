package ru.job4j.design.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Calendar;
import java.util.function.Predicate;

public class ReportEngineJSON implements Report {
    private Store store;

    public ReportEngineJSON(MemStore store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        Gson gson = new GsonBuilder().registerTypeHierarchyAdapter(Calendar.class, new CalendarSerializer()).create();
        return gson.toJson(store.findBy(filter));
    }
}
