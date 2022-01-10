package ru.job4j.cache;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DirFileCache extends AbstractCache<String, String> {
    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(cachingDir + key))) {
            String line;
            while ((line = br.readLine()) !=  null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }
            put(key, sb.toString());
            System.out.println("File loaded in the cache");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
