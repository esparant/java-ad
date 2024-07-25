package start.thread.collection;

import static start.thread.util.MyLogger.log;

public class SimpleListMainV2 {
    public static void main(String[] args) throws InterruptedException {
//        test(new BasicList());
//        test(new SyncList());
        test(new SyncProxyList(new BasicList()));
    }

    private static void test(SimpleList simpleList) throws InterruptedException {
        log(simpleList.getClass().getSimpleName());

        Runnable runnableA = () -> {
            simpleList.add("A");
            log("Thread-1: list.add(\"A\")");
        };

        Runnable runnableB = () -> {
            simpleList.add("B");
            log("Thread-2: list.add(\"B\")");
        };

        Thread threadA = new Thread(runnableA, "Thread-1");
        Thread threadB = new Thread(runnableB, "Thread-2");

        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();

        log(simpleList);
    }
}
