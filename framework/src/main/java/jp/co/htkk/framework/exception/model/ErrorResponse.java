package jp.co.htkk.framework.exception.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.htkk.framework.constant.CommonConstant;
import jp.co.htkk.framework.util.ResourceBundleUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Error Response data when exception handling
 */
@Data
public class ErrorResponse extends BasicErrorResponse {

    private static transient ResourceBundle bundle = null;

    private static transient String ERROR_MSG_HTTP_STATUS_REQUIRED = null;

    @JsonIgnore
    private HttpStatus httpStatus;

    @JsonProperty(value = "validation_errors")
//    @ApiModelProperty(value = "Validation Errors")
    private Map<String, Object> validationErrors = new HashMap<>();

    static {
        //loading the necessary character
        bundle = ResourceBundleUtil.getResourceBundle(CommonConstant.RESOURCE_BUNDLE_COMMON);
        if (bundle != null) {
            ERROR_MSG_HTTP_STATUS_REQUIRED = ResourceBundleUtil.getMessage(bundle, "error.message.common.http.status.required");
        }
    }

    private ErrorResponse(HttpStatus httpStatus, String message, List<String> errorCodes, Map<String, Object> validationErrors) {
        this(httpStatus, message, errorCodes);
        this.validationErrors = validationErrors;
    }

    private ErrorResponse(HttpStatus httpStatus, String message, List<String> errorCodes) {
        super(message, errorCodes);
        this.httpStatus = httpStatus;
    }

    public static ErrorResponse of(HttpStatus httpStatus, String message, List<String> errorCodes) {
        if (httpStatus == null) {
            throw new IllegalArgumentException(ERROR_MSG_HTTP_STATUS_REQUIRED);
        }
        String errMsg = StringUtils.defaultIfBlank(message, StringUtils.EMPTY);
        List<String> list = errorCodes == null ? Collections.emptyList() : errorCodes;
        return new ErrorResponse(httpStatus, errMsg, list);
    }

    public static ErrorResponse of(HttpStatus httpStatus, String message, List<String> errorCodes, Map<String, Object> validationErrors) {
        if (httpStatus == null) {
            throw new IllegalArgumentException(ERROR_MSG_HTTP_STATUS_REQUIRED);
        }
        String errMsg = StringUtils.defaultIfBlank(message, StringUtils.EMPTY);

        return new ErrorResponse(httpStatus, errMsg, errorCodes, validationErrors);
    }

    public static BasicErrorResponse of(String message, List<String> errorCodes) {
        String errMsg = StringUtils.defaultIfBlank(message, StringUtils.EMPTY);
        return new BasicErrorResponse(errMsg, errorCodes);
    }

    @Data
    @AllArgsConstructor
    public static class ItemError {
//        @ApiModelProperty(value = "Reject value")
        @JsonProperty(value = "reject_value")
        private Object rejectValue;

//        @ApiModelProperty(value = "Reason")
        @JsonProperty(value = "reason")
        private String reason;
    }
}
