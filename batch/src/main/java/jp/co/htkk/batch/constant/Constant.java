package jp.co.htkk.batch.constant;

public interface Constant {

    interface DATE {
        String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss";
        String EXCEL_DATE_FORMAT = "M/d/yy";
        String DD_MM_YYYY_SLASH = "dd/MM/yyyy";
        String YYYY_MM_DD_DASH = "yyyy-MM-dd";
    }

    interface EXIT_CODE {
        int EXIT_NORMAL = 0;
        int EXIT_ABNORMAL_ERROR = 1;
    }

    interface SYMBOL {
        String PERCENT = "%";
        String HYPHEN = "-";
    }
}