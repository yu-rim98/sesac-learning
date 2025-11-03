package a.basic;

public class Variable {

    public static void main(String[] args) {
        // 변수 선언
        // 타입 변수명;
        int age;

        // 할당
        // 변수명 = 값;
        age = 20;

        System.out.printf("나이 : %d", age);

        // 변수 초기화
        String name = "kim";
        System.out.printf("이름 : %s", name);

        // 기본형 타입
        // 정수형 byte, short int, long
        byte b = 100;
        short s = 10000;
        int i = 1000000000;
        long l = 10000000000000000L;

        System.out.println();
        System.out.println(b);

        // 실수형 float, double
        float f = 3.14f;
        double d = 3.14;

        // 문자형 (char)
        char c = 'A';
        System.out.println(c);

        // 논리형
        boolean bool = true;
        System.out.println(bool);
    }
}
