package model.execution_stack;

public interface IExecutionStack<T> {
    public T pop();
    public void push(T newObjectT);
}
