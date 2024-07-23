package start.thread.bounded;

import static start.thread.util.MyLogger.log;
import static start.thread.util.ThreadUtils.sleep;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedQueueV4 implements BoundedQueue {

    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    private final Queue<String> queue = new ArrayDeque<>();

    private final int max;


    public BoundedQueueV4(int max) {
        this.max = max;
    }


    @Override
    public void put(String data) throws InterruptedException {

        lock.lock();
        try {
            while (queue.size() == max) {
                log("[put] queue is full. 생산자 대기");
                condition.await();
            }
            queue.offer(data);
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String take() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                log("[take] queue is empty. 소비자 대기");
                condition.await();
            }
            return queue.poll();
        } finally {
            condition.signal();
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
