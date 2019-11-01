package utils.collections.map;

public interface IMyMap<S, V> {
    void put(S symbol, V value);
    V get(S symbol);
    boolean isSymbolInTable(S symbol);
}
