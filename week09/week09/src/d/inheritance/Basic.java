package d.inheritance;

class Animal {
    // 공통으로 가져야 하는 필드와 메서드를 정의
    private String name;
    private int age;

    public void eat() {
        System.out.println("먹기");
    }
}

class Dog extends Animal {
    private String breed;

    public void bark() {
        System.out.println("짖기");
    }
}

class Cat extends Animal{
    private int life;

    public void meow() {
        System.out.println("울기");
    }
}


public class Basic {

    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();

        dog.eat();
        dog.bark();

        cat.eat();
        cat.meow();
    }
}
