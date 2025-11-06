package c.oop2;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        calculator.printResult(calculator.add(1, 2));

        Person p1 = new Person();
        Person p2 = new Person("kim", 20);

        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle(10);
        Rectangle r3 = new Rectangle(20, 30);

        // 가변 인자
        int add = calculator.add(1, 2, 3, 4, 5, 6);
        System.out.println(add);
    }
}

