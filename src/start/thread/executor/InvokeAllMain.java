package start.thread.executor;

import static start.thread.util.MyLogger.log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InvokeAllMain {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<CallableTask> list = IntStream.range(0, 10).mapToObj(i -> new CallableTask("Task" + i, 100 * i))
                .toList();

        List<Future<Integer>> futures = executorService.invokeAll(list);
        for (Future<Integer> future : futures) {
            Integer value = future.get();
            log("value = " + value);
        }
        executorService.close();
    }
}
