package jp.co.htkk.dto.transactionpoint.dxo;

import jp.co.htkk.dto.common.DXO;
import jp.co.htkk.dto.transactionpoint.prm.TotalPointByDateAndStatusAndTypePrm;
import jp.co.htkk.framework.enums.ETransactionStatus;
import jp.co.htkk.framework.enums.ETransactionType;
import lombok.Builder;
import lombok.Data;

/**
 * Condition for getting total point by date and status and type
 *
 * @author HienHV
 */
@Data
@Builder
public class TotalPointByDateAndStatusAndTypeDxo extends DXO {

    private String transactionDate;

    private ETransactionStatus transactionStatus;

    private ETransactionType transactionType;

    @Override
    public TotalPointByDateAndStatusAndTypePrm toPrm() {
        return TotalPointByDateAndStatusAndTypePrm.builder()
                .transactionDate(this.transactionDate)
                .transactionStatus(this.transactionStatus.code)
                .transactionType(this.transactionType.code)
                .build();
    }
}
