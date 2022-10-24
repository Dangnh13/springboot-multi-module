package jp.co.htkk.entity.generator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DailyPointCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DailyPointCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public DailyPointCriteria orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public DailyPointCriteria orderBy(String ... orderByClauses) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < orderByClauses.length; i++) {
            sb.append(orderByClauses[i]);
            if (i < orderByClauses.length - 1) {
                sb.append(" , ");
            }
        }
        this.setOrderByClause(sb.toString());
        return this;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria(this);
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static Criteria newAndCreateCriteria() {
        DailyPointCriteria example = new DailyPointCriteria();
        return example.createCriteria();
    }

    public DailyPointCriteria when(boolean condition, IExampleWhen then) {
        if (condition) {
            then.example(this);
        }
        return this;
    }

    public DailyPointCriteria when(boolean condition, IExampleWhen then, IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }
        return this;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andDailyPointIdIsNull() {
            addCriterion("daily_point_id is null");
            return (Criteria) this;
        }

        public Criteria andDailyPointIdIsNotNull() {
            addCriterion("daily_point_id is not null");
            return (Criteria) this;
        }

        public Criteria andDailyPointIdEqualTo(Long value) {
            addCriterion("daily_point_id =", value, "dailyPointId");
            return (Criteria) this;
        }

        public Criteria andDailyPointIdEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("daily_point_id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDailyPointIdNotEqualTo(Long value) {
            addCriterion("daily_point_id <>", value, "dailyPointId");
            return (Criteria) this;
        }

        public Criteria andDailyPointIdNotEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("daily_point_id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDailyPointIdGreaterThan(Long value) {
            addCriterion("daily_point_id >", value, "dailyPointId");
            return (Criteria) this;
        }

        public Criteria andDailyPointIdGreaterThanColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("daily_point_id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDailyPointIdGreaterThanOrEqualTo(Long value) {
            addCriterion("daily_point_id >=", value, "dailyPointId");
            return (Criteria) this;
        }

        public Criteria andDailyPointIdGreaterThanOrEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("daily_point_id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDailyPointIdLessThan(Long value) {
            addCriterion("daily_point_id <", value, "dailyPointId");
            return (Criteria) this;
        }

        public Criteria andDailyPointIdLessThanColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("daily_point_id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDailyPointIdLessThanOrEqualTo(Long value) {
            addCriterion("daily_point_id <=", value, "dailyPointId");
            return (Criteria) this;
        }

        public Criteria andDailyPointIdLessThanOrEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("daily_point_id <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDailyPointIdIn(List<Long> values) {
            addCriterion("daily_point_id in", values, "dailyPointId");
            return (Criteria) this;
        }

        public Criteria andDailyPointIdNotIn(List<Long> values) {
            addCriterion("daily_point_id not in", values, "dailyPointId");
            return (Criteria) this;
        }

        public Criteria andDailyPointIdBetween(Long value1, Long value2) {
            addCriterion("daily_point_id between", value1, value2, "dailyPointId");
            return (Criteria) this;
        }

        public Criteria andDailyPointIdNotBetween(Long value1, Long value2) {
            addCriterion("daily_point_id not between", value1, value2, "dailyPointId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("user_id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("user_id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("user_id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("user_id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("user_id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("user_id <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andStepCountIsNull() {
            addCriterion("step_count is null");
            return (Criteria) this;
        }

        public Criteria andStepCountIsNotNull() {
            addCriterion("step_count is not null");
            return (Criteria) this;
        }

        public Criteria andStepCountEqualTo(Integer value) {
            addCriterion("step_count =", value, "stepCount");
            return (Criteria) this;
        }

        public Criteria andStepCountEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("step_count = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStepCountNotEqualTo(Integer value) {
            addCriterion("step_count <>", value, "stepCount");
            return (Criteria) this;
        }

        public Criteria andStepCountNotEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("step_count <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStepCountGreaterThan(Integer value) {
            addCriterion("step_count >", value, "stepCount");
            return (Criteria) this;
        }

        public Criteria andStepCountGreaterThanColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("step_count > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStepCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("step_count >=", value, "stepCount");
            return (Criteria) this;
        }

        public Criteria andStepCountGreaterThanOrEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("step_count >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStepCountLessThan(Integer value) {
            addCriterion("step_count <", value, "stepCount");
            return (Criteria) this;
        }

        public Criteria andStepCountLessThanColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("step_count < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStepCountLessThanOrEqualTo(Integer value) {
            addCriterion("step_count <=", value, "stepCount");
            return (Criteria) this;
        }

        public Criteria andStepCountLessThanOrEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("step_count <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStepCountIn(List<Integer> values) {
            addCriterion("step_count in", values, "stepCount");
            return (Criteria) this;
        }

        public Criteria andStepCountNotIn(List<Integer> values) {
            addCriterion("step_count not in", values, "stepCount");
            return (Criteria) this;
        }

        public Criteria andStepCountBetween(Integer value1, Integer value2) {
            addCriterion("step_count between", value1, value2, "stepCount");
            return (Criteria) this;
        }

        public Criteria andStepCountNotBetween(Integer value1, Integer value2) {
            addCriterion("step_count not between", value1, value2, "stepCount");
            return (Criteria) this;
        }

        public Criteria andSyncDateIsNull() {
            addCriterion("sync_date is null");
            return (Criteria) this;
        }

        public Criteria andSyncDateIsNotNull() {
            addCriterion("sync_date is not null");
            return (Criteria) this;
        }

        public Criteria andSyncDateEqualTo(String value) {
            addCriterion("sync_date =", value, "syncDate");
            return (Criteria) this;
        }

        public Criteria andSyncDateEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("sync_date = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSyncDateNotEqualTo(String value) {
            addCriterion("sync_date <>", value, "syncDate");
            return (Criteria) this;
        }

        public Criteria andSyncDateNotEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("sync_date <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSyncDateGreaterThan(String value) {
            addCriterion("sync_date >", value, "syncDate");
            return (Criteria) this;
        }

        public Criteria andSyncDateGreaterThanColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("sync_date > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSyncDateGreaterThanOrEqualTo(String value) {
            addCriterion("sync_date >=", value, "syncDate");
            return (Criteria) this;
        }

        public Criteria andSyncDateGreaterThanOrEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("sync_date >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSyncDateLessThan(String value) {
            addCriterion("sync_date <", value, "syncDate");
            return (Criteria) this;
        }

        public Criteria andSyncDateLessThanColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("sync_date < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSyncDateLessThanOrEqualTo(String value) {
            addCriterion("sync_date <=", value, "syncDate");
            return (Criteria) this;
        }

        public Criteria andSyncDateLessThanOrEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("sync_date <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSyncDateLike(String value) {
            addCriterion("sync_date like", value, "syncDate");
            return (Criteria) this;
        }

        public Criteria andSyncDateNotLike(String value) {
            addCriterion("sync_date not like", value, "syncDate");
            return (Criteria) this;
        }

        public Criteria andSyncDateIn(List<String> values) {
            addCriterion("sync_date in", values, "syncDate");
            return (Criteria) this;
        }

        public Criteria andSyncDateNotIn(List<String> values) {
            addCriterion("sync_date not in", values, "syncDate");
            return (Criteria) this;
        }

        public Criteria andSyncDateBetween(String value1, String value2) {
            addCriterion("sync_date between", value1, value2, "syncDate");
            return (Criteria) this;
        }

        public Criteria andSyncDateNotBetween(String value1, String value2) {
            addCriterion("sync_date not between", value1, value2, "syncDate");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNull() {
            addCriterion("device_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNotNull() {
            addCriterion("device_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdEqualTo(String value) {
            addCriterion("device_id =", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("device_id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotEqualTo(String value) {
            addCriterion("device_id <>", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("device_id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThan(String value) {
            addCriterion("device_id >", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThanColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("device_id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThanOrEqualTo(String value) {
            addCriterion("device_id >=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThanOrEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("device_id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThan(String value) {
            addCriterion("device_id <", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThanColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("device_id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThanOrEqualTo(String value) {
            addCriterion("device_id <=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThanOrEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("device_id <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDeviceIdLike(String value) {
            addCriterion("device_id like", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotLike(String value) {
            addCriterion("device_id not like", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIn(List<String> values) {
            addCriterion("device_id in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotIn(List<String> values) {
            addCriterion("device_id not in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdBetween(String value1, String value2) {
            addCriterion("device_id between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotBetween(String value1, String value2) {
            addCriterion("device_id not between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andKcalIsNull() {
            addCriterion("kcal is null");
            return (Criteria) this;
        }

        public Criteria andKcalIsNotNull() {
            addCriterion("kcal is not null");
            return (Criteria) this;
        }

        public Criteria andKcalEqualTo(Integer value) {
            addCriterion("kcal =", value, "kcal");
            return (Criteria) this;
        }

        public Criteria andKcalEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("kcal = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andKcalNotEqualTo(Integer value) {
            addCriterion("kcal <>", value, "kcal");
            return (Criteria) this;
        }

        public Criteria andKcalNotEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("kcal <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andKcalGreaterThan(Integer value) {
            addCriterion("kcal >", value, "kcal");
            return (Criteria) this;
        }

        public Criteria andKcalGreaterThanColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("kcal > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andKcalGreaterThanOrEqualTo(Integer value) {
            addCriterion("kcal >=", value, "kcal");
            return (Criteria) this;
        }

        public Criteria andKcalGreaterThanOrEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("kcal >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andKcalLessThan(Integer value) {
            addCriterion("kcal <", value, "kcal");
            return (Criteria) this;
        }

        public Criteria andKcalLessThanColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("kcal < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andKcalLessThanOrEqualTo(Integer value) {
            addCriterion("kcal <=", value, "kcal");
            return (Criteria) this;
        }

        public Criteria andKcalLessThanOrEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("kcal <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andKcalIn(List<Integer> values) {
            addCriterion("kcal in", values, "kcal");
            return (Criteria) this;
        }

        public Criteria andKcalNotIn(List<Integer> values) {
            addCriterion("kcal not in", values, "kcal");
            return (Criteria) this;
        }

        public Criteria andKcalBetween(Integer value1, Integer value2) {
            addCriterion("kcal between", value1, value2, "kcal");
            return (Criteria) this;
        }

        public Criteria andKcalNotBetween(Integer value1, Integer value2) {
            addCriterion("kcal not between", value1, value2, "kcal");
            return (Criteria) this;
        }

        public Criteria andDistanceIsNull() {
            addCriterion("distance is null");
            return (Criteria) this;
        }

        public Criteria andDistanceIsNotNull() {
            addCriterion("distance is not null");
            return (Criteria) this;
        }

        public Criteria andDistanceEqualTo(Integer value) {
            addCriterion("distance =", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("distance = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDistanceNotEqualTo(Integer value) {
            addCriterion("distance <>", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("distance <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDistanceGreaterThan(Integer value) {
            addCriterion("distance >", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceGreaterThanColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("distance > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDistanceGreaterThanOrEqualTo(Integer value) {
            addCriterion("distance >=", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceGreaterThanOrEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("distance >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDistanceLessThan(Integer value) {
            addCriterion("distance <", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceLessThanColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("distance < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDistanceLessThanOrEqualTo(Integer value) {
            addCriterion("distance <=", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceLessThanOrEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("distance <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDistanceIn(List<Integer> values) {
            addCriterion("distance in", values, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotIn(List<Integer> values) {
            addCriterion("distance not in", values, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceBetween(Integer value1, Integer value2) {
            addCriterion("distance between", value1, value2, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotBetween(Integer value1, Integer value2) {
            addCriterion("distance not between", value1, value2, "distance");
            return (Criteria) this;
        }

        public Criteria andTotalTimeIsNull() {
            addCriterion("total_time is null");
            return (Criteria) this;
        }

        public Criteria andTotalTimeIsNotNull() {
            addCriterion("total_time is not null");
            return (Criteria) this;
        }

        public Criteria andTotalTimeEqualTo(Long value) {
            addCriterion("total_time =", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("total_time = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTotalTimeNotEqualTo(Long value) {
            addCriterion("total_time <>", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeNotEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("total_time <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTotalTimeGreaterThan(Long value) {
            addCriterion("total_time >", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeGreaterThanColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("total_time > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTotalTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("total_time >=", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeGreaterThanOrEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("total_time >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTotalTimeLessThan(Long value) {
            addCriterion("total_time <", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeLessThanColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("total_time < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTotalTimeLessThanOrEqualTo(Long value) {
            addCriterion("total_time <=", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeLessThanOrEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("total_time <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTotalTimeIn(List<Long> values) {
            addCriterion("total_time in", values, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeNotIn(List<Long> values) {
            addCriterion("total_time not in", values, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeBetween(Long value1, Long value2) {
            addCriterion("total_time between", value1, value2, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeNotBetween(Long value1, Long value2) {
            addCriterion("total_time not between", value1, value2, "totalTime");
            return (Criteria) this;
        }

        public Criteria andEarnPointIsNull() {
            addCriterion("earn_point is null");
            return (Criteria) this;
        }

        public Criteria andEarnPointIsNotNull() {
            addCriterion("earn_point is not null");
            return (Criteria) this;
        }

        public Criteria andEarnPointEqualTo(Integer value) {
            addCriterion("earn_point =", value, "earnPoint");
            return (Criteria) this;
        }

        public Criteria andEarnPointEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("earn_point = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andEarnPointNotEqualTo(Integer value) {
            addCriterion("earn_point <>", value, "earnPoint");
            return (Criteria) this;
        }

        public Criteria andEarnPointNotEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("earn_point <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andEarnPointGreaterThan(Integer value) {
            addCriterion("earn_point >", value, "earnPoint");
            return (Criteria) this;
        }

        public Criteria andEarnPointGreaterThanColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("earn_point > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andEarnPointGreaterThanOrEqualTo(Integer value) {
            addCriterion("earn_point >=", value, "earnPoint");
            return (Criteria) this;
        }

        public Criteria andEarnPointGreaterThanOrEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("earn_point >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andEarnPointLessThan(Integer value) {
            addCriterion("earn_point <", value, "earnPoint");
            return (Criteria) this;
        }

        public Criteria andEarnPointLessThanColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("earn_point < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andEarnPointLessThanOrEqualTo(Integer value) {
            addCriterion("earn_point <=", value, "earnPoint");
            return (Criteria) this;
        }

        public Criteria andEarnPointLessThanOrEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("earn_point <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andEarnPointIn(List<Integer> values) {
            addCriterion("earn_point in", values, "earnPoint");
            return (Criteria) this;
        }

        public Criteria andEarnPointNotIn(List<Integer> values) {
            addCriterion("earn_point not in", values, "earnPoint");
            return (Criteria) this;
        }

        public Criteria andEarnPointBetween(Integer value1, Integer value2) {
            addCriterion("earn_point between", value1, value2, "earnPoint");
            return (Criteria) this;
        }

        public Criteria andEarnPointNotBetween(Integer value1, Integer value2) {
            addCriterion("earn_point not between", value1, value2, "earnPoint");
            return (Criteria) this;
        }

        public Criteria andStepEventIsNull() {
            addCriterion("step_event is null");
            return (Criteria) this;
        }

        public Criteria andStepEventIsNotNull() {
            addCriterion("step_event is not null");
            return (Criteria) this;
        }

        public Criteria andStepEventEqualTo(Integer value) {
            addCriterion("step_event =", value, "stepEvent");
            return (Criteria) this;
        }

        public Criteria andStepEventEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("step_event = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStepEventNotEqualTo(Integer value) {
            addCriterion("step_event <>", value, "stepEvent");
            return (Criteria) this;
        }

        public Criteria andStepEventNotEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("step_event <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStepEventGreaterThan(Integer value) {
            addCriterion("step_event >", value, "stepEvent");
            return (Criteria) this;
        }

        public Criteria andStepEventGreaterThanColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("step_event > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStepEventGreaterThanOrEqualTo(Integer value) {
            addCriterion("step_event >=", value, "stepEvent");
            return (Criteria) this;
        }

        public Criteria andStepEventGreaterThanOrEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("step_event >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStepEventLessThan(Integer value) {
            addCriterion("step_event <", value, "stepEvent");
            return (Criteria) this;
        }

        public Criteria andStepEventLessThanColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("step_event < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStepEventLessThanOrEqualTo(Integer value) {
            addCriterion("step_event <=", value, "stepEvent");
            return (Criteria) this;
        }

        public Criteria andStepEventLessThanOrEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("step_event <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStepEventIn(List<Integer> values) {
            addCriterion("step_event in", values, "stepEvent");
            return (Criteria) this;
        }

        public Criteria andStepEventNotIn(List<Integer> values) {
            addCriterion("step_event not in", values, "stepEvent");
            return (Criteria) this;
        }

        public Criteria andStepEventBetween(Integer value1, Integer value2) {
            addCriterion("step_event between", value1, value2, "stepEvent");
            return (Criteria) this;
        }

        public Criteria andStepEventNotBetween(Integer value1, Integer value2) {
            addCriterion("step_event not between", value1, value2, "stepEvent");
            return (Criteria) this;
        }

        public Criteria andPointEventIsNull() {
            addCriterion("point_event is null");
            return (Criteria) this;
        }

        public Criteria andPointEventIsNotNull() {
            addCriterion("point_event is not null");
            return (Criteria) this;
        }

        public Criteria andPointEventEqualTo(Short value) {
            addCriterion("point_event =", value, "pointEvent");
            return (Criteria) this;
        }

        public Criteria andPointEventEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("point_event = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPointEventNotEqualTo(Short value) {
            addCriterion("point_event <>", value, "pointEvent");
            return (Criteria) this;
        }

        public Criteria andPointEventNotEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("point_event <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPointEventGreaterThan(Short value) {
            addCriterion("point_event >", value, "pointEvent");
            return (Criteria) this;
        }

        public Criteria andPointEventGreaterThanColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("point_event > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPointEventGreaterThanOrEqualTo(Short value) {
            addCriterion("point_event >=", value, "pointEvent");
            return (Criteria) this;
        }

        public Criteria andPointEventGreaterThanOrEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("point_event >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPointEventLessThan(Short value) {
            addCriterion("point_event <", value, "pointEvent");
            return (Criteria) this;
        }

        public Criteria andPointEventLessThanColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("point_event < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPointEventLessThanOrEqualTo(Short value) {
            addCriterion("point_event <=", value, "pointEvent");
            return (Criteria) this;
        }

        public Criteria andPointEventLessThanOrEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("point_event <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPointEventIn(List<Short> values) {
            addCriterion("point_event in", values, "pointEvent");
            return (Criteria) this;
        }

        public Criteria andPointEventNotIn(List<Short> values) {
            addCriterion("point_event not in", values, "pointEvent");
            return (Criteria) this;
        }

        public Criteria andPointEventBetween(Short value1, Short value2) {
            addCriterion("point_event between", value1, value2, "pointEvent");
            return (Criteria) this;
        }

        public Criteria andPointEventNotBetween(Short value1, Short value2) {
            addCriterion("point_event not between", value1, value2, "pointEvent");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNull() {
            addCriterion("created_by is null");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNotNull() {
            addCriterion("created_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedByEqualTo(Long value) {
            addCriterion("created_by =", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("created_by = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatedByNotEqualTo(Long value) {
            addCriterion("created_by <>", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("created_by <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThan(Long value) {
            addCriterion("created_by >", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThanColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("created_by > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThanOrEqualTo(Long value) {
            addCriterion("created_by >=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThanOrEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("created_by >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThan(Long value) {
            addCriterion("created_by <", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThanColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("created_by < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThanOrEqualTo(Long value) {
            addCriterion("created_by <=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThanOrEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("created_by <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatedByIn(List<Long> values) {
            addCriterion("created_by in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotIn(List<Long> values) {
            addCriterion("created_by not in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByBetween(Long value1, Long value2) {
            addCriterion("created_by between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotBetween(Long value1, Long value2) {
            addCriterion("created_by not between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNull() {
            addCriterion("created_at is null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNotNull() {
            addCriterion("created_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtEqualTo(Date value) {
            addCriterion("created_at =", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("created_at = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotEqualTo(Date value) {
            addCriterion("created_at <>", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("created_at <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThan(Date value) {
            addCriterion("created_at >", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThanColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("created_at > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("created_at >=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThanOrEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("created_at >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThan(Date value) {
            addCriterion("created_at <", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThanColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("created_at < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThanOrEqualTo(Date value) {
            addCriterion("created_at <=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThanOrEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("created_at <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatedAtIn(List<Date> values) {
            addCriterion("created_at in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotIn(List<Date> values) {
            addCriterion("created_at not in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtBetween(Date value1, Date value2) {
            addCriterion("created_at between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotBetween(Date value1, Date value2) {
            addCriterion("created_at not between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIsNull() {
            addCriterion("updated_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIsNotNull() {
            addCriterion("updated_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedByEqualTo(Long value) {
            addCriterion("updated_by =", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("updated_by = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotEqualTo(Long value) {
            addCriterion("updated_by <>", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("updated_by <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdatedByGreaterThan(Long value) {
            addCriterion("updated_by >", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByGreaterThanColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("updated_by > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdatedByGreaterThanOrEqualTo(Long value) {
            addCriterion("updated_by >=", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByGreaterThanOrEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("updated_by >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdatedByLessThan(Long value) {
            addCriterion("updated_by <", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByLessThanColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("updated_by < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdatedByLessThanOrEqualTo(Long value) {
            addCriterion("updated_by <=", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByLessThanOrEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("updated_by <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdatedByIn(List<Long> values) {
            addCriterion("updated_by in", values, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotIn(List<Long> values) {
            addCriterion("updated_by not in", values, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByBetween(Long value1, Long value2) {
            addCriterion("updated_by between", value1, value2, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotBetween(Long value1, Long value2) {
            addCriterion("updated_by not between", value1, value2, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNull() {
            addCriterion("updated_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNotNull() {
            addCriterion("updated_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtEqualTo(Date value) {
            addCriterion("updated_at =", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("updated_at = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotEqualTo(Date value) {
            addCriterion("updated_at <>", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("updated_at <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThan(Date value) {
            addCriterion("updated_at >", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThanColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("updated_at > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_at >=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThanOrEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("updated_at >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThan(Date value) {
            addCriterion("updated_at <", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThanColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("updated_at < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThanOrEqualTo(Date value) {
            addCriterion("updated_at <=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThanOrEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("updated_at <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIn(List<Date> values) {
            addCriterion("updated_at in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotIn(List<Date> values) {
            addCriterion("updated_at not in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtBetween(Date value1, Date value2) {
            addCriterion("updated_at between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotBetween(Date value1, Date value2) {
            addCriterion("updated_at not between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNull() {
            addCriterion("del_flag is null");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNotNull() {
            addCriterion("del_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlagEqualTo(Short value) {
            addCriterion("del_flag =", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("del_flag = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualTo(Short value) {
            addCriterion("del_flag <>", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("del_flag <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThan(Short value) {
            addCriterion("del_flag >", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("del_flag > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualTo(Short value) {
            addCriterion("del_flag >=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("del_flag >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThan(Short value) {
            addCriterion("del_flag <", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("del_flag < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualTo(Short value) {
            addCriterion("del_flag <=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualToColumn(DailyPoint.Column column) {
            addCriterion(new StringBuilder("del_flag <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDelFlagIn(List<Short> values) {
            addCriterion("del_flag in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotIn(List<Short> values) {
            addCriterion("del_flag not in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagBetween(Short value1, Short value2) {
            addCriterion("del_flag between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotBetween(Short value1, Short value2) {
            addCriterion("del_flag not between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andSyncDateLikeInsensitive(String value) {
            addCriterion("upper(sync_date) like", value.toUpperCase(), "syncDate");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLikeInsensitive(String value) {
            addCriterion("upper(device_id) like", value.toUpperCase(), "deviceId");
            return (Criteria) this;
        }

        public Criteria addConditionSql(String conditionSql) {
            addCriterion(conditionSql);
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        private DailyPointCriteria example;

        protected Criteria(DailyPointCriteria example) {
            super();
            this.example = example;
        }

        public DailyPointCriteria example() {
            return this.example;
        }

        @Deprecated
        public Criteria andIf(boolean ifAdd, ICriteriaAdd add) {
            if (ifAdd) {
                add.add(this);
            }
            return this;
        }

        public Criteria when(boolean condition, ICriteriaWhen then) {
            if (condition) {
                then.criteria(this);
            }
            return this;
        }

        public Criteria when(boolean condition, ICriteriaWhen then, ICriteriaWhen otherwise) {
            if (condition) {
                then.criteria(this);
            } else {
                otherwise.criteria(this);
            }
            return this;
        }

        @Deprecated
        public interface ICriteriaAdd {
            Criteria add(Criteria add);
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }

    public interface ICriteriaWhen {
        void criteria(Criteria criteria);
    }

    public interface IExampleWhen {
        void example(jp.co.htkk.entity.generator.DailyPointCriteria example);
    }
}