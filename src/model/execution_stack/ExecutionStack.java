package model.execution_stack;

import java.util.Stack;

public class ExecutionStack<T> implements IExecutionStack<T> {

    private Stack<T> stack;

    public ExecutionStack() {
        this.stack = new Stack<T>();
    }

    @Override
    public T pop() {
        return this.stack.pop();
    }

    @Override
    public void push(T newObjectT) {
        this.stack.push(newObjectT);
    }
}
