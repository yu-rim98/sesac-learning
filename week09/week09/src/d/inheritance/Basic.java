package d.inheritance;

class Dog {
    private String name;
    private int age;

    public void eat() {
        System.out.println("먹기");
    }

    public void bark() {
        System.out.println("짖기");
    }
}

class Cat {
    private String name;
    private int age;

    public void eat() {
        System.out.println("먹기");
    }

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
