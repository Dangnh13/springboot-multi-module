package jp.co.htkk.dto.admin.dashboard.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jp.co.htkk.dto.admin.dashboard.rst.MonthlyPointRst;
import jp.co.htkk.dto.common.RESPONSE;
import lombok.Data;

/**
 * Monthly Point response data
 *
 * @author DangNH
 * @version 1.0.
 */
@Data
public class MonthlyPointResponse extends RESPONSE {
    private static final String DATA_KEY = "data";

    @Schema(description = "月次のポイント集計")
    @JsonProperty(DATA_KEY)
    private PointData pointData = new PointData();

    public static MonthlyPointResponse of(MonthlyPointRst rst) {
        MonthlyPointResponse response = new MonthlyPointResponse();
        response.getPointData().getEarnPoint().setStepPoint(rst.getEarnPoint().getStepPoint());
        response.getPointData().getEarnPoint().setPointEvent(rst.getEarnPoint().getPointEvent());
        response.getPointData().getUsedPoint().setPayPayPoint(rst.getUsedPoint().getPayPayPoint());
        response.getPointData().getUsedPoint().setMallPoint(rst.getUsedPoint().getMallPoint());
        response.getPointData().setRevocationPoint(rst.getRevocationPoint());
        return response;
    }

    @Schema(name = "MonthlyPointResponse.PointData")
    @Data
    public static class PointData {

        @Schema(description = "ポイント獲得")
        private EarningPoint earnPoint = new EarningPoint();

        @Schema(description = "使用したポイント")
        private UsedPoint usedPoint = new UsedPoint();

        @Schema(description = "失効となったポイント", example = "126560")
        private int revocationPoint;

        @Schema(name = "MonthlyPointResponse.PointData.EarnPoint")
        @Data
        public static class EarningPoint {
            @Schema(description = "歩数で獲得", example = "126560")
            private int stepPoint;

            @Schema(description = "イベント条件達成で獲得", example = "50000")
            private int pointEvent;
        }

        @Schema(name = "MonthlyPointResponse.PointData.UsedPoint")
        @Data
        public static class UsedPoint {
            @Schema(description = "PayPayで使用したポイント", example = "3000")
            private int payPayPoint;

            @Schema(description = "モールで使用したポイント", example = "1000")
            private int mallPoint;
        }
    }
}
