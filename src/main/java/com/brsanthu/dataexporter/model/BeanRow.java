/*
 * #%L
 * data-exporter
 * %%
 * Copyright (C) 2012 - 2013 http://www.brsanthu.com
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
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
