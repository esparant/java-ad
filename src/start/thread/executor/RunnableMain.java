package start.thread.executor;

import static start.thread.util.MyLogger.log;
import static start.thread.util.ThreadUtils.sleep;

import java.util.Random;

public class RunnableMain {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable task = new MyRunnable();
        Thread thread = new Thread(task, "T-1");
        thread.start();

        thread.join();

        System.out.println("result = " + task.value);

    }

    static class MyRunnable implements Runnable {

        int value;

        @Override
        public void run() {
            log("Runnable 시작");
            sleep(2000);
            value = new Random().nextInt(100);
            log("created value = " + value);
            log("Runnable 종료");
        }
    }
}
