package utils.collections.stack;

import java.util.*;

public class MyStack<T> implements IMyStack<T> {

    private Stack<T> stack;

    public MyStack() {
        this.stack = new Stack<>();
    }

    @Override
    public T pop() {
        return this.stack.pop();
    }

    @Override
    public void push(T newObjectT) {
        this.stack.push(newObjectT);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        Object[] stackArray = (stack.toArray());
        Collections.reverse(Arrays.asList(stackArray));
        for (Object item: stackArray) {
            string.append(item.toString());
            string.append('\n');
        }
        return string.toString();
    }
}
