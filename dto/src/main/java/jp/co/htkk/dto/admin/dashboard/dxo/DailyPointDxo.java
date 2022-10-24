package jp.co.htkk.dto.admin.dashboard.dxo;

import jp.co.htkk.dto.common.DXO;
import jp.co.htkk.dto.common.PRM;
import lombok.Builder;
import lombok.Data;

/**
 * Condition for getting daily point data
 * @author dangnh
 */
@Data
@Builder
public class DailyPointDxo extends DXO {

    private String dateSelected;

    @Override
    public <T extends PRM> T toPrm() {
        return null;
    }

}
