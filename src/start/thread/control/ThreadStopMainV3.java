package start.thread.control;

import static start.thread.util.MyLogger.log;
import static start.thread.util.ThreadUtils.sleep;

public class ThreadStopMainV3 {
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread t1 = new Thread(task, "t1");
        t1.start();

        sleep(5000);
        log("작업 중단 지시 Thread.interrupt");
        t1.interrupt();
        log("스레드 인터럽트 상태1 = " + t1.isInterrupted());


    }

    static class MyTask implements Runnable {

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                log("작업 중");
            }
            log("스레드 인터셉트 상태2 = " + Thread.currentThread().isInterrupted());

            try {
                log("자원 정리");
                Thread.sleep(1000);
                log("자원 종료");
            } catch (InterruptedException e) {
                log("자원 정리 중 인터럽트 발생");
                log("스레드 인터셉트 상태3 = " + Thread.currentThread().isInterrupted());
                // 인터럽트 상태를 false 로 돌리는 이유
            }
            log("작업 종료");

        }
    }
}
