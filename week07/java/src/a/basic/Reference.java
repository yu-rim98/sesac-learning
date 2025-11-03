package a.basic;

public class Reference {

    public static void main(String[] args) {
        // 참조형 타입
        // String (문자열 타입)
        String str = "Hello ";
        System.out.println(str);

        String str2 = "world";
        String msg = str + str2;

        System.out.println(msg);

        // null (참조형에만 대입 가능)
        String str3 = null;
    }
}
