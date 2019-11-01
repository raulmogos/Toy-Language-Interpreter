package utils.collections.map;

import java.util.HashMap;

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
    public boolean isSymbolInTable(S symbol) {
        return symbolMap.containsKey(symbol);
    }

    @Override
    public String toString() {
        return symbolMap.toString();
    }
}
