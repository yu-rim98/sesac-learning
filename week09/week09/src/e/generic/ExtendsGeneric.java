package e.generic;

class NumberBox<T extends Number> { // Number 아래 타입만 받도록 지정
    private T value;

    public NumberBox(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

}

public class ExtendsGeneric {

    public static void main(String[] args) {
        NumberBox<Integer> numberBox1 = new NumberBox<>(10);
        int i = numberBox1.getValue();

        NumberBox<Double> numberBox2 = new NumberBox<>(3.14);
        double d = numberBox2.getValue();

    }
}
