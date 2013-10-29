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
