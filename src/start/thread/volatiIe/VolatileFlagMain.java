package start.thread.volatiIe;

import static start.thread.util.MyLogger.log;
import static start.thread.util.ThreadUtils.sleep;

public class VolatileFlagMain {
    public static void main(String[] args) {

        MyTask task = new MyTask();
        Thread thread = new Thread(task, "mt1");
        thread.start();
        log("flag = " + task.flag);

        sleep(1000);
        log("flag 를 false 로 변경시도");
        task.flag = false;
        log("flag = " + task.flag);
    }

    static class MyTask implements Runnable {

//        boolean flag = true;
        volatile boolean flag = true;

        @Override
        public void run() {
            log("task 시작");
            while (flag) {
                // runFlag 가 false 로 변하면 탈출
            }
            log("task 종료");
        }
    }
}
