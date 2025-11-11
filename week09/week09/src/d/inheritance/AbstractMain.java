package d.inheritance;

abstract class Animal4 {
    String name;

    public Animal4(String name) {
        this.name = name;
    }

    void sleep() {
        System.out.println("잠자기");
    }

    // 추상메서드 - 추상클래스를 상속받는 자식이 무조건 구현해야 함
    abstract void makeSound();
}

abstract class Shape4 {
    String color;

    public Shape4(String color) {
        this.color = color;
    }

    void displayColor() {
        System.out.println(color);
    }

    abstract void getArea();
    abstract void getPerimeter();
}

class Circle4 extends Shape4 {
    double radius;

    public Circle4(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    void getArea() {

    }

    @Override
    void getPerimeter() {

    }
}

public class AbstractMain {

    public static void main(String[] args) {
        // Animal4 a = new Animal4("동물");
    }

}
