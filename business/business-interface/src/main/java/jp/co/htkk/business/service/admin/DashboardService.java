package jp.co.htkk.business.service.admin;

import jp.co.htkk.dto.admin.dashboard.dxo.DailyPointDxo;
import jp.co.htkk.dto.admin.dashboard.dxo.MonthlyPointDxo;
import jp.co.htkk.dto.admin.dashboard.rst.DailyPointRst;
import jp.co.htkk.dto.admin.dashboard.rst.MonthlyPointRst;

/**
 * Dashboard service
 *
 * @author dangnh
 */
public interface DashboardService {

    /**
     * Get monthly point data
     *
     * @param dxo monthly point parameter
     * @return monthly point data summary
     */
    MonthlyPointRst getMonthlyPoint(MonthlyPointDxo dxo);

    /**
     * Get daily point data
     *
     * @param dxo daily point parameter
     * @return daily point data summary
     */
    DailyPointRst getDailyPoint(DailyPointDxo dxo);
}
