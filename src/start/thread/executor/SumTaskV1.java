package start.thread.executor;

import static start.thread.util.MyLogger.log;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SumTaskV1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<Integer> submit = es.submit(new SumTask(1, 50));
        Future<Integer> submit1 = es.submit(new SumTask(51, 100));

        Integer result1 = submit.get();
        Integer result2 = submit1.get();

        log("result1 = " + result1);
        log("result2 = " + result2);

        log("sum = " + (result1 + result2));
        es.close();
    }

    public static class SumTask implements Callable<Integer> {

        int startValue;
        int endValue;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public Integer call() throws Exception {
            log("작업 시작");
            Thread.sleep(2000);
            int sum = 0;
            for (int i = startValue; i <= endValue; i++) {
                sum += i;
            }
            log("작업 완료");
            return sum;
        }
    }
}
