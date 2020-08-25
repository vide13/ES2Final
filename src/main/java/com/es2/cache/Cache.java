package com.es2.cache;

import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.map.LRUMap;

import java.util.ArrayList;


public class Cache<K, T> {

    private final long timeToLive;
    private final LRUMap CacheMap;

    public Cache(long TimeToLive, final long TimerInterval, int maxItems) {
        this.timeToLive = TimeToLive * 1000;

        CacheMap = new LRUMap(maxItems);

        if (timeToLive > 0 && TimerInterval > 0) {

            Thread t = new Thread(() -> {
                while (true) {
                    try {
                        Thread.sleep(TimerInterval * 1000);
                    } catch (InterruptedException ignored) {
                    }
                    cleanup();
                }
            });

            t.setDaemon(true);
            t.start();
        }
    }

    public void put(K key, T value) {
        synchronized (CacheMap) {
            CacheMap.put(key, new CacheObject(value));
        }
    }

    @SuppressWarnings("unchecked")
    public T get(K key) {
        synchronized (CacheMap) {
            CacheObject c = (CacheObject) CacheMap.get(key);

            if (c == null)
                return null;
            else {
                c.lastAccessed = System.currentTimeMillis();
                return c.value;
            }
        }
    }

    public void remove(K key) {
        synchronized (CacheMap) {
            CacheMap.remove(key);
        }
    }

    public int size() {
        synchronized (CacheMap) {
            return CacheMap.size();
        }
    }

    @SuppressWarnings("unchecked")
    public void cleanup() {

        long now = System.currentTimeMillis();
        ArrayList<K> deleteKey;

        synchronized (CacheMap) {
            MapIterator itr = CacheMap.mapIterator();

            deleteKey = new ArrayList<>((CacheMap.size() / 2) + 1);
            K key;
            CacheObject c;

            while (itr.hasNext()) {
                key = (K) itr.next();
                c = (CacheObject) itr.getValue();

                if (c != null && (now > (timeToLive + c.lastAccessed))) {
                    deleteKey.add(key);
                }
            }
        }

        for (K key : deleteKey) {
            synchronized (CacheMap) {
                CacheMap.remove(key);
            }

            Thread.yield();
        }
    }

    protected class CacheObject {
        public long lastAccessed = System.currentTimeMillis();
        public T value;

        protected CacheObject(T value) {
            this.value = value;
        }
    }
}