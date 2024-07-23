package start.thread.bounded;

import static start.thread.util.MyLogger.log;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BoundedQueueV6_2 implements BoundedQueue {

    private final BlockingQueue<String> queue;


    public BoundedQueueV6_2(int max) {
        queue = new ArrayBlockingQueue<>(max);
    }


    @Override
    public void put(String data) throws InterruptedException {
        boolean result = queue.offer(data);
        log("저장 시도 결과 = " + result);
    }

    @Override
    public String take() throws InterruptedException {
        return queue.poll();
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
