package model.symbol_table;

import java.util.HashMap;

public class SymbolTable<S, V> implements ISymbolTable<S, V> {

    private HashMap<S, V> symbolMap;

    public SymbolTable() {
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
