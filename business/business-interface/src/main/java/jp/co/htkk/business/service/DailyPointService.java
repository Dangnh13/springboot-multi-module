package jp.co.htkk.business.service;

import jp.co.htkk.dto.dailypoint.rst.TotalPointLessThanDateSelectedRst;

/**
 * Daily point service
 *
 * @author dangnh
 */
public interface DailyPointService {

    /**
     * Get total of earn point since the application released to date selected
     *
     * @param date request parameter for getting total point
     * @return total earn point
     */
    TotalPointLessThanDateSelectedRst getTotalPointLessThanDateSelected(String date);
}
