package utils.collections.map;

import java.util.Set;

public interface IMyMap<S, V> {
    void put(S symbol, V value);
    V get(S symbol);
    V remove(S key);
    boolean isKeyInMap(S symbol);
    Set<S> keySet();
}
