package jp.co.htkk.dto.admin.dashboard.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jp.co.htkk.dto.admin.dashboard.rst.DailyPointRst;
import jp.co.htkk.dto.common.RESPONSE;
import lombok.Data;

/**
 * Daily Point response data
 *
 * @author HienHV
 * @version 1.0.
 */
@Data
public class DailyPointResponse extends RESPONSE {

    private static final String DATA_KEY = "data";

    @Schema(description = "日次のポイント集計")
    @JsonProperty(DATA_KEY)
    private PointData pointData = new PointData();

    public static DailyPointResponse of(DailyPointRst rst) {
        DailyPointResponse response = new DailyPointResponse();
        response.getPointData().getEarnPoint().setStepPoint(rst.getEarnPoint().getStepPoint());
        response.getPointData().getEarnPoint().setPointEvent(rst.getEarnPoint().getPointEvent());
        response.getPointData().getUsedPoint().setPayPayPoint(rst.getUsedPoint().getPayPayPoint());
        response.getPointData().getUsedPoint().setMallPoint(rst.getUsedPoint().getMallPoint());
        response.getPointData().setRevocationPoint(rst.getRevocationPoint());
        response.getPointData().setBalanceConversion(rst.getBalanceConversion());
        response.getPointData().setBalancePoint(rst.getBalancePoint());
        return response;
    }

    @Schema(name = "DailyPointResponse.PointData")
    @Data
    public static class PointData {

        @Schema(description = "ポイント獲得")
        private EarnPoint earnPoint = new EarnPoint();

        @Schema(description = "使用したポイント")
        private UsedPoint usedPoint = new UsedPoint();

        @Schema(description = "金額換算", example = "126560")
        private int balanceConversion;

        @Schema(description = "失効となったポイント", example = "126560")
        private int revocationPoint;

        @Schema(description = "保有残高ポイント", example = "126560")
        private int balancePoint;

        @Schema(name = "DailyPointResponse.PointData.EarnPoint")
        @Data
        public static class EarnPoint {
            @Schema(description = "歩数で獲得", example = "126560")
            private int stepPoint;

            @Schema(description = "イベント条件達成で獲得", example = "50000")
            private int pointEvent;
        }

        @Schema(name = "DailyPointResponse.PointData.UsedPoint")
        @Data
        public static class UsedPoint {
            @Schema(description = "PayPayで使用したポイント", example = "3000")
            private int payPayPoint;

            @Schema(description = "モールで使用したポイント", example = "1000")
            private int mallPoint;
        }
    }
}
