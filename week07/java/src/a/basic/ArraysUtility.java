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
    }
}
