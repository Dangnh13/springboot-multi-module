package jp.co.htkk.persistence.dao.custom;

import jp.co.htkk.dto.transactionpoint.prm.TotalPointByDateAndStatusAndTypePrm;
import jp.co.htkk.dto.transactionpoint.rst.TotalPointByDateAndStatusAndTypeRst;
import jp.co.htkk.persistence.dao.generator.DailyPointMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * Daily point mapper CRUD
 *
 * @author HienHV
 */
@Mapper
public interface CustomTransactionPointMapper extends DailyPointMapper {

    /**
     * Get total point less than date, status and type
     *
     * @param prm request parameter for getting total point
     * @return total earn point, used point
     */
    TotalPointByDateAndStatusAndTypeRst getTotalPointLessThanDateAndStatusAndType(TotalPointByDateAndStatusAndTypePrm prm);

}
