package d.inheritance;

class Parent {
    void show() {
        System.out.println("부모 클래스");
    }
}

class Child extends Parent {

    @Override
    void show() {
        System.out.println("자식 클래스");
    }
}


public class OverridingMain {

    public static void main(String[] args) {

        Child child = new Child();
        child.show();
    }
}
