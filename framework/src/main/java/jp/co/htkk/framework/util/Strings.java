package jp.co.htkk.framework.util;

import jp.co.htkk.framework.constant.CommonConstant;
import org.apache.commons.lang3.StringUtils;

import java.security.SecureRandom;
import java.util.Optional;

public class Strings extends org.apache.commons.lang3.StringUtils {

    // ASCII range - alphanumeric (0-9, a-z, A-Z)
    private static final String ASCII_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static String nvl(final String value) {
        return Optional.ofNullable(value).orElse(StringUtils.EMPTY);
    }

    public static String valueOf(Object obj) {
        return (obj == null) ? StringUtils.EMPTY : obj.toString();
    }

    public static String escapeChar(String before) {
        if (StringUtils.isNotBlank(before)) {
            before = before.replaceAll("\\\\", "\\\\\\\\");
            before = before.replaceAll("_", "\\\\_");
            before = before.replaceAll("%", "\\\\%");
        }
        return before;
    }

    public static String randomString(int numberChars) {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        // each iteration of loop choose a character randomly from the given ASCII range
        // and append it to StringBuilder instance
        for (int i = 0; i < numberChars; i++) {
            int randomIndex = random.nextInt(ASCII_CHARS.length());
            sb.append(ASCII_CHARS.charAt(randomIndex));
        }
        return sb.toString();
    }

    public static String likeConditionBuilder(String searchConditionValue) {
        return CommonConstant.SYMBOL.PERCENT + Strings.escapeChar(searchConditionValue) + CommonConstant.SYMBOL.PERCENT;
    }

    public static String nullOf(final String value) {
        return StringUtils.defaultIfBlank(value, null);
    }
}
