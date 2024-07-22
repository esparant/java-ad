package start.thread.bounded;

import static start.thread.util.MyLogger.log;

public class ConsumerTask implements Runnable {

    private final BoundedQueue queue;

    public ConsumerTask(BoundedQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        log("[소비 시도]     ? <- " + queue);
        try {
            log("[소비 완료]     " + queue.take() + " <- " + queue);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
