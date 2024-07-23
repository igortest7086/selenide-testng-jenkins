package ui_suite.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum HeaderMenuType {
    PRODUCT("Product"),
    SOLUTIONS("Solutions"),
    RESOURCES("Resources"),
    OPEN_SOURCE("Open Source"),
    ENTERPRISE("Enterprise"),
    PRICING("Pricing");

    private final String value;

    @Override
    public String toString() {return value;}
}
