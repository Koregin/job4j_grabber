package ru.job4j.grabber.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;

import static java.util.Map.entry;

public class SqlRuDateTimeParser implements DateTimeParser {
    private static final Map<String, String> MONTHS = Map.ofEntries(
            entry("янв", "1"),
            entry("фев", "2"),
            entry("мар", "3"),
            entry("апр", "4"),
            entry("май", "5"),
            entry("июн", "6"),
            entry("июл", "7"),
            entry("авг", "8"),
            entry("сен", "9"),
            entry("окт", "10"),
            entry("ноя", "11"),
            entry("дек", "12")
    );

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("d M y, H:m");
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("d M y");

    @Override
    public LocalDateTime parse(String parse) throws ParseException {
        if (parse.contains("сегодня")) {
            parse = parse.replace("сегодня", LocalDate.now().format(DATE_TIME_FORMATTER));
        } else if (parse.contains("вчера")) {
            parse = parse.replace("вчера", LocalDate.now().minusDays(1).format(DATE_TIME_FORMATTER));
        }
        Date date = SIMPLE_DATE_FORMAT.parse(monthConvert(parse));
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    private static String monthConvert(String dateTime) {
        for (String str: MONTHS.keySet()) {
            if (dateTime.contains(str)) {
                dateTime = dateTime.replace(str, MONTHS.get(str));
                break;
            }
        }
        return dateTime;
    }

    public static void main(String[] args) throws Exception {
        Document doc = Jsoup.connect("https://www.sql.ru/forum/job-offers").get();
        Elements row = doc.select(".postslisttopic");
        SqlRuDateTimeParser sqlParser = new SqlRuDateTimeParser();
        for (Element td : row) {
            Element href = td.child(0);
            Element parent = td.parent();
            System.out.println(sqlParser.parse(parent.child(5).text()).toString());
            System.out.println(href.attr("href"));
            System.out.println(href.text());
        }
    }
}
