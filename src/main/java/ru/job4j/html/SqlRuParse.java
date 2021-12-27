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
        SqlRuParse sqlRuParse = new SqlRuParse(new SqlRuDateTimeParser());
        List<Post> postList = sqlRuParse.list("https://www.sql.ru/forum/job-offers");
    }

    public List<Post> list(String link) throws IOException, ParseException {
        List<Post> posts = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Document doc = Jsoup.connect(String.format(link + "/%d", i)).get();
            Elements row = doc.select(".postslisttopic");
            for (Element td : row) {
                Element href = td.child(0);
                if (href.text().toLowerCase().contains("java") && !href.text().toLowerCase().contains("javascript")) {
                    posts.add(detail(href.attr("href")));
                }
            }
        }
        return posts;
    }

    public Post detail(String link) throws IOException, ParseException {
        Document doc = Jsoup.connect(link).get();
        String title = doc.select(".messageHeader").get(0).ownText();
        String description = doc.select(".msgBody").get(1).text();
        String dataString = doc.select(".msgFooter").get(0).text();
        LocalDateTime dataCreated = dateTimeParser.parse(dataString);
        return new Post(title, link, description, dataCreated);
    }
}
