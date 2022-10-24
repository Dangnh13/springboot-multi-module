package jp.co.htkk.dto.admin.dashboard.rst;

import jp.co.htkk.dto.common.RST;
import lombok.Data;

/**
 * Monthly point result
 *
 * @author dangnh
 */
@Data
public class MonthlyPointRst extends RST {

    private EarnPoint earnPoint = new EarnPoint();

    private UsedPoint usedPoint = new UsedPoint();

    private int revocationPoint;

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
