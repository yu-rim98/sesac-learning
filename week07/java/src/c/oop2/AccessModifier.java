package c.oop2;

public class AccessModifier {

    public static void main(String[] args) {

        PrivateClass pc = new PrivateClass(10);
        // pc.value = 20; 외부에서 접근 불가함
        pc.resetValue();
        System.out.println(pc.getValue());

    }

}
