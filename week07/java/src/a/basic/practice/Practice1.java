package a.basic.practice;

public class Practice1 {

    public static void main(String[] args) {
//      문제 1: 홀짝 판별
//      정수를 입력받아 홀수인지 짝수인지 판별하세요.

        int num = 17;

        if (num % 2 == 0) {
            System.out.println(num + "은 짝수입니다.");
        } else {
            System.out.println(num + "은 홀수입니다.");

        }
    }
}
