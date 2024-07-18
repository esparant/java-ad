package start.thread.control;

import static start.thread.util.MyLogger.log;
import static start.thread.util.ThreadUtils.sleep;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class JoinMainV2 {
    public static void main(String[] args) throws InterruptedException {
        log("start");

        AtomicInteger result = new AtomicInteger();

        Thread threadA = new Thread(() -> sumTask(1, 50, result));
        threadA.start();
        Thread threadB = new Thread(() -> sumTask(51, 100, result));
        threadB.start();

        threadA.join(1000);
        threadB.join(1000);

        log("result: " + result);
        log("end");
    }

    private static void sumTask(int startValue, int endValue, AtomicInteger result) {
        log("작업시작");
        int threadResult = IntStream.range(startValue, endValue + 1).sum();
        log(Thread.currentThread().getName() + " result: "  + threadResult);
        result.addAndGet(threadResult);
        log("작업끝");
    }=
}
