package jp.co.htkk.framework.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Slf4j
public class NumberUtil {

    public static final int DEFAULT_SCALE = 2;

    private NumberUtil() {
    }

    public static BigDecimal createBigDecimalFromNumber(Number target) {
        if (target == null) {
            return null;
        }
        return new BigDecimal(target.toString());
    }

    public static BigDecimal createBigDecimalFromString(String target) {
        if (StringUtils.isBlank(target)) {
            return null;
        }
        if (!NumberUtils.isCreatable(target)) {
            throw new IllegalArgumentException();
        }
        return new BigDecimal(target);
    }

    public static BigDecimal createBigDecimalFromNumberNullToZero(Number target) {
        if (target == null) {
            return BigDecimal.ZERO;
        }
        return new BigDecimal(target.toString());
    }

    public static BigDecimal createBigDecimalFromNumberNullToZero(Number target, int scale, RoundingMode roundingMode) {
        return createBigDecimalFromNumberNullToZero(target).setScale(scale, roundingMode);
    }

    public static BigDecimal createBigDecimalFromNumberNullToZero(Number target, RoundingMode roundingMode) {
        return createBigDecimalFromNumberNullToZero(target, DEFAULT_SCALE, roundingMode);
    }

    public static BigDecimal createBigDecimalFromStringNullToZero(String target) {
        if (StringUtils.isBlank(target)) {
            return BigDecimal.ZERO;
        }
        if (!NumberUtils.isCreatable(target)) {
            throw new IllegalArgumentException();

        }
        return new BigDecimal(target);
    }

    public static Long toLongValue(Number target) {
        if (target == null) {
            return null;
        }
        return Long.valueOf(target.longValue());

    }


    public static Long toLongValue(String target) {
        if (target == null) {
            return null;
        }
        return Long.valueOf(target);
    }

    public static Integer toIntValue(Number target) {
        if (target == null) {
            return null;
        }
        return Integer.valueOf(target.intValue());
    }

    public static Integer toIntValueNullToZero(Number target) {
        if (target == null) {
            return Integer.valueOf(0);
        }
        return Integer.valueOf(target.intValue());
    }

    public static Long toLongValueNullToZero(Number target) {
        if (target == null) {
            return Long.valueOf(0L);

        }
        return Long.valueOf(target.longValue());
    }

}
