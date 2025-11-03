package a.basic.practice;

public class Practice6 {

    public static void main(String[] args) {
//        문제 6: 요일 판별
//        요일 번호를 입력받아 평일/주말을 구분하세요. 향상된 switch 문을 사용하세요.


        int day = 2;
        String dayStr = switch (day) {
            case 1 -> "월요일";
            case 2 -> "화요일";
            case 3 -> "수요일";
            case 4 -> "목요일";
            case 5 -> "금요일";
            case 6 -> "토요일";
            case 7 -> "일요일";
            default -> "잘못된 번호입니다.";
        };

        if (day >= 1 && day <= 5) {
            System.out.println(day + ": " + dayStr + "은 평일입니다.");
        } else {
            System.out.println(day + ": " + dayStr + "은 주말입니다.");
        }
    }
}
