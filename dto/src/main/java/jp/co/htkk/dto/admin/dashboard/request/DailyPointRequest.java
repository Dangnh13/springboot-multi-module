package jp.co.htkk.dto.admin.dashboard.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jp.co.htkk.dto.admin.dashboard.dxo.DailyPointDxo;
import jp.co.htkk.dto.common.REQUEST;
import jp.co.htkk.framework.constant.CommonConstant;
import jp.co.htkk.framework.validation.annotation.DateFormat;
import jp.co.htkk.framework.validation.annotation.RequiredNotBlank;
import lombok.Data;

import java.lang.reflect.InvocationTargetException;

/**
 * Request parameter for getting daily point data
 *
 * @author HienHv
 */
@Data
public class DailyPointRequest extends REQUEST {

    @Schema(description = "日付を選択", required = true, format = CommonConstant.DATE_FORMAT.YYYYMMDD, example = "20221223")
    @RequiredNotBlank
    @DateFormat(name = "dateSelected", format = CommonConstant.DATE_FORMAT.YYYYMMDD)
    private String dateSelected;

    @Override
    public DailyPointDxo toDxo() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        return DailyPointDxo.builder()
                .dateSelected(this.dateSelected)
                .build();
    }
}
