package utils.collections.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyHeap<K, V> implements IMyHeap<K, V> {

    private HashMap<K, V> map;

    public MyHeap() {
        map = new HashMap<>();
    }

    @Override
    public void put(K key, V value) {
        map.put(key, value);
    }

    @Override
    public V get(K key) {
        return map.get(key);
    }

    @Override
    public V remove(K key) {
        return map.remove(key);
    }

    @Override
    public HashMap<K, V> getContent() {
        return map;
    }

    @Override
    public boolean isKeyInMap(K key) {
        return map.containsKey(key);
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public void setContent(Map<K, V> m) {
        map = (HashMap<K, V>) m;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (Map.Entry me : map.entrySet()) {
            string.append(me.getKey().toString()).append(" -> ").append(me.getValue().toString());
            string.append("\n");
        }
        return string.toString();
    }
}
