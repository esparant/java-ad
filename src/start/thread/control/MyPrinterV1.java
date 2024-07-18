package start.thread.control;

import static start.thread.util.MyLogger.log;
import static start.thread.util.ThreadUtils.sleep;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MyPrinterV1 {
    public static void main(String[] args) throws InterruptedException {

        Printer printer = new Printer();
        Thread pirnterThread = new Thread(printer, "printer");
        pirnterThread.start();

        Scanner scanner = new Scanner(System.in);

        sleep(500);
        while (true) {
            log("프린터할 문서를 입력하세요. 종료(q): ");
            String input = scanner.nextLine();
            if (input.equals("q")){
                printer.flag = false;
                break;
            }
            printer.printQueue.add(input);
        }

    }



    static class Printer implements Runnable {

        volatile boolean flag = true;
        Queue<String> printQueue = new ConcurrentLinkedQueue<>();

        @Override
        public void run() {
            log("프린터 시작");
            while (flag) {
                if (printQueue.isEmpty()) {
                    continue;
                }

                String print = printQueue.poll();
                log("출력 시작: " + print + ", 대기 문서: " + printQueue);
                sleep(3000);
                log("출력 완료");
            }
            log("프린터 종료");
        }
    }
}
