package f.collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ArrayListMain {

    public static void main(String[] args) {
        ArrayList<String> l = new ArrayList<>();
        l.add("apple");
        l.add("orange");
        System.out.println(l);

        l.add(1, "cherry");
        System.out.println(l);

        String f = l.get(0);
        System.out.println(f);

        l.set(2, "grape");
        System.out.println(l);

        l.remove(0);
        System.out.println(l);

        System.out.println(l.size());
        System.out.println(l.isEmpty());

        System.out.println(l.contains("cherry"));

        ArrayList<Integer> intList = new ArrayList<>();
        intList.addAll(Arrays.asList(5, 2, 9, 3, 10));

        System.out.println(intList);

        int index = intList.indexOf(9);
        System.out.println(index);

//        intList.clear();
//        System.out.println(intList);

        System.out.println("for-each");
        for (Integer num : intList) {
            System.out.print(num);
        }

        System.out.println("\nindex for");
        for (int i = 0; i < intList.size(); i++) {
            System.out.print(intList.get(i));
        }

        // 잘 안 씀
        System.out.println("\niterator");
        Iterator<Integer> iterator = intList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
        }


    }

}
