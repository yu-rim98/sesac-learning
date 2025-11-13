package f.collection;

import java.util.HashSet;

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


    }
}
