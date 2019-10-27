package model.symbol_table;

public interface ISymbolTable<S, V> {
    public void put(S symbol, V value);
    public V get(S symbol);
}
