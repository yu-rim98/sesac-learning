package c.oop2;

public class Util {

    String concat(String... strings) {
        StringBuilder sb = new StringBuilder();

        for (String string : strings) {
            sb.append(string);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Util util = new Util();
        String string = util.concat("안녕하세요. ", "저희 집 강아지는 ", "달구입니다.");
        System.out.println(string);
    }
}
