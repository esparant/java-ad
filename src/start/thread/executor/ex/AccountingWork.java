package start.thread.executor.ex;

import static start.thread.util.MyLogger.log;
import static start.thread.util.ThreadUtils.sleep;

import java.util.concurrent.Callable;

public class AccountingWork implements Callable<Boolean> {

    private final String orderNo;

    public AccountingWork(String orderNo) {
        this.orderNo = orderNo;
    }

    @Override
    public Boolean call() {
        log("회계 시스템 업데이트: " + orderNo);
        sleep(1000);
        return true;
    }
}
