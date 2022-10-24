package jp.co.htkk.persistence.dao.custom;

import jp.co.htkk.dto.dailypoint.rst.TotalPointLessThanDateSelectedRst;
import jp.co.htkk.persistence.dao.generator.DailyPointMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * Daily point mapper CRUD
 *
 * @author HienHV
 */
@Mapper
public interface CustomDailyPointMapper extends DailyPointMapper {

    /**
     * Get total of earn point since the application released to date selected
     *
     * @param date request parameter for getting total point
     * @return total earn point
     */
    TotalPointLessThanDateSelectedRst getTotalPointLessThanDateSelected(String date);
}
