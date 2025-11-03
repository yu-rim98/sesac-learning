package a.basic.practice;

public class Practice4 {

    public static void main(String[] args) {
//      문제 4: 삼각형 유효성 검사
//      세 변의 길이를 입력받아 삼각형을 만들 수 있는지 검사하세요.

        int a = 3, b = 4, c = 5;

        if (a > 0 && b > 0 && c > 0) {
            int max = Math.max(a, Math.max(b, c));
            int sum = a + b + c;

            if (max < sum - max) {
                System.out.println("삼각형을 만들 수 있습니다.");
            } else {
                System.out.println("삼각형을 만들 수 없습니다.");
            }
        } else {
            System.out.println("변의 길이는 모두 양수여야 합니다.");
        }

    }

}
