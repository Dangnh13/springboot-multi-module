package jp.co.htkk.framework.enums;

import lombok.Getter;

import java.util.EnumSet;

@Getter
public enum ETransactionStatus {

    SUCCESS((short) 1),
    ERROR((short) 2),
    PENDING((short) 3);

    public final short code;

    // Constructor
    ETransactionStatus(short code) {
        this.code = code;
    }

    // Class Methods
    public static ETransactionStatus atCode(short code) {
        return EnumSet.allOf(ETransactionStatus.class).stream()
                .filter(category -> category.code == code)
                .findFirst()
                .orElse(null);
    }
}
