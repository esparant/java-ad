package start.thread.collection;

import static start.thread.util.ThreadUtils.sleep;

import java.util.Arrays;

public class SyncList implements SimpleList{


    private static final int DEFAULT_CAPACITY = 5;

    private final Object[] objects;
    private int size;

    public SyncList() {
        objects = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public synchronized int size() {
        return size;
    }

    @Override
    public synchronized void add(Object o) {
        objects[size] = o;
        size++;
    }

    @Override
    public synchronized Object get(int index) {
        return objects[index];
    }

    @Override
    public synchronized String toString() {
        return Arrays.toString(Arrays.copyOf(objects, size)) + ", size = " + size;
    }
}
