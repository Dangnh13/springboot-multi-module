package jp.co.htkk.framework.util;

import jp.co.htkk.framework.validation.annotation.Min;
import jp.co.htkk.framework.validation.annotation.Number;
import lombok.Data;

@Data
public class Page {

//    @ApiModelProperty("どこから取得（レコード順位）(Min=0)")
    @Number
    @Min(0)
    private String offset;

//    @ApiModelProperty("取得したいレコード数 (Min = 1)")
    @Number
    @Min(1)
    private String limit;
}
