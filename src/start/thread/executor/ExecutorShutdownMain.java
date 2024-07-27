package start.thread.executor;

import static start.thread.util.ExecutorUtils.printState;
import static start.thread.util.MyLogger.log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorShutdownMain {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.execute(new ExecutorTask("taskA"));
        es.execute(new ExecutorTask("taskB"));
        es.execute(new ExecutorTask("taskC"));
        es.execute(new ExecutorTask("taskD"));
        es.execute(new ExecutorTask("wrongTask", 1000000));
        printState(es);
        log("shutdown 시작");
        shutdownAndAwaitTermination(es);
        log("shutdown 완료");
        printState(es);
    }

    private static void shutdownAndAwaitTermination(ExecutorService es) {
        es.shutdown(); // non-blocking 새로운 작업 안받음, 처리 중이나 큐에 이미 대기중인 작업은 처리

        try {
            // 이미 대기중인 작업들을 모두 완료할때까지 10초 대기
            if (!es.awaitTermination(10, TimeUnit.SECONDS)) {
                // 정상 종료가 너무 오래 걸리면
                log("서비스 정상 종료 실패 -> 강제 종료 시도");
                es.shutdownNow();

                // 작업이 취소될 때 가지 대기
                if (!es.awaitTermination(10, TimeUnit.SECONDS)) {
                    log("서비스가 종료되지 않았습니다.");
                }
            }
        } catch (InterruptedException e) {
            // awaitTermination() 으로 대기중인 현재 쓰레드가 인터럽트될 수 있다.
            log("인터럽트 발생 - " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
