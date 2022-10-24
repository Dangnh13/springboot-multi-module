package jp.co.htkk.business.service.impl;

import jp.co.htkk.business.service.AbstractBaseService;
import jp.co.htkk.business.service.MonthlyPointService;
import jp.co.htkk.dto.monthlypoint.rst.TotalPointInMonthRst;
import jp.co.htkk.persistence.dao.custom.CustomMonthlyPointMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * MOnthly point service implementation
 *
 * @author dangnh
 */
@Service
@AllArgsConstructor
public class MonthlyPointServiceImpl extends AbstractBaseService implements MonthlyPointService {

    private final CustomMonthlyPointMapper monthlyPointMapper;

    /**
     * Get total earn point, used point and revocation point in month
     *
     * @param month parameter for getting total point
     * @return total point result
     */
    @Override
    public TotalPointInMonthRst getTotalPointInMonth(String month) {
        return monthlyPointMapper.getTotalPointInMonth(month);
    }

}
