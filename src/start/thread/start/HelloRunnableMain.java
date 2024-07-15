package start.thread.start;

public class HelloRunnableMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " is start");

        HelloRunnable runnable = new HelloRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
        // 쓰레드를 사용할 때는 Runnable 인터페이스를 구현하는 방식을 사용하자
        // 왜?
        // 자바는 당속 상속이 불가능하기 떄문에 만약 하나의 클래스를 상속받고 있으면 Thread 클래스 상속이 불가능함
        // 유연성 부족
        // Thread 클래스는 안쓰는 기능이 더많음 즉 원하는 작업만 필요로 하기 때문에 별로임


        System.out.println(Thread.currentThread().getName() + " is end");
    }
}
