package utils.collections.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public interface IMyHeap<K, V> {
    void put(K key, V value);
    V get(K key);
    V remove(K key);
    HashMap<K, V> getContent();
    void setContent(Map<K, V> m);
    boolean isKeyInMap(K key);
    Set<K> keySet();
}
