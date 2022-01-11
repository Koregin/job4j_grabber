package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {
    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
        SoftReference<V> refValue = new SoftReference<V>(value);
        cache.put(key, refValue);
    }

    public V get(K key) {
        V value = cache.getOrDefault(key, new SoftReference<V>(null)).get();
        if (value == null) {
            System.out.println("File not found in the cache. Load file to the cache");
            value = load(key);
        }
        return value;
    }

    protected abstract V load(K key);
}
