package ru.job4j.design.srp;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.Calendar;
import static ru.job4j.design.srp.Constants.*;

public class CalendarSerializer implements JsonSerializer<Calendar> {

    @Override
    public JsonElement serialize(Calendar calendar, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(SDF.format(calendar.getTime()));
    }
}
