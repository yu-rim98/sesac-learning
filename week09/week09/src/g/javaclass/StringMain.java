package g.javaclass;

import java.util.Arrays;

public class StringMain {

    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "Hello";

        System.out.println(str1 == str2);

        String str3 = "hello";
        System.out.println(str1.equals(str2));

        System.out.println(str1.equals(str3));
        System.out.println(str1.equalsIgnoreCase(str3)); // 대소문자 구분 없이 비교

        // 길이
        System.out.println(str1.length());

        // 특정 위치 문자
        System.out.println(str1.charAt(2));

        // 인덱스 찾기 (없으면 -1 반환)
        System.out.println(str1.indexOf("e"));
        System.out.println(str1.lastIndexOf("l"));

        // 부분 문자열 추출
        System.out.println(str1.substring(2, 4));
        System.out.println(str1); // 원본 문자열을 수정하지 않음

        // 특정 기준으로 문자 추출
        String csv = "apple, banana, orange";
        String[] fruits = csv.split(",");
        System.out.println(Arrays.toString(fruits));

        // 문자열 연결
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        sb.append(2);
        sb.append(3);
        System.out.println(sb);
    }
}
