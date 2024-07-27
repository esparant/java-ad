package start.thread.util;

import static start.thread.util.MyLogger.log;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public abstract class ExecutorUtils {
    public static void printState(ExecutorService executor) {
        if (executor instanceof ThreadPoolExecutor poolExecutor) {
            int poolSize = poolExecutor.getPoolSize();
            int activeCount = poolExecutor.getActiveCount();
            int size = poolExecutor.getQueue().size();
            long completedTaskCount = poolExecutor.getCompletedTaskCount();
            log("[pool = " + poolSize + ", active = " + activeCount + ", queuedTasks = " + size + ", completedTask = "
                    + completedTaskCount + "]");
            return;
        }
        log(executor);
    }

    public static void printState(ExecutorService executor, String taskName) {
        if (executor instanceof ThreadPoolExecutor poolExecutor) {
            int poolSize = poolExecutor.getPoolSize();
            int activeCount = poolExecutor.getActiveCount();
            int size = poolExecutor.getQueue().size();
            long completedTaskCount = poolExecutor.getCompletedTaskCount();
            log(taskName + " -> [pool = " + poolSize + ", active = " + activeCount + ", queuedTasks = " + size + ", completedTask = "
                    + completedTaskCount + "]");
            return;
        }
        log(executor);
    }


}
