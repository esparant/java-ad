package start.thread.control;

import static start.thread.util.MyLogger.log;
import static start.thread.util.ThreadUtils.sleep;

public class ThreadStopMainV1 {
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread t1 = new Thread(task, "t1");
        t1.start();

        sleep(5000);
        log("작업 중단 지시 runFlag=false");
        task.runFlag = false;

    }

    static class MyTask implements Runnable {

        volatile boolean runFlag = true;

        @Override
        public void run() {
            while (runFlag) {
                log("작업 중");
                sleep(1500);
            }
            log("자원 정리");
            log("자원 종료");
        }
    }
}
