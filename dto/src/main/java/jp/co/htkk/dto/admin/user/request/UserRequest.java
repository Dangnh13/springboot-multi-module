package jp.co.htkk.dto.admin.user.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jp.co.htkk.dto.common.DXO;
import jp.co.htkk.dto.common.REQUEST;
import lombok.Data;

import java.lang.reflect.InvocationTargetException;

@Data
public class UserRequest extends REQUEST {

    @Schema(description = "ユーザーID", example = "12345678999")
    private String userId;

	@Schema(description = "電話番号", example = "080111123456")
	private String phoneNumber;

    @Override
    public <T extends DXO> T toDxo() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        return null;
    }
}
