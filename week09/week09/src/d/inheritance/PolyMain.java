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

class Rabbit3 extends Animal3 {
    @Override
    void makeSound() {
        System.out.println("깡충");
    }
}

public class PolyMain {

    public static void main(String[] args) {
//        Dog3 d = new Dog3();
//        Cat3 c = new Cat3();
//        Bird3 b = new Bird3();
//
//        d.makeSound();
//        c.makeSound();
//        b.makeSound();

//        Animal3 a1 = new Dog3();
//        Animal3 a2 = new Cat3();
//        Animal3 a3 = new Bird3();
//        Animal3 a4 = new Rabbit3();

        Animal3[] animals = {
            new Dog3(),
            new Cat3(),
            new Bird3(),
            new Rabbit3()
        };
        
        for (Animal3 animal : animals) {
            soundAnimal(animal);
        }
    }

    static void soundAnimal(Animal3 animal) {
        animal.makeSound();
    }
}
