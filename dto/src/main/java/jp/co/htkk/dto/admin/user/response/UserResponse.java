package jp.co.htkk.dto.admin.user.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jp.co.htkk.dto.admin.user.rst.UserRst;
import jp.co.htkk.dto.common.RESPONSE;
import lombok.Data;

/**
 * User search by UserId or phoneNumber response data
 *
 * @author TuanDS
 * @version 1.0.
 */
@Data
public class UserResponse extends RESPONSE {

    private static final String DATA_KEY = "data";

    @Schema(description = "ユーザー検索")
    @JsonProperty(DATA_KEY)
    private UserData userData;

    public static jp.co.htkk.dto.admin.user.response.UserResponse of(UserRst rst) {
        return new jp.co.htkk.dto.admin.user.response.UserResponse();
    }

    @Schema(name="UserResponse.Data")
    @Data
    public static class UserData {

	    @Schema(description = "ユーザーID", example = "12345678999")
	    private String userId;

	    @Schema(description = "電話番号", example = "080111123456")
	    private String phoneNumber;

	    @Schema(description = "招待コード", example = "210006666")
	    private String invitationCode;

	    @Schema(description = "グループ番号", example = "03")
	    private String groupNumber;

	    @Schema(description = "保有ポイント", example = "1000")
	    private String holdingPoints;

	    @Schema(description = "歩数ポイント", example = "1000")
	    private String step;

	    @Schema(description = "イベントポイント", example = "500")
	    private String eventPoint;


        @Schema(description ="交換ポイント履歴")
        private HistoryTransPoint historyTransPoint;

        @Data
        public static class HistoryTransPoint {
            @Schema(description ="ポイント使用日", example = "2022-03-25 18:59:59")
            private String transactionDate;

            @Schema(description ="交換形式 1:Paypay  2:モール「商品購入」 3:失効", example = "Paypay")
            private String transactionType;

	        @Schema(description ="交換ポイント数", example = "1000")
	        private int amountPoint;

        }
    }
}
