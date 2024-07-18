package start.thread.volatiIe;

import static start.thread.util.MyLogger.log;

public class VolatileCountMain {
    public static void main(String[] args) throws InterruptedException {

        MyTask task = new MyTask();
        Thread thread = new Thread(task, "task");
        thread.start();

        Thread.sleep(5000);
        log("flag is false!!!!!!!!!!!!!!!!!!!!");
        task.flag = false;
        log("flag = " + task.flag + ", count = " + task.count);
    }

    static class MyTask implements Runnable {

        boolean flag = true;
        long count = 0;
//        volatile boolean flag = true;
//        volatile long count = 0;


        @Override
        public void run() {
            while (flag) {
                count++;

                // 1억번에 한번씩만 출력
                if (count % 100_000_000 == 0) {
                    log("flag = " + flag + " , count = " + count + " in while");
                }
            }
            log("flag = " + flag + " , count = " + count + " end");
        }
    }
}
