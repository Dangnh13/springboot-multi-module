package jp.co.htkk.business.service.impl;

import jp.co.htkk.business.service.MonthlyPointService;
import jp.co.htkk.business.service.impl.admin.DashboardServiceImpl;
import jp.co.htkk.dto.admin.dashboard.dxo.MonthlyPointDxo;
import jp.co.htkk.dto.admin.dashboard.rst.MonthlyPointRst;
import jp.co.htkk.dto.monthlypoint.rst.TotalPointInMonthRst;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class MonthlyPointServiceImplTest {

    @Mock
    MonthlyPointService monthlyPointService ;

    @InjectMocks
    DashboardServiceImpl dashboardService;

    @Test
    void returnAllItemPoint_getMonthlyPoint()  {
        String monthSelected = "202210";
        TotalPointInMonthRst rst = new TotalPointInMonthRst();
        rst.setEarnPoint(1000);
        rst.setRevocationPoint(2000);
        rst.setUsedPoint(3000);
        when(monthlyPointService.getTotalPointInMonth(monthSelected)).thenReturn(rst);
        MonthlyPointRst monthlyPoint = dashboardService.getMonthlyPoint(MonthlyPointDxo.builder()
                                            .monthSelected(monthSelected)
                                            .build());
        assertEquals(1000, monthlyPoint.getEarnPoint().getStepPoint());
        assertEquals(2000, monthlyPoint.getRevocationPoint());
        assertEquals(3000, monthlyPoint.getUsedPoint().getPayPayPoint());
    }

    @Test
    void noDataFound_getMonthlyPoint()  {
        String monthSelected = "202210";
        when(monthlyPointService.getTotalPointInMonth(monthSelected)).thenReturn(null);
        MonthlyPointRst monthlyPoint = dashboardService.getMonthlyPoint(MonthlyPointDxo.builder()
                .monthSelected(monthSelected)
                .build());
        assertEquals(0, monthlyPoint.getEarnPoint().getPointEvent());
        assertEquals(0, monthlyPoint.getUsedPoint().getPayPayPoint());
        assertEquals(0, monthlyPoint.getRevocationPoint());
    }
}