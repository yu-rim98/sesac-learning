package d.inheritance;

class Animal2 {

    String name;
    int age;

    Animal2(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Dog2 extends Animal2 {
    String bread;

    Dog2(String name, int age, String bread) {
        super(name, age);
        this.bread = bread;
    }

}

public class SuperMain {

    public static void main(String[] args) {
        Animal2 animal2 = new Animal2("동물", 0);
    }

}
