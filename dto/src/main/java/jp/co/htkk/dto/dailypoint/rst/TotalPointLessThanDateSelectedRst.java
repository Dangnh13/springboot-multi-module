package jp.co.htkk.dto.dailypoint.rst;

import jp.co.htkk.dto.common.RST;
import lombok.Data;

/**
 * Total earn point, point event
 *
 * @author HienHV
 */
@Data
public class TotalPointLessThanDateSelectedRst extends RST {
    private int earnPoint;
    private int pointEvent;
}
