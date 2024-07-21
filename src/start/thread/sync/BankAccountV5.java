package start.thread.sync;

import static start.thread.util.MyLogger.log;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccountV5 implements BankAccount {

    private int balance;

    private final Lock lock = new ReentrantLock();

    public BankAccountV5(int initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public boolean withdraw(int amount) {
        log("거래 시작: " + getClass().getSimpleName());

        if (!lock.tryLock()) {
            log("[진입 실패] 이미 처리 중인 작업이 있습니다.");
            return false;
        }

        try {
            log("[검증 시작] 출금액: " + amount + ", 잔고: " + balance);
            if (balance < amount) {
                // 잔고가 출금액 보다 적으면 거절
                log("[검증 실패] 잔고가 부족합니다. 출금액: " + amount + ", 잔고: " + balance);
                return false;
            }

            // 잔고가 출금액 보다 많으면 승인
            balance -= amount;
            log("[검증 성공] 출금이 완료되었습니다. 출금 후 잔고: " + balance + ", 출금액: " + amount);
            log("거래 종료");

            return true;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }
}
