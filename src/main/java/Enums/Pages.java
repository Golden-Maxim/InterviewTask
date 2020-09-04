package Enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Pages {
    CUSTOMER_SERVICE("Customer Service"),
    REGIONAL_SETTINGS("Regional Settings"),
    CREATE_ACCOUNT("Create Account"),
    LOGIN("Login"),
    ABOUT_US("About Us"),
    DELIVERY_INFORMATION("Delivery Information"),
    PRIVACY_POLICY("Privacy Policy"),
    TERMS_CONDITIONS("Terms & Conditions"),
    RUBBER_DUCKS("Rubber Ducks");

    public String var;

    Pages(String var) {
        this.var = var;
    }

    public static Pages getPagesName(String containerName) {
        return Arrays.stream(Pages.values()).filter(container -> container.getVar().equalsIgnoreCase(containerName)).findAny().orElse(null);

    }
}
