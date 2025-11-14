package f.collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetEx {

    public static void main(String[] args) {
        Set<String> uniqueColors = new HashSet<>();

        uniqueColors.add("빨간색");
        uniqueColors.add("파란색");
        uniqueColors.add("초록색");
        uniqueColors.add("빨간색"); // 중복은 무시됨

        System.out.println(uniqueColors); // [파란색, 초록색, 빨간색] 순서 보장 X

    }
}
