package jp.co.htkk.persistence.dao.custom;

import jp.co.htkk.dto.monthlypoint.rst.TotalPointInMonthRst;
import jp.co.htkk.persistence.dao.generator.MonthlyPointMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * Daily point mapper CRUD
 *
 * @author dangnh
 */
@Mapper
public interface CustomMonthlyPointMapper extends MonthlyPointMapper {
    /**
     * Get total earn point, used point and revocation point in month
     *
     * @param month parameter for getting total point
     * @return total point
     */
    TotalPointInMonthRst getTotalPointInMonth(String month);

}
