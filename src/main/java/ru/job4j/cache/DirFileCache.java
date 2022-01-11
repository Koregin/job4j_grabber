package ru.job4j.cache;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DirFileCache extends AbstractCache<String, String> {
    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    public String getCachingDir() {
        return cachingDir;
    }

    @Override
    protected String load(String key) {
        String fileContent = null;
        try {
            fileContent = Files.readString(Path.of(cachingDir + key));
            put(key, fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }
}
