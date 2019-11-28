package controller.garbage_collector;

import model.values.RefValue;
import model.values.Value;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GarbageCollector {

    public static Map<Integer, Value> unsafeGarbageCollector(List<Integer> symbolTableAddresses, List<Integer> addressesFromHeapCells, Map<Integer, Value> heap) {
        List<Integer> addressesUsed = Stream.concat(symbolTableAddresses.stream(), addressesFromHeapCells.stream())
                .collect(Collectors.toList());
        return heap.entrySet().stream()
                .filter(e->addressesUsed.contains(e.getKey()))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    }

    public static List<Integer> getAddressesFromSymbolTable(Collection<Value> symTableValues){
        return symTableValues
                .stream()
                .filter(v-> v instanceof RefValue)
                .map(v-> ((RefValue) v).getAddress())
                .collect(Collectors.toList());
    }

    public static List<Integer> getAddressesFromHeapCells(Collection<Value> heap) {
        return heap
                .stream()
                .filter(v-> v instanceof RefValue)
                .map(v-> ((RefValue) v).getAddress())
                .collect(Collectors.toList());
    }
}
