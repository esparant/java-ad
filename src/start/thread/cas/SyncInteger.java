package start.thread.cas;

public class SyncInteger implements IncrementInteger{

    private int value;

    @Override
    synchronized public void increment() {
        value++;
    }

    @Override
    public int get() {
        return value;
    }
}
