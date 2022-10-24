package jp.co.htkk.framework.util;

import jp.co.htkk.framework.converter.CustomBigDecimalConverter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DoubleConverter;
import org.apache.commons.beanutils.converters.FloatConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.beanutils.converters.LongConverter;
import org.apache.commons.beanutils.converters.ShortConverter;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * General bean manipulation utilities.
 */
@Slf4j
public class BeanUtil {

    private static BeanUtilsBean buNative;

    static {
        buNative = new BeanUtilsBean(new ConvertUtilsBean(), BeanUtilsBean.getInstance().getPropertyUtils());
        buNative.getConvertUtils().register(new LongConverter(null), Long.class);
        buNative.getConvertUtils().register(new IntegerConverter(null), Integer.class);
        buNative.getConvertUtils().register(new ShortConverter(null), Short.class);
        buNative.getConvertUtils().register(new FloatConverter(null), Float.class);
        buNative.getConvertUtils().register(new DoubleConverter(null), Double.class);
        buNative.getConvertUtils().register(new CustomBigDecimalConverter(), BigDecimal.class);
        buNative.getConvertUtils().register(new DateConverter(), Date.class);
    }

    private BeanUtil() {
    }

    /**
     * Copy property values from the "origin" bean to the "destination" bean
     *
     * @param source origin bean
     * @param target destination bean
     */
    public static void copyProperties(Object source, Object target) {
        try {
            buNative.copyProperties(target, source);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error when copy properties from {} to {}. Detail: {}", source.getClass(), target.getClass(), e.getMessage());
        }

    }

    /**
     * Create "destination" bean and Copy property values from the "origin" bean
     *
     * @param source origin bean
     * @param c      type of destination bean
     * @param <T>    type of destination bean
     * @return new instance of destination bean after copy property values from the "origin" bean
     */
    public static <T> T createAndCopyProperties(Object source, Class<T> c) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        T target = null;
        try {
            target = c.newInstance();
            buNative.copyProperties(target, source);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        return target;
    }
}