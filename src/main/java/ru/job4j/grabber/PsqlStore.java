package ru.job4j.grabber;

import ru.job4j.grabber.utils.SqlRuDateTimeParser;
import ru.job4j.html.SqlRuParse;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PsqlStore implements Store, AutoCloseable {

    private Connection cnn;

    private static Properties readParams() {
        Properties config = new Properties();
        try (InputStream in = PsqlStore.class.getClassLoader().getResourceAsStream("grabber.properties")) {
            config.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return config;
    }

    public PsqlStore(Properties cfg) throws SQLException {
        try {
            Class.forName(cfg.getProperty("jdbc.driver"));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        cnn = DriverManager.getConnection(
                cfg.getProperty("url"),
                cfg.getProperty("username"),
                cfg.getProperty("password"));
    }

    public static void main(String[] args) {
        try (PsqlStore psqlStore = new PsqlStore(readParams())) {
            SqlRuParse sqlRuParse = new SqlRuParse(new SqlRuDateTimeParser());
            List<Post> postList = sqlRuParse.list("https://www.sql.ru/forum/job-offers");
            for (Post post: postList) {
                psqlStore.save(post);
            }
            System.out.println("Выводим заголовок поста с ID = 10");
            System.out.println(psqlStore.findById(10).getTitle());
            System.out.println("Выводим заголовки всех постов");
            for (Post post: psqlStore.getAll()) {
                System.out.println(post.getTitle());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(Post post) {
        try (PreparedStatement ps = cnn.prepareStatement("insert into post(name, text, link, created) values(?, ?, ?, ?)")) {
            ps.setString(1, post.getTitle());
            ps.setString(2, post.getDescription());
            ps.setString(3, post.getLink());
            ps.setTimestamp(4, Timestamp.valueOf(post.getCreated()));
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Post> getAll() {
        List<Post> result = new ArrayList<>();
        try (PreparedStatement ps = cnn.prepareStatement("select * from post")) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    result.add(createPost(rs));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private Post createPost(ResultSet rs) throws SQLException {
        Post post = new Post();
        post.setId(rs.getInt("id"));
        post.setTitle(rs.getString("name"));
        post.setLink(rs.getString("link"));
        post.setDescription(rs.getString("text"));
        post.setCreated(rs.getTimestamp("created").toLocalDateTime());
        return post;
    }

    @Override
    public Post findById(int id) {
        Post post = null;
        try (PreparedStatement ps = cnn.prepareStatement("select * from post where id = ?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    post = createPost(rs);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return post;
    }

    @Override
    public void close() throws Exception {
        if (cnn != null) {
            cnn.close();
        }
    }
}
