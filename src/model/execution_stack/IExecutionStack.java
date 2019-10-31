package model.execution_stack;

public interface IExecutionStack<T> {
    T pop();
    void push(T newObjectT);
    boolean isEmpty();
}
