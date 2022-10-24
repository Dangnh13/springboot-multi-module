package jp.co.htkk.dto.monthlypoint.rst;

import jp.co.htkk.dto.common.RST;
import lombok.Data;

/**
 * Result of total earn point, point event, used point, revocation point in month
 *
 * @author DangNH
 */
@Data
public class TotalPointInMonthRst extends RST {
    private int earnPoint;
    private int pointEvent;
    private int usedPoint;
    private int revocationPoint;
}
