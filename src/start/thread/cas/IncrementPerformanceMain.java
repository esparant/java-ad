package start.thread.cas;

public class IncrementPerformanceMain {

    public static final long COUNT = 100_000_000;

    public static void main(String[] args) {
        test(new BasicInteger());
        test(new VolatileInteger());
        test(new SyncInteger());
        test(new MyAtomicInteger());
    }

    private static void test (IncrementInteger incrementInteger) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < COUNT; i++) {
            incrementInteger.increment();
        }

        long end = System.currentTimeMillis();
        System.out.println(incrementInteger.getClass().getSimpleName() + "'s result = " + incrementInteger.get());
        System.out.println(incrementInteger.getClass().getSimpleName() + "'s ms = " + (end - start));
    }
}
