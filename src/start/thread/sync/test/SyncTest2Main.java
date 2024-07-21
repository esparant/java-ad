package start.thread.sync.test;

import static start.thread.util.MyLogger.log;

public class SyncTest2Main {
    public static void main(String[] args) {
        MyCounter myCounter = new MyCounter();

        Runnable task = myCounter::count;

        Thread thread1 = new Thread(task, "t1");
        Thread thread2 = new Thread(task, "t2");

        thread1.start();
        thread2.start();

        // 지역변수는 절대로!! 다른 스레드와 공유되지 않는다!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    }


    private static class MyCounter {
        public void count() {
            int localValue = 0;
            for (int i = 0; i < 1000; i++) {
                localValue++;
            }
            log("결과: " + localValue);
        }

    }
}
