package start.thread.bounded;

import static start.thread.util.MyLogger.log;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedQueueV5 implements BoundedQueue {

    private final Lock lock = new ReentrantLock();
    private final Condition prodCond = lock.newCondition();
    private final Condition conCond = lock.newCondition();

    private final Queue<String> queue = new ArrayDeque<>();

    private final int max;


    public BoundedQueueV5(int max) {
        this.max = max;
    }


    @Override
    public void put(String data) throws InterruptedException {

        lock.lock();
        try {
            while (queue.size() == max) {
                log("[put] queue is full. 생산자 대기");
                prodCond.await();
            }
            queue.offer(data);
            conCond.signal();
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
                conCond.await();
            }
            return queue.poll();
        } finally {
            prodCond.signal();
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
