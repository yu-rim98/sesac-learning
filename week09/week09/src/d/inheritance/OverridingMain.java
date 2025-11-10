package d.inheritance;

class Parent {
    void show() {
        System.out.println("부모 클래스");
    }

    final void display() {
        System.out.println("표시");
    }
}

class Child extends Parent {

    @Override
    void show() {
        System.out.println("자식 클래스");
    }

    @Override
    void display() {
        System.out.println("자식이 표시");
    }
}


public class OverridingMain {

    public static void main(String[] args) {

        Child child = new Child();
        child.show();
    }
}
