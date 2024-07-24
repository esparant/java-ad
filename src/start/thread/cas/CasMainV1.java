package start.thread.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CasMainV1 {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        System.out.println("start value = " + atomicInteger.get());


        // success
        boolean caseA = atomicInteger.compareAndSet(0, 1);// value == 0 -> set 1
        System.out.println("[success] result = " + caseA + ", end value = " + atomicInteger.get());

        // fail
        boolean caseB = atomicInteger.compareAndSet(2, 3);// value == 2 -> set 3
        System.out.println("[fail] result = " + caseB +  ", end value = " + atomicInteger.get());


    }
}
