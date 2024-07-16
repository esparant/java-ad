package start.thread.control;

import static start.thread.util.MyLogger.log;
import static start.thread.util.ThreadUtils.*;

public class ThreadStateMain {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            log("this is " + Thread.currentThread().getName() + " Thread");
            log(Thread.currentThread().getState());
            sleep(1000);
        }, "hello");

        log("helloThread's State: " + thread.getState());
        thread.start();
        Thread.sleep(1000);
        log("helloThread's State: " + thread.getState());
        Thread.sleep(5000);
        log("helloThread's State: " + thread.getState());


    }
}
