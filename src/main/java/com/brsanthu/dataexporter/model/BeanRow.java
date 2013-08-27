package com.brsanthu.dataexporter.model;

import org.apache.commons.beanutils.PropertyUtils;

import com.brsanthu.dataexporter.DataExportException;

public class BeanRow extends Row {
    
    private Object bean = null;
    
    public BeanRow(Object bean) {
        super();
        this.bean = bean;
    }

    public Object getCellValue(String columnName) {
        try {
            return PropertyUtils.getProperty(bean, columnName);
        } catch (Exception e) {
            throw new DataExportException("Exception while reading the property " + columnName 
                + " from bean " + bean +  " of type " + bean.getClass().getName(), e);
        }
    }
    
    public Object getBean() {
		return bean;
	}
}
