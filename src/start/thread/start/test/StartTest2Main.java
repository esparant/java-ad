package start.thread.start.test;

import static start.thread.util.MyLogger.log;

public class StartTest2Main {
    public static void main(String[] args) {

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                log("value: " + (i + 1));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "counter").start();

    }
}
