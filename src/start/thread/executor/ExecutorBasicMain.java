package start.thread.executor;

import static start.thread.util.ExecutorUtils.*;
import static start.thread.util.MyLogger.log;
import static start.thread.util.ThreadUtils.sleep;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import start.thread.util.ExecutorUtils;

public class ExecutorBasicMain {
    public static void main(String[] args) {
        ExecutorService es = new ThreadPoolExecutor(2, 2, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        log("== 초기 상태 ==");
        printState(es);

        es.execute(new ExecutorTask("taskA"));
        es.execute(new ExecutorTask("taskB"));
        es.execute(new ExecutorTask("taskC"));
        es.execute(new ExecutorTask("taskD"));

        log("== 작업 수행 중 ==");
        printState(es);

        sleep(3000);
        log("== 작업 완료 ==");
        printState(es);

        es.close();
        log("== shutdown 완료 ==");
        printState(es);

    }
}
