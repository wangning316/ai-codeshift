package com.company.project.enums;

/**
 * 通用状态枚举
 */
public enum CommonStatusEnum {
    DISABLED(0, "禁用"),
    ENABLED(1, "启用");

    private final int value;
    private final String description;

    CommonStatusEnum(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public static CommonStatusEnum fromValue(int value) {
        for (CommonStatusEnum status : CommonStatusEnum.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid status value: " + value);
    }
}