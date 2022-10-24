package jp.co.htkk.business.service;

import jp.co.htkk.dto.transactionpoint.dxo.TotalPointByDateAndStatusAndTypeDxo;
import jp.co.htkk.dto.transactionpoint.rst.TotalPointByDateAndStatusAndTypeRst;

/**
 * Transaction point service
 *
 * @author HienHV
 */
public interface TransactionPointService {

    /**
     * Get total amount point by date and transaction status
     *
     * @param dxo {@link TotalPointByDateAndStatusAndTypeDxo}
     * @return total point
     */
    TotalPointByDateAndStatusAndTypeRst getTotalPointLessThanDateAndStatusAndType(TotalPointByDateAndStatusAndTypeDxo dxo);

}
