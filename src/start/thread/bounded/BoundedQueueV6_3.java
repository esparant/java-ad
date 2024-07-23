package start.thread.bounded;

import static start.thread.util.MyLogger.log;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BoundedQueueV6_3 implements BoundedQueue {

    private final BlockingQueue<String> queue;


    public BoundedQueueV6_3(int max) {
        queue = new ArrayBlockingQueue<>(max);
    }


    @Override
    public void put(String data) throws InterruptedException {
        boolean result = queue.offer(data, 100, TimeUnit.MILLISECONDS);
        log("저장 시도 결과 = " + result);
    }

    @Override
    public String take() throws InterruptedException {
        return queue.poll(100, TimeUnit.MILLISECONDS);
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
