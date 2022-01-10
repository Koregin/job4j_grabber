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
        V result = null;
        if (cache.containsKey(key)) {
            System.out.println("File in the cache");
            SoftReference<V> softRef = cache.get(key);
            V value = softRef.get();
            if (value != null) {
                result = value;
            }
        } else {
            System.out.println("File not found in the cache. Load file to the cache");
            result = load(key);
        }
        return result;
    }

    protected abstract V load(K key);
}
