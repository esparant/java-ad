package start.thread.executor;

import static start.thread.util.MyLogger.log;
import static start.thread.util.ThreadUtils.sleep;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureCancelMain {

    private static boolean interrupt = false;
//    private static boolean interrupt = true;

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(1);
        Future<String> future = es.submit(new MyTask());

        log("Future.state = " + future.state());

        sleep(3000);

        boolean cancel = future.cancel(interrupt);
        log("cancel = " + cancel);

        try {
            log("future result = " + future.get());
        } catch (CancellationException e) {
            log("CancellationException");
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        es.close();
    }

    static class MyTask implements Callable<String> {

        @Override
        public String call() {
            try {
                for (int i = 0; i < 10; i++) {
                    log("작업중 : " + i);
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                log("interrupt 발생");
                return "interrupted";
            }
            return "completed";
        }
    }
}
