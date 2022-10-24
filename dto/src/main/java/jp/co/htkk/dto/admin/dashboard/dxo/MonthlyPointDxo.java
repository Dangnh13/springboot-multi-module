package jp.co.htkk.dto.admin.dashboard.dxo;

import jp.co.htkk.dto.common.DXO;
import jp.co.htkk.dto.common.PRM;
import lombok.Builder;
import lombok.Data;

/**
 * Monthly point request parameter
 * @author dangnh
 */
@Data
@Builder
public class MonthlyPointDxo extends DXO {

    private String monthSelected;

    @Override
    public <T extends PRM> T toPrm()  {
        return null;
    }
}
