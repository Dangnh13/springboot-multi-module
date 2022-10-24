package jp.co.htkk.framework.csv;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class AnnotationStrategy extends HeaderColumnNameTranslateMappingStrategy {

    Map<String, String> columnMap = new HashMap<>();

    public AnnotationStrategy(Class<?> clazz) {
        for (Field field : clazz.getDeclaredFields()) {
            CsvBindByName annotation = field.getAnnotation(CsvBindByName.class);
            if (annotation != null) {
                columnMap.put(field.getName().toUpperCase(), annotation.column());
            }
        }
        this.setType(clazz);
    }

    @Override
    public String getColumnName(int col) {
        String name = headerIndex.getByPosition(col);
        return name;
    }

    public String getHeaderName(int col) {
        String name = headerIndex.getByPosition(col);
        if (name != null) {
            name = columnMap.get(name);
        }
        return name;
    }

    @Override
    public String[] generateHeader(Object bean) throws CsvRequiredFieldEmptyException {
        String[] result = super.generateHeader(bean);
        for (int i = 0; i < result.length; i++) {
            result[i] = getHeaderName(i);
        }
        return result;
    }
}

