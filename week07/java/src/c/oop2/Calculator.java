package c.oop2;

class Sample {
    int value;
}

public class Calculator {

    int add(int a, int b) {
        return a + b;
    }

    void printResult(int result) {
        System.out.println(result);
    }

    String printValue(int score) {
        if (score >= 50) {
            return "pass";
        } else {
            return "fail";
        }
    }

    int[] getArray() {
        return new int[] {1, 2, 3, 4};
    }

    Sample getSample() {
        return new Sample();
    }

}
