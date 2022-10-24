package jp.co.htkk.framework.enums;

import lombok.Getter;

import java.util.EnumSet;

@Getter
public enum ETransactionType {

    PAYPAY((short) 1),
    MALL((short) 2),
    REVOCATION((short) 3);

    public final short code;

    // Constructor
    ETransactionType(short code) {
        this.code = code;
    }

    // Class Methods
    public static ETransactionType atCode(short code) {
        return EnumSet.allOf(ETransactionType.class).stream()
                .filter(category -> category.code == code)
                .findFirst()
                .orElse(null);
    }
}
