package g.javaclass;

public class WrapperMain {

    public static void main(String[] args) {
        int primitive = 10;
        // 박싱
        Integer wrapper = Integer.valueOf(primitive);
        System.out.println(wrapper);

        Integer wrapper2 = Integer.valueOf(20);
        // 언박싱
        int primitive2 = wrapper2.intValue();
        System.out.println(primitive2);

        // 오토 박싱 / 오토 언박싱
        Integer wrapper3 = 10;
        int primitive3 = wrapper3;

        Integer w = null;
        // 기본형은 null 대입이 불가함
        // int v = w; // NullPointerException
        System.out.println(w);

        // 문자열을 숫자로
        int i = Integer.parseInt("123");
        System.out.println(i);

    }

}
