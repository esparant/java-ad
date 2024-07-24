package start.thread.cas;

import static start.thread.util.MyLogger.log;
import static start.thread.util.ThreadUtils.sleep;

public class SpinLockBad {

    private volatile boolean lock;

    public void lock() {
        log("lock 획득 시도");
        while (true) {
            if (!lock) { // 1. 락 사용 여부 확인
                sleep(100); // 문제 발생용 sleep
                lock = true;
                break;
            }
            log("lock 획득 실패 - 스핀 대기 ");
        }
        log("lock 획득 완료");
    }

    public void unlock() {
        lock = false;
        log("lock 반납");
    }
}
