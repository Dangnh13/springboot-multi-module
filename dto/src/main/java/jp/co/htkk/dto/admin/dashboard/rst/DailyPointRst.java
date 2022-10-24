package jp.co.htkk.dto.admin.dashboard.rst;

import jp.co.htkk.dto.common.RST;
import lombok.Data;

/**
 * Result data when perform query db for getting daily point data
 *
 * @author dangn
 */
@Data
public class DailyPointRst extends RST {

    private EarnPoint earnPoint = new EarnPoint();

    private UsedPoint usedPoint = new UsedPoint();

    private int balanceConversion;

    private int revocationPoint;

    private int balancePoint;

    @Data
    public static class EarnPoint {
        private int stepPoint;
        private int pointEvent;
    }

    @Data
    public static class UsedPoint {
        private int payPayPoint;
        private int mallPoint;
    }

}
