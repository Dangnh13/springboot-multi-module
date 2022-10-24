package jp.co.htkk.dto.transactionpoint.rst;

import jp.co.htkk.dto.common.RST;
import lombok.Data;

/**
 * Result for query db
 *
 * @author HienHV
 */
@Data
public class TotalPointByDateAndStatusAndTypeRst extends RST {
    private int amountPoint;
}
