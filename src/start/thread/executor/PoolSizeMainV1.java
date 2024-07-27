package start.thread.executor;

import static start.thread.util.ExecutorUtils.*;
import static start.thread.util.MyLogger.log;
import static start.thread.util.ThreadUtils.sleep;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import start.thread.util.ExecutorUtils;

public class PoolSizeMainV1 {
    public static void main(String[] args) {
        ArrayBlockingQueue<Runnable> arrayBlockingQueue = new ArrayBlockingQueue<>(2);
        ExecutorService es = new ThreadPoolExecutor(2, 4, 3000, TimeUnit.MILLISECONDS, arrayBlockingQueue);
        printState(es);

        es.execute(new ExecutorTask("helloA"));
        printState(es, "helloA");

        es.execute(new ExecutorTask("helloB"));
        printState(es, "helloB");

        es.execute(new ExecutorTask("helloC"));
        printState(es, "helloC");

        es.execute(new ExecutorTask("helloC"));
        printState(es, "helloD");

        es.execute(new ExecutorTask("helloE"));
        printState(es, "helloE");

        es.execute(new ExecutorTask("helloF"));
        printState(es, "helloF");


        try {
            es.execute(new ExecutorTask("helloG"));
            printState(es, "helloG");
        } catch (RejectedExecutionException e) {
            log("HelloG 실행 거절 예외 발생 = " + e.getMessage());
        }

        sleep(3000);
        log("작업 수행 완료");
        printState(es);

        sleep(3000);
        log("maximumPoolSize 대기 시간 초과");
        printState(es);

        es.close();
        log("shutdown 완료");
        printState(es);
    }
}
