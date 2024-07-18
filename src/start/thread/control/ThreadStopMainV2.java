package start.thread.control;

import static start.thread.util.MyLogger.log;
import static start.thread.util.ThreadUtils.sleep;

public class ThreadStopMainV2 {
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
            try {
                while (true) {
                    log("작업 중");
                    Thread.sleep(1500);
            }
            } catch (InterruptedException e) {
                log("스레드 인터셉트 상태2 = " + Thread.currentThread().isInterrupted());
                log("interrupt message = " + e.getMessage());
                log("state = " + Thread.currentThread().getState());
            }
            log("자원 정리");
            log("자원 종료");
        }
    }
}
