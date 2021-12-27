package ru.job4j.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.grabber.Post;
import ru.job4j.grabber.utils.DateTimeParser;
import ru.job4j.grabber.utils.SqlRuDateTimeParser;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SqlRuParse {
    private final DateTimeParser dateTimeParser;

    public SqlRuParse(DateTimeParser dateTimeParser) {
        this.dateTimeParser = dateTimeParser;
    }


    public static void main(String[] args) throws Exception {
        for (int i = 1; i <= 5; i++) {
            Document doc = Jsoup.connect(String.format("https://www.sql.ru/forum/job-offers/%d", i)).get();
            Elements row = doc.select(".postslisttopic");
            for (Element td : row) {
                Element href = td.child(0);
                Element parent = td.parent();
                System.out.println(parent.child(5).text());
                System.out.println(href.attr("href"));
                System.out.println(href.text());
            }
        }
    }

    public List<Post> list(String link) throws IOException, ParseException {
        List<Post> posts = new ArrayList<>();
        Document doc = Jsoup.connect(link).get();
        Elements row = doc.select(".postslisttopic");
        for (Element td : row) {
            Element href = td.child(0);
            posts.add(detail(href.attr("href")));
        }
        return posts;
    }

    public static Post detail(String link) throws IOException, ParseException {
        Document doc = Jsoup.connect(link).get();
        Elements body = doc.select(".msgBody");
        Elements footer = doc.select(".msgFooter");
        String title = doc.select(".messageHeader").get(0).ownText();
        String description = body.get(1).parent().child(1).text();
        String dataString = footer.get(0).parent().child(0).text().split("\\[")[0].trim();
        SqlRuDateTimeParser dataParser = new SqlRuDateTimeParser();
        LocalDateTime dataCreated = dataParser.parse(dataString);
        return new Post(title, link, description, dataCreated);
    }
}
