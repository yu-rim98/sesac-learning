package e.generic;

class Box {
    private Object item;

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }
}

class StringBox {
    private String item;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

}

public class WithoutGeneric {

    public static void main(String[] args) {
        Box box = new Box();

        box.setItem("hello");
        // System.out.println(box.getItem());
        String str = (String) box.getItem();

        box.setItem(123);
        // System.out.println(box.getItem());
        int i = (int) box.getItem();

        StringBox stringBox = new StringBox();
        stringBox.setItem("hello");
        String str2 = stringBox.getItem();


    }
}
