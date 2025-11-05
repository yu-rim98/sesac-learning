package a.basic;

import java.util.Arrays;

public class ArraysUtility {

    public static void main(String[] args) {
        // Array 유틸리티 클래스
        int[] numbers = {5, 2, 1, 7, 8};

        System.out.println(Arrays.toString(numbers));

        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));

        // binarySearchs는 배열이 정렬되어 있어야 값을 찾을 수 있음
        int index = Arrays.binarySearch(numbers, 7);
        System.out.println(index);

        int[] filled = new int[10];
        Arrays.fill(filled, 99); // 배열에 값 채우기
        System.out.println(Arrays.toString(filled));

        int[] origin = {1, 2, 3, 4, 5};
        // 복사
        // 첫번째 인자 - 복사 대상, 두번째 인자 - 갯수
        int[] copied = Arrays.copyOf(origin, origin.length);

        System.out.println(Arrays.toString(copied));

        int[] copied2 = origin;
        System.out.println(Arrays.toString(copied2));

        System.out.println();
        origin[0] = 100; // 원본 배열 값 변경
        System.out.println(Arrays.toString(origin));
        System.out.println(Arrays.toString(copied));

        // 원본 배열이 가지는 참조값을 그대로 저장하므로 origin 데이터 변경 시 copied2도 같이 변경됨
        System.out.println(Arrays.toString(copied2));

        // 범위 지정 복사
        // 복사 대상에서 어디부터 어디까지 복사 (to는 제외함 즉, to-1)
        int[] ranged = Arrays.copyOfRange(origin, 1, 3);
        System.out.println(Arrays.toString(ranged));

    }
}
