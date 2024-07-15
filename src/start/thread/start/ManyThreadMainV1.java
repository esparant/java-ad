package start.thread.start;

import static start.thread.logger.MyLogger.log;

public class ManyThreadMainV1 {
    public static void main(String[] args) {
        log("main start");
        Thread thread0 = new Thread(() -> log(Thread.currentThread().getName() + " start"));
        thread0.start();
        Thread thread1 = new Thread(() -> log(Thread.currentThread().getName() + " start"));
        thread1.start();
        Thread thread2 = new Thread(() -> log(Thread.currentThread().getName() + " start"));
        thread2.start();
        Thread thread3 = new Thread(() -> log(Thread.currentThread().getName() + " start"));
        thread3.start();
        log("main end");



    }
}
