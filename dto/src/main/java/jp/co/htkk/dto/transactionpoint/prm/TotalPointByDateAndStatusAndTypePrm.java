package jp.co.htkk.dto.transactionpoint.prm;

import jp.co.htkk.dto.common.PRM;
import lombok.Builder;
import lombok.Data;

/**
 * Condition for query db
 *
 * @author HienHV
 */
@Data
@Builder
public class TotalPointByDateAndStatusAndTypePrm extends PRM {

    private String transactionDate;

    private short transactionStatus;

    private short transactionType;
}
