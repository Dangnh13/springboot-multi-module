package jp.co.htkk.framework.constant;

/**
 * Global constants
 */
public class CommonConstant {

    public static final String RESOURCE_BUNDLE_COMMON = "messages";

    public interface TOKEN {
        String TOKEN_PREFIX_BEARER = "Bearer ";

        String ID_TOKEN = "id_token";

        String ACCESS_TOKEN = "access_token";

        interface USER_CLAIM_SET {
            String EMAIL = "email";
            String NAME = "name";
            String UID = "uid";
        }

        interface SUBSYSTEM_CLAIM_SET {
            String CLIENT_ID = "cid";
            String RESOURCE_ID = "rid";
        }
    }

    public interface MODEL_ATTRIBUTE {
        String STATUS_CODE = "statusCode";
        String STACK_TRACE = "stackTrace";
    }

    public interface FILE_EXTENSION {
        String CSV = ".csv";
        String DAT = ".dat";
        String XLSX = ".xlsx";
    }

    public interface SYMBOL {

        String SLASH_SYMBOL = "/";
        String SLASH_FW = "／";

        String SPACE = " ";

        String BLANK_FW = "　";

        String TILDE_SYMBOL = "~";

        String BACK_SLASH = "\\";

        String MINUS_SYMBOL = "-";

        String DOT_SYMBOL = ".";

        String COMMA_SYMBOL = ",";

        String PREFIX_DOMAIN_MAIL = "@";

        String PERCENT = "%";

        String COLON_SYMBOL = ":";
        String COMMA_QUOTE = "\",\"";

        String COLON_QUOTE = "\":\"";

        String QUESTION = "？";

        String UNDERSCORE_SYMBOL = "_";

    }

    public interface DASH {
        String BIG = "—";
        String NORMAL = "−";
        String SMALL = "‐";
        String HUGE = "ー";
    }

    public interface DATE_FORMAT {
        String YYYY_MM_DD = "yyyy/MM/dd";
        String YYYY_MM_DD_DASH = "yyyy-MM-dd";
        String YYYY_MM_DD_HH_MM_SS_DASH = "yyyy-MM-dd HH:mm:ss";
        String YYYYMM = "yyyyMM";
        String YYYYMMDD = "yyyyMMdd";
        String DD_MM_YYYY = "dd/MM/yyyy";

        String YYYY_MM_DD_HH_MM = "yyyyMMddHHmm";
        String YYYY_MM_DD_HH_MM_SLASH = "yyyy/MM/dd HH:mm";
        String YYYY_MM_DD_HH_MM_SS_SLASH = "yyyy/MM/dd HH:mm:ss";
        String DD_MM_YYYY_HH_MM_SLASH = "dd/MM/yyyy HH:mm";
        String HH_MM = "HHmm";
        String JUST_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm'+09:00'";

        String YYYY_MM_DASH = "yyyy-MM";

        String YYYY_MM_DD_HH_MM_SS_UNDERSCORE = "yyyyMMdd_HHmmss";

    }

    public interface PAGING {
        int GET_ALL = 0;
        int PAGE_SIZE = 20;
        int PAGE_OFFSET_DEFAULT = 0;
    }

    public interface PATH_PATTERNS {

        String ALL = "/**";

        String[] SWAGGER = {
                "/api-docs/swagger-config",
                "/configuration/ui",
                "/api-docs",
                "/swagger-ui/**"
        };

        String HEALTH = "/actuator/**";

    }

    public interface MESSAGE {
        interface VALIDATION {
            String NOT_VALID_KEY = "javax.validation.constraints.Master.message";
            String NOT_FOUND_KEY = "error.message.common.service.NotFound.message";
            String ERR_HAS_BEEN_DELETE_MSG = "error.message.common.delete.hasBeenDeleted";
            String DUPLICATED_KEY = "error.message.common.duplicated";
            String ERR_POW_PLANT_FILE_HAS_BEEN_DELETE = "error.message.powPlantFile.cud.notAllowDelete";
            String NOT_BLANK_KEY = "javax.validation.constraints.NotBlank.message";
        }
    }
}
