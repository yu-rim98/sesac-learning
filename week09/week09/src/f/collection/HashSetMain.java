package f.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HashSetMain {

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");

        System.out.println(set);

        set.add("Apple"); // 중복 불가함
        System.out.println(set);

        // contains() 포함 여부 확인
        System.out.println(set.contains("Banana"));
        System.out.println(set.contains("Melon"));

        set.remove("Apple");

        System.out.println(set.size());
        System.out.println(set.isEmpty());

        // 비우기
//        set.clear();
//        System.out.println(set.isEmpty());

        for (String item : set) {
            System.out.println(item);
        }

        Set<Integer> intSet1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> intSet2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));

        // 합집합 (Union)
        intSet1.addAll(intSet2);
        System.out.println(intSet1);

        // 교집합 (Intersection)
        intSet1.retainAll(intSet2);
        System.out.println(intSet1);

        // 차집합 (Difference)
        intSet1.removeAll(intSet2);
        System.out.println(intSet1);

        // 부분집합 확인
        boolean result = intSet1.containsAll(intSet2);
        System.out.println(result);

    }
}
