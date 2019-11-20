package utils.collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyMap<S, V> implements IMyMap<S, V> {

    private HashMap<S, V> symbolMap;

    public MyMap() {
        symbolMap = new HashMap<>();
    }

    @Override
    public void put(S symbol, V value) {
        symbolMap.put(symbol, value);
    }

    @Override
    public V get(S symbol) {
        return symbolMap.get(symbol);
    }

    @Override
    public V remove(S key) {
         return symbolMap.remove(key);
    }

    @Override
    public boolean isKeyInMap(S symbol) {
        return symbolMap.containsKey(symbol);
    }

    @Override
    public Set<S> keySet() {
        return symbolMap.keySet();
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (Map.Entry me : symbolMap.entrySet()) {
            string.append(me.getKey().toString()).append(" -> ").append(me.getValue().toString());
            string.append("\n");
        }
        return string.toString();
    }
}
