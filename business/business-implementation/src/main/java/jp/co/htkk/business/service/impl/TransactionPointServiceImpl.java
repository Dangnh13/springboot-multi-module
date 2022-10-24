package jp.co.htkk.business.service.impl;

import jp.co.htkk.business.service.AbstractBaseService;
import jp.co.htkk.business.service.TransactionPointService;
import jp.co.htkk.dto.transactionpoint.dxo.TotalPointByDateAndStatusAndTypeDxo;
import jp.co.htkk.dto.transactionpoint.rst.TotalPointByDateAndStatusAndTypeRst;
import jp.co.htkk.persistence.dao.custom.CustomTransactionPointMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Transaction point service implementation
 *
 * @author HienHV
 */
@Service
@AllArgsConstructor
public class TransactionPointServiceImpl extends AbstractBaseService implements TransactionPointService {

    private final CustomTransactionPointMapper transactionPointMapper;

    /**
     * Get total amount point less than date and transaction status and transaction type
     *
     * @param dxo {@link TotalPointByDateAndStatusAndTypeDxo}
     * @return total point
     */
    @Override
    public TotalPointByDateAndStatusAndTypeRst getTotalPointLessThanDateAndStatusAndType(TotalPointByDateAndStatusAndTypeDxo dxo) {
        return transactionPointMapper.getTotalPointLessThanDateAndStatusAndType(dxo.toPrm());
    }

}
