package start.thread.start.test;

import static start.thread.logger.MyLogger.log;

import java.util.TreeMap;
import java.util.stream.IntStream;
import start.thread.logger.MyLogger;

public class StartTest1Main {
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
        }).start();
    }
}
