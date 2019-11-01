package utils.collections.list;

import java.util.ArrayList;

public class MyList<T> implements IMyList<T> {

    private ArrayList<T> list;

    public MyList() {
        list = new ArrayList<>();
    }

    @Override
    public void add(T object) {
        list.add(object);
    }

    public ArrayList<T> getList() {
        return list;
    }

    @Override
    public String toString() {
        return list.toString();
    }

    @Override
    public T get(int i) {
        return list.get(i);
    }
}
