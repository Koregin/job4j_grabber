package ru.job4j.cache;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.atomic.AtomicLong;

public class DirFileCache extends AbstractCache<String, String> {
    private final String cachingDir;
    static final AtomicLong lookupLoadCalls = new AtomicLong();

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    public String getCachingDir() {
        return cachingDir;
    }

    @Override
    protected String load(String key) {
        lookupLoadCalls.incrementAndGet();
        String fileContent = null;
        try {
            fileContent = Files.readString(Path.of(cachingDir, key));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }
}
