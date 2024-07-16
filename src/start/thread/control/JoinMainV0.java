package start.thread.control;

import static start.thread.util.MyLogger.log;
import static start.thread.util.ThreadUtils.sleep;

public class JoinMainV0 {
    public static void main(String[] args) {

        log("start");

        new Thread(JoinMainV0::hey, "Thread-1").start();
        new Thread(JoinMainV0::hey, "Thread-2").start();

        log("end");
    }

    private static void hey() {
        log("작업시작");
        sleep(2000);
        log("작업완료");
    }
}
