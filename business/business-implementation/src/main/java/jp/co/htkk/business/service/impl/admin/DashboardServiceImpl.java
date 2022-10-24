package jp.co.htkk.business.service.impl.admin;

import jp.co.htkk.business.service.AbstractBaseService;
import jp.co.htkk.business.service.DailyPointService;
import jp.co.htkk.business.service.MonthlyPointService;
import jp.co.htkk.business.service.TransactionPointService;
import jp.co.htkk.business.service.admin.DashboardService;
import jp.co.htkk.dto.admin.dashboard.dxo.DailyPointDxo;
import jp.co.htkk.dto.admin.dashboard.dxo.MonthlyPointDxo;
import jp.co.htkk.dto.admin.dashboard.rst.DailyPointRst;
import jp.co.htkk.dto.admin.dashboard.rst.MonthlyPointRst;
import jp.co.htkk.dto.dailypoint.rst.TotalPointLessThanDateSelectedRst;
import jp.co.htkk.dto.monthlypoint.rst.TotalPointInMonthRst;
import jp.co.htkk.dto.transactionpoint.dxo.TotalPointByDateAndStatusAndTypeDxo;
import jp.co.htkk.dto.transactionpoint.rst.TotalPointByDateAndStatusAndTypeRst;
import jp.co.htkk.framework.enums.ETransactionStatus;
import jp.co.htkk.framework.enums.ETransactionType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Dashboard service implementation
 *
 * @author dangnh
 */
@Service
@AllArgsConstructor
public class DashboardServiceImpl extends AbstractBaseService implements DashboardService {

    private final MonthlyPointService monthlyPointService;

    private final DailyPointService dailyPointService;

    private final TransactionPointService transactionPointService;

    /**
     * Get monthly point data
     *
     * @param dxo monthly point parameter
     * @return monthly point data summary
     */
    @Override
    public MonthlyPointRst getMonthlyPoint(MonthlyPointDxo dxo) {
        // Get step point, event point, used point, revocation point in month selected
        TotalPointInMonthRst points = monthlyPointService.getTotalPointInMonth(dxo.getMonthSelected());
        // Setting result data
        MonthlyPointRst rst = new MonthlyPointRst();
        if (points != null) {
            rst.getEarnPoint().setStepPoint(points.getEarnPoint());
            rst.getEarnPoint().setPointEvent(points.getPointEvent());
            rst.getUsedPoint().setPayPayPoint(points.getUsedPoint());
            rst.setRevocationPoint(points.getRevocationPoint());
        }
        return rst;
    }

    /**
     * Get daily point data
     *
     * @param dxo daily point parameter {@link DailyPointDxo}
     * @return monthly point data summary
     */
    @Override
    public DailyPointRst getDailyPoint(DailyPointDxo dxo) {
        DailyPointRst rst = new DailyPointRst();

        // Getting Earn point less than date selected
        TotalPointLessThanDateSelectedRst pointLessThanDateSelected = dailyPointService.getTotalPointLessThanDateSelected(dxo.getDateSelected());
        if (pointLessThanDateSelected != null) {
            rst.getEarnPoint().setStepPoint(pointLessThanDateSelected.getEarnPoint());
            rst.getEarnPoint().setPointEvent(pointLessThanDateSelected.getPointEvent());
        }

        // Getting used point less than date selected
        TotalPointByDateAndStatusAndTypeRst usedPointRst = transactionPointService.getTotalPointLessThanDateAndStatusAndType(TotalPointByDateAndStatusAndTypeDxo.builder()
                .transactionDate(dxo.getDateSelected())
                .transactionStatus(ETransactionStatus.SUCCESS)
                .transactionType(ETransactionType.PAYPAY)
                .build());
        if (usedPointRst != null) {
            rst.getUsedPoint().setPayPayPoint(usedPointRst.getAmountPoint());
        }

        // Getting revocation point in date selected
        TotalPointByDateAndStatusAndTypeRst revocationPointRst = transactionPointService.getTotalPointLessThanDateAndStatusAndType(TotalPointByDateAndStatusAndTypeDxo.builder()
                .transactionDate(dxo.getDateSelected())
                .transactionStatus(ETransactionStatus.SUCCESS)
                .transactionType(ETransactionType.REVOCATION)
                .build());
        if (revocationPointRst != null) {
            rst.setRevocationPoint(revocationPointRst.getAmountPoint());
        }

        // Calculate balance point
        int balancePoint = calculateBalancePoint(rst.getEarnPoint().getStepPoint(),
                rst.getEarnPoint().getPointEvent(),
                rst.getUsedPoint().getPayPayPoint(),
                rst.getRevocationPoint());
        rst.setBalancePoint(balancePoint);

        rst.setBalanceConversion(rst.getBalancePoint());
        return rst;
    }

    /**
     * Calculate balance point
     *
     * @param stepPoint       step point
     * @param pointEvent      point event
     * @param usedPoint       used point
     * @param revocationPoint revocation point
     * @return balance point
     */
    private int calculateBalancePoint(int stepPoint, int pointEvent, int usedPoint, int revocationPoint) {
        return (stepPoint + pointEvent) - usedPoint - revocationPoint;
    }
}
