package d.inheritance;

class Animal3 {

    void makeSound() {
        System.out.println("소리냄");
    }
}

class Dog3 extends Animal3 {
    @Override
    void makeSound() {
        System.out.println("멍멍");
    }
}

class Cat3 extends Animal3 {
    @Override
    void makeSound() {
        System.out.println("야옹");
    }
}

class Bird3 extends Animal3 {
    @Override
    void makeSound() {
        System.out.println("짹짹");
    }
}

public class PolyMain {

    public static void main(String[] args) {
        Dog3 d = new Dog3();
        Cat3 c = new Cat3();
        Bird3 b = new Bird3();

        d.makeSound();
        c.makeSound();
        b.makeSound();
    }
}
