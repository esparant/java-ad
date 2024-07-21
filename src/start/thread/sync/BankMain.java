package start.thread.sync;

import static start.thread.util.MyLogger.log;
import static start.thread.util.ThreadUtils.sleep;

public class BankMain {
    public static void main(String[] args) throws InterruptedException {

//        BankAccountV1 account = new BankAccountV1(100_000);
//        BankAccountV2 account = new BankAccountV2(100_000);
        BankAccountV3 account = new BankAccountV3(100_000);

        Thread btA = new Thread(new WithdrawTask(account, 60000), "bankThread-A");
        Thread btB = new Thread(new WithdrawTask(account, 60000), "bankThread-B");

        btA.start();
        btB.start();

        sleep(500);

        btA.join();
        btB.join();

        log("최종 잔액: " + account.getBalance());

    }
}
