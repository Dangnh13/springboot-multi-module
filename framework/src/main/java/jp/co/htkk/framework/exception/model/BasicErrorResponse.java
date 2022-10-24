package jp.co.htkk.framework.exception.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.htkk.framework.constant.CommonConstant;
import jp.co.htkk.framework.util.Dates;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.List;

@Data
public class BasicErrorResponse implements Serializable {

    private static final long serialVersionUID = -5214318729027027493L;

    protected BasicErrorResponse() {
        timestamp = Dates.format(Dates.now(), CommonConstant.DATE_FORMAT.YYYY_MM_DD_HH_MM_SS_SLASH);
    }

    protected BasicErrorResponse(String message, List<String> errorCodes) {
        this();
        this.message = StringUtils.defaultIfBlank(message, StringUtils.EMPTY);
        this.errorCodes = errorCodes;
    }

//    @ApiModelProperty(value = "Time of the error")
    private String timestamp;

//    @ApiModelProperty(value = "Message error")
    private String message;

    @JsonProperty(value = "error_codes")
//    @ApiModelProperty(value = "Error codes")
    private List<String> errorCodes;
}
