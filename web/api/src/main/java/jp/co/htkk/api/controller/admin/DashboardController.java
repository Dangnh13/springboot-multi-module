package jp.co.htkk.api.controller.admin;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jp.co.htkk.api.controller.AbstractBaseController;
import jp.co.htkk.business.service.admin.DashboardService;
import jp.co.htkk.dto.admin.dashboard.request.DailyPointRequest;
import jp.co.htkk.dto.admin.dashboard.request.MonthlyPointRequest;
import jp.co.htkk.dto.admin.dashboard.response.DailyPointResponse;
import jp.co.htkk.dto.admin.dashboard.response.MonthlyPointResponse;
import jp.co.htkk.dto.admin.dashboard.rst.DailyPointRst;
import jp.co.htkk.dto.admin.dashboard.rst.MonthlyPointRst;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;

/**
 * Dashboard APIs: Get daily/monthly point data
 *
 * @author DangNH
 * @version 1.0.
 */
@Tag(name = "日次・月次のポイント用API", description = "Get daily/monthly point data controller")
@RestController
@AllArgsConstructor
public class DashboardController extends AbstractBaseController {

    private final DashboardService dashboardService;

    /**
     * Get monthly point data summary
     *
     * @param request query data
     * @return monthly point data summary
     * @throws BindException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    @Operation(summary = "月次のポイントを取得 ")
    @GetMapping(value = "${endpoint.admin.dashboard.monthly}")
    public ResponseEntity<MonthlyPointResponse> getMonthlyPoint(@Valid MonthlyPointRequest request, BindingResult bindingResult) throws BindException, InvocationTargetException, IllegalAccessException, InstantiationException {
        MonthlyPointRst result = (MonthlyPointRst) bindingResultWithValidate(bindingResult, request, dashboardService::getMonthlyPoint);
        return ResponseEntity.status(HttpStatus.OK).body(MonthlyPointResponse.of(result));
    }

    /**
     * Get daily point data summary
     *
     * @param request query data
     * @return daily point data summary
     * @throws BindException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    @Operation(summary = "日次のポイントを取得")
    @GetMapping(value = "${endpoint.admin.dashboard.daily}")
    public ResponseEntity<DailyPointResponse> getDailyPoint(@Valid DailyPointRequest request, BindingResult bindingResult) throws BindException, InvocationTargetException, IllegalAccessException, InstantiationException {
        DailyPointRst result = (DailyPointRst) bindingResultWithValidate(bindingResult, request, dashboardService::getDailyPoint);
        return ResponseEntity.status(HttpStatus.OK).body(DailyPointResponse.of(result));
    }
}
