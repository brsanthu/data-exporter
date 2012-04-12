package com.brsanthu.dataexporter;

import java.lang.reflect.Field;

import org.apache.commons.beanutils.PropertyUtils;

import com.brsanthu.dataexporter.model.Column;


/**
 * Creates an array of columns from a given object.
 * <h1>This class is not fully implemented</h1>
 * 
 * @author Santhosh Kumar
 */
public class BeanColumnBuilder {
    public Column[] build(Object bean) {
        if (bean == null) {
            throw new IllegalArgumentException("Parameter bean cannot be null");
        }

        //Read each getters
        Field[] fields = bean.getClass().getFields();

        for (Field field : fields) {
            if (PropertyUtils.isReadable(bean, field.getName())) {
                //To still work on
            }
        }

        return null;
    }
}
