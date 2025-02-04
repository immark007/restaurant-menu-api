package com.mark.restaurant.menu.api.enums;

public enum Type {
    BEBIDA("bebida"),
    PF("pf"),
    SOBREMESA("sobremesa");

    private String value;
    Type(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
