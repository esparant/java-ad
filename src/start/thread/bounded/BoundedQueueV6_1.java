package start.thread.bounded;

import static start.thread.util.MyLogger.log;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedQueueV6_1 implements BoundedQueue {

    private final BlockingQueue<String> queue;


    public BoundedQueueV6_1(int max) {
        queue = new ArrayBlockingQueue<>(max);
    }


    @Override
    public void put(String data) throws InterruptedException {
        queue.put(data);
    }

    @Override
    public String take() throws InterruptedException {
        return queue.take();
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
