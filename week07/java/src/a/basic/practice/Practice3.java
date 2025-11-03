package a.basic.practice;

public class Practice3 {

    public static void main(String[] args) {
//      문제 3: 윤년 판별
//      연도를 입력받아 윤년인지 판별하세요.

        int year = 2024;

        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.println(year + "은 윤년입니다.");
        } else {
            System.out.println(year + "은 윤년이 아닙니다.");
        }
    }
}
