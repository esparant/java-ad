package start.thread.start;

public class HelloThreadMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        System.out.println(Thread.currentThread().getName() + " is run");
        new HelloThread().start(); // 이 시점에 새로운 쓰레드와 스택영역이 생성 됨
        new HelloThread().run();/* run 은 호출하지 마세연*/
        // 그래야지 별도의 쓰레드에서 run 의 메소드가 실행된다.

        // 왜냐하면 그냥 main 이 평범한 run 메소드를 실행하는 꼴이 되어버리기 때문에

        System.out.println(Thread.currentThread().getName() + " is end");
        // 쓰레드는 동시에 실행되기 떄문에 스레드 간의 실행 순서는 얼마든지 달라질 수 있다.


    }
}
