package start.thread.sync;

import static start.thread.util.MyLogger.log;
import static start.thread.util.ThreadUtils.sleep;

import java.util.concurrent.locks.LockSupport;

public class LockSupportMainV2 {
    public static void main(String[] args) {

        Thread thread1 = new Thread(new ParkTest(), "thread-1");
        thread1.start();

        // 잠시 대기하여 Thread-1 이 park 상태에 빠질 시간을 준다
        sleep(100);
        log("Thread-1 state: " + thread1.getState());

    }

    public static class ParkTest implements Runnable {
        @Override
        public void run() {
            log("park 시작");
            LockSupport.parkNanos(2000_000000); // 2초뒤 unPark
            log("park 종료, state: " + Thread.currentThread().getState());
            log("인트럽트 상태: " + Thread.currentThread().isInterrupted());
        }
    }
}
