package i.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(list);

        int sum = 0;

        for (Integer item : list) {
            if (item % 2 == 0) {
                System.out.println(item * item);
                sum += item * item;
            }
        }

        System.out.println(sum);

        // 람다식
        int sum2 = list.stream()
            .filter(n -> n % 2 == 0)
            .map(n -> n * n)
            .reduce(0, Integer::sum);
        System.out.println(sum2);

        List<Integer> numbers = Arrays.asList(5, 4, 1, 7, 5, 3, 2, 9);

        // filter : true or false 값이 나오는 로직을 작성해야 함
        List<Integer> evens = numbers.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());

        System.out.println(evens);

        List<Integer> greaterThan5 = numbers.stream()
            .filter(n -> n > 5)
            .collect(Collectors.toList());
        System.out.println(greaterThan5);

        List<String> words = Arrays.asList("Apple", "Banana", "Cherry");
        List<String> longWords = words.stream()
            .filter(s -> s.length() > 5)
            .collect(Collectors.toList());

        System.out.println(longWords);


        List<Integer> squares = numbers.stream()
            .map(n -> n * n)
            .collect(Collectors.toList());

        System.out.println(squares);

        List<String> upper = words.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());

        System.out.println(upper);

        // 정렬
        List<Integer> sorted = numbers.stream()
            .sorted()
            .collect(Collectors.toList());

        System.out.println(sorted);
    }

}
