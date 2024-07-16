package start.thread.control;

import static start.thread.util.MyLogger.log;

public class ThreadInfoMain {
    public static void main(String[] args) {

        Thread mainThread = Thread.currentThread();
        log(mainThread);
        log(mainThread.threadId());
        log(mainThread.getName());
        log(mainThread.getPriority());
        log(mainThread.getThreadGroup());
        log(mainThread.getState());

        System.out.println();
        Thread hello = new Thread(() -> log(Thread.currentThread().getName()), "hello");
        log(hello);
        log(hello.threadId());
        log(hello.getName());
        log(hello.getPriority());
        log(hello.getThreadGroup());
        log(hello.getState());

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@2222 hello.start()");
        hello.start();
        log(hello.getState());
        log(hello.getState());
        log(hello.getState());




    }
}
