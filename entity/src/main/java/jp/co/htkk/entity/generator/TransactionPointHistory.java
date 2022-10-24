package jp.co.htkk.entity.generator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TransactionPointHistory implements Serializable {
    private Long transactionPointHistoryId;

    private Long transactionPointId;

    private Long userId;

    private Date transactionTime;

    private Short transactionType;

    private Integer amountPoint;

    private Short transactionStatus;

    private String deviceId;

    private Integer totalPoint;

    private Integer restPoint;

    private Long createdBy;

    private Date createdAt;

    private Long updatedBy;

    private Date updatedAt;

    private Short delFlag;

    private String message;

    private static final long serialVersionUID = 1L;

    public enum Column {
        transactionPointHistoryId("transaction_point_history_id", "transactionPointHistoryId", "BIGINT", false),
        transactionPointId("transaction_point_id", "transactionPointId", "BIGINT", false),
        userId("user_id", "userId", "BIGINT", false),
        transactionTime("transaction_time", "transactionTime", "TIMESTAMP", false),
        transactionType("transaction_type", "transactionType", "SMALLINT", false),
        amountPoint("amount_point", "amountPoint", "INTEGER", false),
        transactionStatus("transaction_status", "transactionStatus", "SMALLINT", false),
        deviceId("device_id", "deviceId", "VARCHAR", false),
        totalPoint("total_point", "totalPoint", "INTEGER", false),
        restPoint("rest_point", "restPoint", "INTEGER", false),
        createdBy("created_by", "createdBy", "BIGINT", false),
        createdAt("created_at", "createdAt", "TIMESTAMP", false),
        updatedBy("updated_by", "updatedBy", "BIGINT", false),
        updatedAt("updated_at", "updatedAt", "TIMESTAMP", false),
        delFlag("del_flag", "delFlag", "SMALLINT", false),
        message("message", "message", "LONGVARCHAR", false);

        private static final String BEGINNING_DELIMITER = "\"";

        private static final String ENDING_DELIMITER = "\"";

        private final String column;

        private final boolean isColumnNameDelimited;

        private final String javaProperty;

        private final String jdbcType;

        public String value() {
            return this.column;
        }

        public String getValue() {
            return this.column;
        }

        public String getJavaProperty() {
            return this.javaProperty;
        }

        public String getJdbcType() {
            return this.jdbcType;
        }

        Column(String column, String javaProperty, String jdbcType, boolean isColumnNameDelimited) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
            this.isColumnNameDelimited = isColumnNameDelimited;
        }

        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        public static Column[] excludes(Column ... excludes) {
            ArrayList<Column> columns = new ArrayList<>(Arrays.asList(Column.values()));
            if (excludes != null && excludes.length > 0) {
                columns.removeAll(new ArrayList<>(Arrays.asList(excludes)));
            }
            return columns.toArray(new Column[]{});
        }

        public static Column[] all() {
            return Column.values();
        }

        public String getEscapedColumnName() {
            if (this.isColumnNameDelimited) {
                return new StringBuilder().append(BEGINNING_DELIMITER).append(this.column).append(ENDING_DELIMITER).toString();
            } else {
                return this.column;
            }
        }

        public String getAliasedEscapedColumnName() {
            return this.getEscapedColumnName();
        }
    }
}