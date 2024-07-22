package start.thread.bounded;

import static start.thread.util.MyLogger.log;
import static start.thread.util.ThreadUtils.sleep;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedQueueV2 implements BoundedQueue {

    private final Queue<String> queue = new ArrayDeque<>();

    private final int max;


    public BoundedQueueV2(int max) {
        this.max = max;
    }


    @Override
    public synchronized void put(String data) {

        while (queue.size() == max) {
            log("[put] queue is full. 생산자 대기");
            sleep(500);
        }
        queue.offer(data);
    }

    @Override
    public synchronized String take() {
        while (queue.isEmpty()) {
            log("[take] queue is empty. 소비자 대기");
            sleep(300);
        }
        return queue.poll();
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
