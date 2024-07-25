package start.thread.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SyncListMain {
    public static void main(String[] args) {
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list.getClass());
        System.out.println("list = " + list);
    }
}
