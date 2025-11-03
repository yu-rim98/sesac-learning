package a.basic.practice;

public class Practice2 {

    public static void main(String[] args) {
//      문제 2: 학점 계산
//      점수를 입력받아 학점을 출력하세요.

        int score = 85;

        if (score >= 90) {
            System.out.println("학점: A");
        } else if (score >= 80) {
            System.out.println("학점: B");
        } else if (score >= 70) {
            System.out.println("학점: C");
        } else if (score >= 60) {
            System.out.println("학점: D");
        } else {
            System.out.println("학점: F");
        }

    }
}
