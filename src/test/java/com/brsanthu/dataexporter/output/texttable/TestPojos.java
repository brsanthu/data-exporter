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
package com.brsanthu.dataexporter.output.texttable;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.PojoClassFilter;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.PojoValidator;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;

public class TestPojos {
    // The package to test
    private static final String POJO_PACKAGE = TestPojos.class.getPackage().getName();

    private List<PojoClass> pojoClasses;
    private PojoValidator pojoValidator;

    @Before
    public void setup() {
        pojoClasses = PojoClassFactory.getPojoClasses(POJO_PACKAGE, new PojoClassFilter() {
            
            @Override
            public boolean include(PojoClass pojoClass) {
                System.out.println(pojoClass.getName());
                return pojoClass.getName().endsWith("Style");
            }
        });

        pojoValidator = new PojoValidator();

        // Create Testers to validate behavior for POJO_PACKAGE
        pojoValidator.addTester(new SetterTester());
        pojoValidator.addTester(new GetterTester());
    }
    
    @Test
    public void testPojos() {
        for (PojoClass pojoClass : pojoClasses) {
            pojoValidator.runValidation(pojoClass);
        }
    }
}
