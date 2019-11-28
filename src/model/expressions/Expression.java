package model.expressions;

import utils.collections.heap.IMyHeap;
import utils.collections.map.IMyMap;
import model.values.Value;

public interface Expression {
    Value evaluate(IMyMap<String, Value> symbolsTable, IMyHeap<Integer,Value> heap);
}
