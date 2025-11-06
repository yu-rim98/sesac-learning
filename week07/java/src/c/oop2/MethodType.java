package c.oop2;

public class MethodType {

    int instanceField = 10;
    static int staticField = 20;

    void instanceMethod() {
        System.out.println("인스턴스 메서드");
        System.out.println("인스턴스 필드 : " + instanceField);
        System.out.println("스태틱 필드 : " + staticField);
    }

    static void staticMethod() {
        System.out.println("스태틱 메서드");
        // System.out.println("인스턴스 필드 : " + instanceField); 불가
        System.out.println("스태틱 필드 : " + staticField);
    }

    public static void main(String[] args) {
        MethodType mt = new MethodType();
        mt.instanceMethod();
        // mt.staticMethod(); // 권장하지 않음

        MethodType.staticMethod();
    }
}
