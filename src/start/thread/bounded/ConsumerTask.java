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
        String data = queue.take();
        log("[소비 완료]     " + data + " <- " + "[]");
    }
}
