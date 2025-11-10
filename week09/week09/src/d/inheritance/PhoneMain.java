package d.inheritance;

class Phone {
    String brand;
    String model;
    int batteryLevel;

    public void powerOn() {
        System.out.println(model + "의 전원을 켭니다.");
    }

    public void charge() {
        batteryLevel = 100;
        System.out.println("충전 완료");
    }
}

class IPhone extends Phone {

    String ios;

    void useFaceID() {
        System.out.println("faceID 사용");
    }

}

class Galaxy extends Phone {

    String android;

    void useSPen() {
        System.out.println("SPen 사용");
    }
}

public class PhoneMain {

    public static void main(String[] args) {
        IPhone iPhone = new IPhone();
        Galaxy galaxy = new Galaxy();

        iPhone.brand = "apple";
        iPhone.model = "16 pro";
        iPhone.ios = "26.1";
        iPhone.powerOn();
        iPhone.charge();
        iPhone.useFaceID();

        galaxy.brand = "samsung";
        galaxy.model = "S25";
        galaxy.android = "25";
        galaxy.powerOn();
        galaxy.charge();
        galaxy.useSPen();
    }
}
