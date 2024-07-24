package start.thread.cas;

import static start.thread.util.MyLogger.log;
import static start.thread.util.ThreadUtils.sleep;

public class SpinLockMain {
    public static void main(String[] args) {
//        SpinLockBad spinLockBad = new SpinLockBad();
        SpinLock spinLock = new SpinLock();

        Runnable runnable = () -> {
            spinLock.lock();
            try {
                log("비즈니스 로직 실행");
                sleep(10); // runnable 상태의 단점
            } finally {
                spinLock.unlock();
            }
        };

        Thread thread1 = new Thread(runnable, "t-1");
        Thread thread2 = new Thread(runnable, "t-2");

        thread1.start();
        thread2.start();
    }
}
