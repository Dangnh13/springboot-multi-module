package jp.co.htkk.api.config.mybatis.intercept;

import jp.co.htkk.framework.security.model.LoginInfo;
import jp.co.htkk.framework.util.Dates;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;

import java.lang.reflect.Field;
import java.util.*;

@Intercepts(@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}))
@Slf4j
public class AuditInterceptor implements Interceptor {
    private static final String CREATED_UID_FIELD = "createdBy";
    private static final String CREATED_AT_FIELD = "createdAt";
    private static final String UPDATED_UID_FIELD = "updatedBy";
    private static final String UPDATED_AT_FIELD = "updatedAt";

    private static final String PARAM_MAP_LIST = "list";

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        // get sql
        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
        Object parameter = invocation.getArgs()[1];
        LoginInfo loginInfo = LoginInfo.fromContext();
        if (SqlCommandType.INSERT == sqlCommandType) {
            settingCreateField(parameter, loginInfo);
        } else if (SqlCommandType.UPDATE == sqlCommandType) {
            settingUpdateField(parameter, loginInfo);
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }

    private void settingCreateField(Object target, LoginInfo loginInfo) throws NoSuchFieldException, IllegalAccessException {
        if (target instanceof MapperMethod.ParamMap) {
            MapperMethod.ParamMap paramMap = (MapperMethod.ParamMap) target;
            if (paramMap.containsKey(PARAM_MAP_LIST) && paramMap.get(PARAM_MAP_LIST) != null) {
                List objects = ((List) paramMap.get(PARAM_MAP_LIST));
                for (Object e : objects) {
                    settingCreatedField(e, loginInfo);
                    settingUpdateField(e, loginInfo);
                }
            }
        } else {
            settingCreatedField(target, loginInfo);
            settingUpdateField(target, loginInfo);
        }

    }

    private void settingUpdateField(Object target, LoginInfo loginInfo) throws NoSuchFieldException, IllegalAccessException {
        setAuditingFields(target, UPDATED_UID_FIELD, getUid(loginInfo));
        setAuditingFields(target, UPDATED_AT_FIELD, Dates.now());
    }

    private void settingCreatedField(Object target, LoginInfo loginInfo) throws NoSuchFieldException, IllegalAccessException {
        setAuditingFields(target, CREATED_UID_FIELD, getUid(loginInfo));
        setAuditingFields(target, CREATED_AT_FIELD, Dates.now());
    }

    private void setAuditingFields(Object target, String fieldName, Object value) throws NoSuchFieldException, IllegalAccessException {
        try {
            List<Field> fields = new ArrayList<>();
            getAllFields(fields, target.getClass());

            Field field = fields.stream().filter(f -> f.getName().equals(fieldName)).findFirst().orElse(null);
            if (field != null) {
                field.setAccessible(true);
                if (field != null && field.get(target) == null) {
                    field.set(target, value);
                }
            }

        } catch (Exception ex) {
            log.warn("Can't assign value of {} field name: {}", fieldName, ex.getMessage());
        }

    }

    public static List<Field> getAllFields(List<Field> fields, Class<?> type) {
        fields.addAll(Arrays.asList(type.getDeclaredFields()));

        if (type.getSuperclass() != null) {
            getAllFields(fields, type.getSuperclass());
        }

        return fields;
    }

    private int getUid(LoginInfo loginInfo) {
        return 0;
    }
}