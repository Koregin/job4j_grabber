package ru.job4j.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.grabber.Parse;
import ru.job4j.grabber.Post;
import ru.job4j.grabber.utils.DateTimeParser;
import ru.job4j.grabber.utils.HhRuDateTimeParser;

import javax.print.Doc;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HhRuParse implements Parse {
    private final DateTimeParser dateTimeParser;

    public HhRuParse(DateTimeParser dateTimeParser) {
        this.dateTimeParser = dateTimeParser;
    }

    public static void main(String[] args) throws Exception {
        /*HhRuParse hhRuParse = new HhRuParse(new HhRuDateTimeParser());
        List<Post> postList = hhRuParse.list("https://vladimir.hh.ru/search/vacancy?area=1&employment=full&schedule=remote"
                + "&search_field=name&clusters=true&no_magic=true&ored_clusters=true&items_on_page=20"
                + "&order_by=publication_time&enable_snippets=true&search_period=7&text=Java&hhtmFrom=vacancy_search_list&page=");
        for (Post post : postList) {
            System.out.println("Название вакансии: " + post.getTitle() + " | Дата создания: " + post.getCreated());
            System.out.println("Ссылка: " + post.getLink());
        }*/
        String link = "https://vladimir.hh.ru/vacancy/50664959?from=vacancy_search_list&query=Java-%D0%BF%D1%80%D0%BE%D0%B3%D1%80%D0%B0%D0%BC%D0%BC%D0%B8%D1%81%D1%82&hhtmFrom=vacancy_search_list";
        Document document = Jsoup.connect(link).get();
        Elements row = document.select("span.bloko-header-2").attr("data-qa", "vacancy-salary-compensation-type-net");
        System.out.println(row.text());
    }

    public List<Post> list(String link) throws IOException, ParseException {
        List<Post> posts = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Document doc = Jsoup.connect(String.format(link + "%d", i)).get();
            Elements row = doc.select(".g-user-content").select(".bloko-link");
            for (Element span : row) {
                posts.add(detail(span.attr("href")));
            }
        }
        return posts;
    }

    public Post detail(String link) throws IOException, ParseException {
        Document doc = Jsoup.connect(link).get();
        String title = doc.select(".bloko-header-1").get(1).text() + " ("
                + doc.select("span.bloko-header-2")
                .attr("data-qa", "vacancy-salary-compensation-type-net").text() + ")";
        String description = doc.select(".g-user-content").get(0).text();
        String dataString = doc.select(".vacancy-creation-time").get(0).text();
        LocalDateTime dataCreated = dateTimeParser.parse(dataString);
        return new Post(title, link, description, dataCreated);
    }
}
