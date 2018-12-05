package leetcode.misc;

import org.junit.Test;

public class LRUCacheTest {

    @Test
    public void test() {
        LRUCache cache = new LRUCache(2);

        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        cache.get(1);
        cache.get(2);
    }
}
