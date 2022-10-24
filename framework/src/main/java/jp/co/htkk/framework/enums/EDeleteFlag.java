package jp.co.htkk.framework.enums;

import lombok.Getter;

import java.util.EnumSet;

@Getter
public enum EDeleteFlag {

    DELETED((short) 1),
    NOT_DELETED((short) 0);

    public final short code;

    // Constructor
    EDeleteFlag(short code) {
        this.code = code;
    }

    // Class Methods
    public static EDeleteFlag atCode(short code) {
        return EnumSet.allOf(EDeleteFlag.class).stream()
                .filter(category -> category.code == code)
                .findFirst()
                .orElse(null);
    }
}
