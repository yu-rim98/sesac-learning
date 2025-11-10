package d.inheritance;

class Animal2 {

    String name;
    int age;
    String bread;

    Animal2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void introduce() {
        System.out.println("hello " + this.name + this.age);
    }
}

class Dog2 extends Animal2 {
    String bread;

    Dog2(String name, int age, String bread) {
        super(name, age);
        this.bread = bread;
    }

    void display() {
        System.out.println(this.bread);
        System.out.println(super.bread);
    }

    void introduce() {
        super.introduce();
        System.out.println("멍멍");
    }
}

public class SuperMain {

    public static void main(String[] args) {
        Animal2 animal2 = new Animal2("동물", 0);
        Dog2 dog2 = new Dog2("초코", 3, "말티즈");

        System.out.println(animal2.bread);
        System.out.println(dog2.bread);

        dog2.display();
        dog2.introduce();
        animal2.introduce();

    }

}
