package start.thread.sync;

import static start.thread.util.MyLogger.log;
import static start.thread.util.ThreadUtils.sleep;

public class BankAccountV2 implements BankAccount {

    private int balance;

    public BankAccountV2(int initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public synchronized boolean withdraw(int amount) {
        log("거래 시작: " + getClass().getSimpleName());

        log("[검증 시작] 출금액: " + amount + ", 잔고: " + balance);

        // 잔고가 출금액 보다 적으면 거절
        if (balance < amount) {
            log("[검증 실패] 잔고가 부족합니다. 출금액: " + amount + ", 잔고: " + balance);
            return false;
        }

        // 잔고가 출금액 보다 많으면 승인
        balance -= amount;
        log("[검증 성공] 출금이 완료되었습니다. 출금 후 잔고: " + balance + ", 출금액: " + amount);

        log("거래 종료");
        return false;
    }

    @Override
    public synchronized int getBalance() {
        return balance;
    }
}
