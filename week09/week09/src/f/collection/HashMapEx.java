package f.collection;

import java.util.HashMap;
import java.util.Map;

public class HashMapEx {

    public static void main(String[] args) {
        Map<String, Integer> userAges = new HashMap<>();

        userAges.put("유관순", 20);
        userAges.put("홍길동", 30);
        userAges.put("이순신", 34);

        int hongAge = userAges.get("홍길동");
        System.out.println(hongAge);
    }

}
