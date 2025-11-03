package a.basic;

public class IfStatement {

    public static void main(String[] args) {

        // 기본 if문
        int age = 20;

        if (age >= 20) {
            System.out.println("성인입니다.");
        }

        // if-else
        int score = 90;

        if (score >= 90) {
            System.out.println("A");
        } else {
            System.out.println("재수강");
        }

        // if-else
        int score2 = 70;

        if (score2 >= 90) {
            System.out.println("A");
        } else if (score2 >= 80) {
            System.out.println("B");
        } else if (score2 >= 70) {
            System.out.println("C");
        } else {
            System.out.println("재수강");
        }

        int month = 4;
        String season = switch (month) {
            case 3, 4, 5 -> "봄";
            case 6, 7, 8 -> "여름";
            case  9, 10, 11 -> "가을";
            case  12, 1, 2 -> "겨울";
            default -> "잘못된 월";
        };

        System.out.println(season);

    }

}
