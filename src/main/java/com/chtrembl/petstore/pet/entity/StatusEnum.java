package com.chtrembl.petstore.pet.entity;

import com.chtrembl.petstore.pet.model.Pet;

public enum StatusEnum {
    AVAILABLE("available"),
    PENDING("pending"),
    SOLD("sold");

    private String value;

    StatusEnum(String value) {
        this.value = value;
    }

    public static StatusEnum fromValue(String value) {
        for (StatusEnum statusEnum : StatusEnum.values()) {
            if (statusEnum.value.equalsIgnoreCase(value)) {
                return statusEnum;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public String getValue() {
        return value;
    }
}