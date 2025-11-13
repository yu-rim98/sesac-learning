package f.collection;

import java.util.HashMap;

public class HashMapMain {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("Apple", 1000);
        map.put("Banana", 2000);
        map.put("Cherry", 3000);
        System.out.println(map);

        int price = map.get("Apple");
        System.out.println(price);

        // containsKey() - 키 존재 여부
        System.out.println(map.containsKey("Banana"));

        // containsValue() - 값 존재 여부
        System.out.println(map.containsValue(2000));

        // 같은 키로 데이터 넣을 경우 덮어씀
        map.put("Apple", 5000);
        System.out.println(map);

        map.remove("Banana");
        System.out.println(map.size());
        System.out.println(map.isEmpty());

        // map.clear();
        System.out.println(map.isEmpty());


        map.get("Apple");
    }

}
