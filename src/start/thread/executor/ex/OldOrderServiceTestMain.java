package start.thread.executor.ex;

import java.util.concurrent.ExecutionException;

public class OldOrderServiceTestMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String orderNo = "Order#1234";
        OldOrderService oldOrderService = new OldOrderService();
        oldOrderService.order(orderNo);
    }
}
