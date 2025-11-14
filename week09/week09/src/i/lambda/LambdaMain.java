package i.lambda;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

// FunctionalInterface 어노테이션을 달아주면 메서드가 하나 이상일 때 에러를 보여줌
@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}


public class LambdaMain {

    public static void main(String[] args) {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return Integer.compare(a, b);
            }
        };

        // 알아서 클래스로 만들어줌
        // 즉, 클래스를 인스턴스화 하고 메서드로 만들어줌
        Comparator<Integer> comparator2 = (a, b) -> Integer.compare(a, b);
        
        // 매개변수가 없는 형태
        Runnable task = () -> System.out.println("실행");
        task.run();

        // 매개변수 하나
        Consumer<String> print = (s) -> System.out.println(s);
        print.accept("하이");

        // 매개변수 2개
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        int result = add.apply(2, 2);
        System.out.println(result);

        BiFunction<Integer, Integer, Integer> calc = (a, b) -> {
            int sum = 1 + b;
            return sum / 2;
        };

        System.out.println(calc.apply(5, 10));


        // 그럼 람다는 인터페이스에만 사용할 수 있나 ?
        // 람다는 하나의 메서드만 가지는 인터페이스에만 사용할 수 있음
        Calculator cal = (a, b) -> a + b;
        int result2 = cal.calculate(5, 5);
        System.out.println(result2);

        Calculator cal2 = (a, b) -> a * b;
        System.out.println(cal2.calculate(10, 10));

        // 매개변수 없고 값은 반환
        Supplier<String> s = () -> "hello";
        System.out.println(s.get());

        // 매개변수를 받아서 소비
        Consumer<String> c = (str) -> System.out.println(str);
        c.accept("인자");

        // 매개변수를 받아서 값 반환
        Function<String, Integer> f = (str) -> str.length();
        System.out.println(f.apply("안녕하세요"));
    }
}
