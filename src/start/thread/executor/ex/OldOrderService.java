package start.thread.executor.ex;

import static start.thread.util.MyLogger.log;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class OldOrderService {

    ExecutorService executor = Executors.newFixedThreadPool(10);

    public void order(String orderNo) throws ExecutionException, InterruptedException {
        InventoryWork inventoryWork = new InventoryWork(orderNo);
        ShippingWork shippingWork = new ShippingWork(orderNo);
        AccountingWork accountingWork = new AccountingWork(orderNo);

        Future<Boolean> submit = executor.submit(inventoryWork);
        Future<Boolean> submit1 = executor.submit(shippingWork);
        Future<Boolean> submit2 = executor.submit(accountingWork);

        Boolean a = submit.get();
        Boolean b = submit1.get();
        Boolean c = submit2.get();


        if (a && b && c) {
            log("모든 주문 처리가 성공적으로 완료되었습니다.");
            return;
        }
        log("일부 작업이 실패했습니다.");
    }
}
