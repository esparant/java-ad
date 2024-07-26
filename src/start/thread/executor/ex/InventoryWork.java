package start.thread.executor.ex;

import static start.thread.util.MyLogger.log;
import static start.thread.util.ThreadUtils.sleep;

import java.util.concurrent.Callable;

public class InventoryWork implements Callable<Boolean> {

    private final String orderNo;

    public InventoryWork(String orderNo) {
        this.orderNo = orderNo;
    }

    @Override
    public Boolean call() {

        log("재고 업데이트: " + orderNo);
        sleep(1000);
        return true;
    }
}
