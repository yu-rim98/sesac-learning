package f.collection;

import java.util.LinkedList;

public class LinkedListMain {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list);

        list.addFirst("s");
        list.addLast("e");
        System.out.println(list);

        System.out.println(list.getFirst());

        list.removeFirst();

        System.out.println(list);

    }

}
