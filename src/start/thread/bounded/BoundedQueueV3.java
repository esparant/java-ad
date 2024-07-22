package start.thread.bounded;

import static start.thread.util.MyLogger.log;
import static start.thread.util.ThreadUtils.sleep;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

public class BoundedQueueV3 implements BoundedQueue {

    private final Queue<String> queue = new ArrayDeque<>();

    private final int max;


    public BoundedQueueV3(int max) {
        this.max = max;
    }


    @Override
    public synchronized void put(String data) throws InterruptedException {

        while (queue.size() == max) {
            log("[put] queue is full. 생산자 대기");
            wait(); // waiting -> runnable
        }
        queue.offer(data);
        notify(); // waiting -> blocked
    }

    @Override
    public synchronized String take() throws InterruptedException {
        while (queue.isEmpty()) {
            log("[take] queue is empty. 소비자 대기");
            wait();
        }

        try {
            return queue.poll();
        } finally {
            sleep(50);
            notify();
        }

    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
