package model.symbol_table;

import java.util.HashMap;

public class SymbolTable<S, V> implements ISymbolTable<S, V> {

    private HashMap<S, V> symbolMap;

    public SymbolTable() {
        symbolMap = new HashMap<S, V>();
    }

    @Override
    public void put(S symbol, V value) {
        symbolMap.put(symbol, value);
    }

    @Override
    public V get(S symbol) {
        return symbolMap.get(symbol);
    }
}
