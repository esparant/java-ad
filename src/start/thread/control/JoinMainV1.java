package start.thread.control;

import static start.thread.util.MyLogger.log;
import static start.thread.util.ThreadUtils.sleep;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class JoinMainV1 {
    public static void main(String[] args) {
        log("start");

        AtomicInteger result = new AtomicInteger();

        new Thread(() -> sumTask(1, 50, result)).start();
        new Thread(() -> sumTask(51, 100, result)).start();

        sleep(10);

        log("result: " + result);
        log("end");
    }

    private static void sumTask(int startValue, int endValue, AtomicInteger result) {
        log("작업시작");
        int threadResult = IntStream.range(startValue, endValue + 1).sum();
        log(Thread.currentThread().getName() + " result: "  + threadResult);
        result.addAndGet(threadResult);
        log("작업끝");
    }
}
