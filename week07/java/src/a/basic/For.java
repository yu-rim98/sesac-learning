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

    }

}
