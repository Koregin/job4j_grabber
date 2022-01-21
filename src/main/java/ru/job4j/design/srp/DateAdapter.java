package ru.job4j.design.srp;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.ParseException;
import java.util.Calendar;
import static ru.job4j.design.srp.Constants.*;

public class DateAdapter extends XmlAdapter<String, Calendar> {

    @Override
    public String marshal(Calendar v) {
        return SDF.format(v.getTime());
    }

    @Override
    public Calendar unmarshal(String v) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(SDF.parse(v));
        return cal;
    }

}
