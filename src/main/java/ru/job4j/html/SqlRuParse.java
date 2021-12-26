package ru.job4j.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SqlRuParse {
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

    public static List<String> getPost(String link) throws IOException {
        List<String> postInfo = new ArrayList<>();
        Document doc = Jsoup.connect(link).get();
        Elements body = doc.select(".msgBody");
        Elements footer = doc.select(".msgFooter");
        postInfo.add(body.get(1).parent().child(1).text());
        postInfo.add(footer.get(0).parent().child(0).text().split("\\[")[0].trim());
        return postInfo;
    }
}
