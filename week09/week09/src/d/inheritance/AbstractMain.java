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

public class AbstractMain {

    public static void main(String[] args) {
        // Animal4 a = new Animal4("동물");
    }

}
