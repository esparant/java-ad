package start.thread.control;

import static start.thread.util.MyLogger.log;
import static start.thread.util.ThreadUtils.sleep;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MyPrinterV3 {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        Printer printer = new Printer();
        Thread pirnterThread = new Thread(printer, "printer");
        pirnterThread.start();

        sleep(500);

        while (true) {
            log("프린터할 문서를 입력하세요. 종료(q): ");
            String input = scanner.nextLine();
            if (input.equals("q")){
                pirnterThread.interrupt();
                break;
            }
            printer.printQueue.add(input);
        }

    }



    static class Printer implements Runnable {

        Queue<String> printQueue = new ConcurrentLinkedQueue<>();

        @Override
        public void run() {
            log("프린터 시작");
            while (!Thread.interrupted()) {
                if (printQueue.isEmpty()) {
                    Thread.yield();
                    continue;
                }
                String print = printQueue.poll();
                log("출력 시작: " + print + ", 대기 문서: " + printQueue);
                try {
                    Thread.sleep(1500);
                    log("출력 완료");
                } catch (InterruptedException e) {
                    log("인터럽트");
                    break;
                }
            }
            log("프린터 종료");
        }
    }
}
