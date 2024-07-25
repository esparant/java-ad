package start.thread.executor;

import static start.thread.util.MyLogger.log;
import static start.thread.util.ThreadUtils.sleep;

public class ExecutorTask implements Runnable {

    private final String name;
    private int sleepMs = 1000;

    public ExecutorTask(String name) {
        this.name = name;
    }

    public ExecutorTask(String name, int sleepMs) {
        this.name = name;
        this.sleepMs = sleepMs;
    }

    @Override
    public void run() {
        log(name + " 시작");
        sleep(sleepMs);
        log(name + " 완료");
    }
}
