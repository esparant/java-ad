package start.thread.collection;

import static start.thread.util.ThreadUtils.sleep;

import java.util.Arrays;

public class BasicList implements SimpleList{


    private static final int DEFAULT_CAPACITY = 5;

    private final Object[] objects;
    private int size;

    public BasicList() {
        objects = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(Object o) {
        objects[size] = o;
        size++;
    }

    @Override
    public Object get(int index) {
        return objects[index];
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(objects, size)) + ", size = " + size;
    }
}
