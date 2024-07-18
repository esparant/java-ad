package start.thread.control;

import static start.thread.util.ThreadUtils.sleep;

public class YieldMain {

    private static final int THREAD_COUNT = 100;

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            new Thread(new MyRunnable()).start();
        }
    }


    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i ++) {
                System.out.println(Thread.currentThread().getName()  + " - " + i);
                // 1. empty
//                 sleep(1); // 2.sleep
                 Thread.yield(); // 3. yield
            }
        }
    }
}
