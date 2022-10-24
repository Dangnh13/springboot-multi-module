package jp.co.htkk.dto.admin.dashboard.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jp.co.htkk.dto.admin.dashboard.dxo.MonthlyPointDxo;
import jp.co.htkk.dto.common.REQUEST;
import jp.co.htkk.framework.constant.CommonConstant;
import jp.co.htkk.framework.validation.annotation.DateFormat;
import jp.co.htkk.framework.validation.annotation.RequiredNotBlank;
import lombok.Data;

import java.lang.reflect.InvocationTargetException;

/**
 * Request parameter for getting monthly point data
 *
 * @author DangNH
 */
@Data
public class MonthlyPointRequest extends REQUEST {

    @Schema(description = "月を選択", required = true, format = CommonConstant.DATE_FORMAT.YYYYMM, example = "202212")
    @RequiredNotBlank
    @DateFormat(name = "monthSelected", format = CommonConstant.DATE_FORMAT.YYYYMM)
    private String monthSelected;

    @Override
    public MonthlyPointDxo toDxo() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        return MonthlyPointDxo.builder()
                .monthSelected(this.monthSelected)
                .build();
    }
}
