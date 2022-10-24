package jp.co.htkk.business.service;

import jp.co.htkk.dto.monthlypoint.rst.TotalPointInMonthRst;
import jp.co.htkk.entity.generator.MonthlyPoint;

/**
 * Monthly point service
 *
 * @author dangnh
 */
public interface MonthlyPointService {

    /**
     * Get total earn point, used point and revocation point in month
     *
     * @param month parameter for getting total point
     * @return total point
     */
    TotalPointInMonthRst getTotalPointInMonth(String month);

}
