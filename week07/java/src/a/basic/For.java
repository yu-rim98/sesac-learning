package a.basic;

public class For {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }


        for (int i = 10; i >= 1; i--) {
            System.out.println(i);
        }


        // 구구단 2단
        int dan = 2;

        for (int i = 1; i <= 9; i++) {
            System.out.println(dan + " * " + i + " = " + (dan * i ));
        }

        System.out.println("==============");

        // 구구단 2단부터 9단까지
        for (int i = 2; i <= 9; i++) {
            System.out.println("=====" + i + "단 =====");
            for (int j = 1; j <= 9; j++) {
                System.out.println(i + " * " + j + " = " + (i * j));
            }
        }

        // 배열
        int[] numbers = {10, 11, 12, 13, 14};

        // 향상된 for 문
        for (int n : numbers) {
            System.out.println(n);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            if (i == 5) { // i가 5가되면 중단
                break;
            }
        }

    }

}
