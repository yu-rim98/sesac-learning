package h.exception;

import java.io.*;

public class ErrorException {

    public static void main(String[] args) {
        // recursiveMethod();
//        try {
//            int result = 10 / 0;
//        } catch (ArithmeticException e) {
//            System.out.println("problem");
//        }

        // Unchecked Exception (런타임 예외) - 예외처리 필수 아님
        String str = null;
        // NullPointerException
        // System.out.println(str.length());

        int[] arr ={1, 2, 3};
        // ArrayIndexOutOfBoundsException
        // System.out.println(arr[99]);

        // NumberFormatException
        // int num = Integer.parseInt("asdf");
        int age = 10;
        if (age < 0) {
            // IllegalArgumentException 예외를 던짐
            throw new IllegalArgumentException();
        }


        // Checked Exception(컴파일 예외) - 예외처리 필수
//        try {
//            FileReader fr = new FileReader("a.txt");
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }

        try {
            int result = 1 / 0;
        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다.");
        }

        System.out.println("next");


        FileReader fr = null;
        try {
            fr = new FileReader("data.txt");
            System.out.println("파일을 불러옴");

        } catch (IOException e) {
            System.out.println("존재하지 않는 파일입니다.");
        } finally {
            try {
                // fr.close()에서도 IOException이 발생할 수 있기 때문에 잡아줘야 함
                fr.close();
            } catch (IOException e) {
                System.out.println("fr close 실패");
            }
        }

    }

//    static void recursiveMethod() {
//        recursiveMethod();
//
//    }
}
