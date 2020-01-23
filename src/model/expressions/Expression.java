package model.expressions;

import model.types.Type;
import utils.collections.heap.IMyHeap;
import utils.collections.map.IMyMap;
import model.values.Value;
import utils.collections.map.MyMap;

public interface Expression {
    Value evaluate(IMyMap<String, Value> symbolsTable, IMyHeap<Integer,Value> heap);
    Type typeCheck(IMyMap<String, Type> typeEnvironment);
}
