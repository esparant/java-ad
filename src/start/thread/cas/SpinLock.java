package start.thread.cas;

import static start.thread.util.MyLogger.log;
import static start.thread.util.ThreadUtils.sleep;

import java.util.concurrent.atomic.AtomicBoolean;

public class SpinLock {

    private final AtomicBoolean lock = new AtomicBoolean();

    public void lock() {
        log("lock 획득 시도");

        while (!lock.compareAndSet(false, true)) {
            log("lock 획득 실패 - 스핀 대기");
        }
        log("lock 획득 완료");
    }

    public void unlock() {
        lock.set(false);
        log("lock 반납");
    }
}
