package start.thread.executor;

import static start.thread.util.MyLogger.log;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class InvokeAnyMain {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<CallableTask> list = IntStream.range(0, 10).mapToObj(i -> new CallableTask("Task" + i, 100 * i))
                .toList();

        Integer value = executorService.invokeAny(list);
        log("value = " + value);
        executorService.close();
    }
}
