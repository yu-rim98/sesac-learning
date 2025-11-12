package e.generic;
import java.util.*;

public class WildcardGeneric {

    public static void printList(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3);
        List<Double> doubleList = Arrays.asList(1.2, 2.2, 3.2);
        List<String> stringList = Arrays.asList("A", "B", "C");

        printList(intList);
        printList(doubleList);
        printList(stringList);

        intList.add(4);
        intList.add(5);

        List<? extends Number> list = intList;
        list.get(0);
        // list.add(1);

        List<Number> numberList = new ArrayList<>();

        List<? super Integer> list2 = numberList;
        list2.add(5);
        list2.get(0);
    }
}
