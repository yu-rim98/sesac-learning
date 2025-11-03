package a.basic;

public class Operator {

    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        System.out.println(a + b);

        int x = 10;
        int y = 3;

        System.out.println(x / y);

        double result = (double) x / y;
        System.out.println(result);

        // 증감 연산자
        System.out.println("x = " + x++); // 후위 (변수 사용 후 계산)
        System.out.println("x = " + x);

        System.out.println("x = " + ++x); // 전위 (계산 후 변수 사용)
        System.out.println("x = " + x);

        // x = x + 5
        x += 5;
        System.out.println("x += 5 => " + x);

        String str = "hello";
        String str2 = "hello";
        String str3 = new String("hello");

        // 문자열 비교
        // == 비교는 값을 비교
        // str, str2는 동일한 참조값을 가짐
        System.out.println("str == str2 => " + (str == str2));

        // str, str3은 다른 참조값을 가짐
        System.out.println("str == str3 => " + (str == str3));

        System.out.println("str.equals(str3) => " + str.equals(str3));


        // 단락 평가
        // 항상 앞 조건을 먼저 연산함
        int myX = 0;
        if (myX != 0  && 10 / x > 1) {
            System.out.println("실행");
        }

        // 삼항 연산자
        int age = 20;
        String adult = (age > 20) ? "성인" : "청소년";
        System.out.println(adult);

        // 비트 연산자
        int intC = 123456;
        System.out.println(intC << 1); // * 2
        System.out.println(intC >> 1); // / 2
    }

}
