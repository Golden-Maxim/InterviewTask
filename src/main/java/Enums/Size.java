package Enums;

public enum Size {
    SMALL("Small"),
    MEDIUM("Medium +$2.50"),
    LARGE("Large +$5");

    public  String value;

    Size(String s) {
        value = s;
    }
}
