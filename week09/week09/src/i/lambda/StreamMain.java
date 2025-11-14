package i.lambda;

import java.util.Arrays;
import java.util.List;

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
    }

}
