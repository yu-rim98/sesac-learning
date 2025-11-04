package a.basic;

public class Array {

    public static void main(String[] args) {
        // 배열 선언, 크기 지정
        int[] numbers = new int[5];

        // 값 할당
        numbers[0] = 100;
        numbers[1] = 100;

        System.out.println(numbers.length);
        System.out.println(numbers[0]);
        System.out.println(numbers[4]);
        
        // 배열 초기화
        // 선언 후 각 인덱스에 값 할당
        int[] arr1 = new int[5];
        arr1[0] = 1;
        arr1[1] = 2;
        arr1[2] = 3;

        // 선언과 동시에 초기화
        int[] arr2 = new int[] {1, 2, 3, 4, 5}; // 데이터 갯수만큼

        // new 생략 방식
        int[] arr3 = {1, 2, 3, 4, 5};

        // 문자열 배열
        String[] names = {"kim", "lee", "park"};
        System.out.println(names.length);


        int[] scores ={88, 40, 80, 90, 100};

        // 인덱스 접근
        for (int i = 0; i < scores.length; i++) {
            System.out.println(scores[i]);
        }

        // 요소 반복
        for (int score : scores) {
            System.out.println(score);
        }


//        int[][] matrix = new int[5][5];
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
        };


        for (int i = 0; i < matrix.length; i++) {
//            System.out.println(i);
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println(matrix[i][j]);
            }
        }

        int[][] jagged = {
            {1},
            {2, 3},
            {4, 5, 6},
            {7, 8, 9, 10}
        };

        for (int[] row : jagged) {
            for (int item : row) {
                System.out.println(item);
            }
        }
    }

}
