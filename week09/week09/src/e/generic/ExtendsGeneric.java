package e.generic;

class NumberBox<T extends Number> { // Number 아래 타입만 받도록 지정
    private T value;

    public NumberBox(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public double getDoubleValue() {
        return (double) value;
    }
}

public class ExtendsGeneric {

    public static void main(String[] args) {
        NumberBox<Integer> numberBox1 = new NumberBox<>(10);
        int i = numberBox1.getValue();
        double d1 = numberBox1.getDoubleValue();

        NumberBox<Double> numberBox2 = new NumberBox<>(3.14);
        double d = numberBox2.getValue();

        // NumberBox<String> stringBox = new NumberBox<String>("Hi");
    }
}
