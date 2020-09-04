package Enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Languages {
    SUOMI("fi"),
    SVENSKA("sv"),
    ENGLISH("en");

    public String var;

    Languages(String var) {
        this.var = var;
    }

    public static Languages getLanguages(String language) {
        return Arrays.stream(Languages.values()).filter(container -> container.getVar().equalsIgnoreCase(language)).findAny().orElse(null);
    }
}
