package jp.co.htkk.batch.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Dates {

    private Dates() {
    }

    /**
     * Retrieve date now
     *
     * @return {@link Date} now
     */
    public static Date now() {
        return new Date();
    }

    public static LocalDate toLocalDate(String dateStr, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDate localDate = LocalDate.parse(dateStr, formatter);
        return localDate;
    }

    public static LocalDate minusMonth(LocalDate targetDate, int monthsToSubtract) {
        return targetDate.minusMonths(monthsToSubtract);
    }
}
