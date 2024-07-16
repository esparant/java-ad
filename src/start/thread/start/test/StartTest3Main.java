package start.thread.start.test;

import static start.thread.util.MyLogger.log;

public class StartTest3Main {
    public static void main(String[] args) {
        new Thread(() -> yeah("A", 1000), "Thread-A").start();
        new Thread(() -> yeah("B", 500), "Thread-B").start();

    }

    private static void yeah(Object o, int millis) {
        while (true) {
            log(o);
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
