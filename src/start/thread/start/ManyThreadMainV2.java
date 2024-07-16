package start.thread.start;

import static start.thread.util.MyLogger.log;

import java.util.stream.IntStream;

public class ManyThreadMainV2 {
    public static void main(String[] args) {
        log("main start");

        IntStream.range(0, 1000)
                .forEach(i -> new Thread(() -> log(Thread.currentThread().getName() + " hello")).start());

        log("main end");


    }
}
