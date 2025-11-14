package f.collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEx {

    public static void main(String[] args) {
        // String을 담을 수 있는 ArrayList
        List<String> fruits = new ArrayList<>();

        fruits.add("사과");
        fruits.add("바나나");
        fruits.add("딸기");
        fruits.add("사과"); // 중복 허용

        System.out.println(fruits);

        // 2번 인덱스 삭제
        // fruits.remove(2);
        fruits.remove("딸기");
        System.out.println(fruits);
    }

}
