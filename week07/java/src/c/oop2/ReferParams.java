package c.oop2;


class Data {
    int value;
}

public class ReferParams {

    void changeValue(Data data) {
        data.value = 99;
        System.out.println(data.value);
    }

    public static void main(String[] args) {
        ReferParams ref = new ReferParams();
        Data data = new Data();
        data.value = 10;
        System.out.println(data.value);
        ref.changeValue(data);
        System.out.println(data.value);
    }

}
