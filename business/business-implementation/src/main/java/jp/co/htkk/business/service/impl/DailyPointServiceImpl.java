package jp.co.htkk.business.service.impl;

import jp.co.htkk.business.service.AbstractBaseService;
import jp.co.htkk.business.service.DailyPointService;
import jp.co.htkk.dto.dailypoint.rst.TotalPointLessThanDateSelectedRst;
import jp.co.htkk.persistence.dao.custom.CustomDailyPointMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Daily point service implementation
 *
 * @author dangnh
 */
@Service
@AllArgsConstructor
public class DailyPointServiceImpl extends AbstractBaseService implements DailyPointService {

    private final CustomDailyPointMapper dailyPointMapper;

    /**
     * Get total of earn point since the application released to date selected
     *
     * @param date request parameter for getting total point
     * @return total earn point
     */
    @Override
    public TotalPointLessThanDateSelectedRst getTotalPointLessThanDateSelected(String date) {
        return dailyPointMapper.getTotalPointLessThanDateSelected(date);
    }
}
