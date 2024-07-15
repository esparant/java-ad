package start.thread.start;

public class DemonThreadMain  {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " is run");

        DemonThread demonThread = new DemonThread();
        demonThread.setDaemon(true);
        demonThread.start();
        // 데몬쓰레드는 Non-Daemon 쓰레드가 끝나고 자바 프로그램이 종료되면 얘는 무시되고 종료된다.

        System.out.println(Thread.currentThread().getName() + " is end");
    }

    static class DemonThread extends Thread{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is run");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName() + " is run");
        }
    }
}
