package model.symbol_table;

public interface ISymbolTable<S, V> {
    void put(S symbol, V value);
    V get(S symbol);
    boolean isSymbolInTable(S symbol);
}
