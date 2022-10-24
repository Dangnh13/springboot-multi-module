package jp.co.htkk.batch.dto.job0001;

import jp.co.htkk.batch.dto.base.request.BaseRequest;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Job0001Request extends BaseRequest {
    private String username;
}
