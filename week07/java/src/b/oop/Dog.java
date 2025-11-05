package b.oop;

public class Dog {

    String name;
    int age;
    String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    void bark() {
        System.out.println("왕왕");
    }
}
