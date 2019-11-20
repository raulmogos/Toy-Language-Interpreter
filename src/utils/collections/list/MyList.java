package utils.collections.list;

import java.util.ArrayList;
import java.util.Set;

public class MyList<T> implements IMyList<T> {

    private ArrayList<T> list;

    public MyList() {
        list = new ArrayList<>();
    }

    public MyList(Set<T> set) {
        list = new ArrayList<>(set);
    }

    @Override
    public void add(T object) {
        list.add(object);
    }

    public ArrayList<T> getList() {
        return list;
    }

    @Override
    public T get(int i) {
        return list.get(i);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (T item: list) {
            string.append(item.toString());
            string.append('\n');
        }
        return string.toString();
    }
}
