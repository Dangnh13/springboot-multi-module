package jp.co.htkk.api.controller.admin;

import jp.co.htkk.business.service.admin.DashboardService;
import jp.co.htkk.dto.admin.dashboard.dxo.DailyPointDxo;
import jp.co.htkk.dto.admin.dashboard.dxo.MonthlyPointDxo;
import jp.co.htkk.dto.admin.dashboard.rst.DailyPointRst;
import jp.co.htkk.dto.admin.dashboard.rst.MonthlyPointRst;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@ContextConfiguration(classes = DashboardController.class)
@TestPropertySource(properties = {
        "endpoint.admin.dashboard.monthly=/admin/dashboard/monthly",
        "endpoint.admin.dashboard.daily=/admin/dashboard/daily"
})
class DashboardControllerTest {

    @MockBean
    DashboardService dashboardService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldRetrieveAllItems_getMonthlyPoint() throws Exception {
        MonthlyPointRst rst = new MonthlyPointRst();
        MonthlyPointRst.EarnPoint earningPoint = new MonthlyPointRst.EarnPoint();
        earningPoint.setStepPoint(1000);
        earningPoint.setPointEvent(200);
        rst.setEarnPoint(earningPoint);

        MonthlyPointRst.UsedPoint usedPoint = new MonthlyPointRst.UsedPoint();
        usedPoint.setPayPayPoint(3000);
        usedPoint.setMallPoint(4000);
        rst.setUsedPoint(usedPoint);
        rst.setRevocationPoint(5000);

        when(dashboardService.getMonthlyPoint(any(MonthlyPointDxo.class)))
                .thenReturn(rst);
        RequestBuilder request = MockMvcRequestBuilders
                .get("/admin/dashboard/monthly")
                .param("monthSelected", "202210")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"data\":{\"earnPoint\":{\"stepPoint\":1000,\"pointEvent\":200},\"usedPoint\":{\"payPayPoint\":3000,\"mallPoint\":4000},\"revocationPoint\":5000}}"))
                .andReturn();
    }

    @Test
    public void shouldRetrieveBadRequest_getMonthlyPoint() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/admin/dashboard/monthly")
                .param("monthSelected", "20220101")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    public void shouldRetrieveAllItems_getDailyPoint() throws Exception {
        when(dashboardService.getDailyPoint(any(DailyPointDxo.class)))
                .thenReturn(new DailyPointRst());
        RequestBuilder request = MockMvcRequestBuilders
                .get("/admin/dashboard/daily")
                .param("dateSelected", "20221001")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();

    }

    @Test
    public void shouldRetrieveBadRequest_getDailyPoint() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/admin/dashboard/daily")
                .param("dateSelected", "202202")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isBadRequest())
                .andReturn();
    }
}