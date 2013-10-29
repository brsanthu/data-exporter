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
package com.brsanthu.dataexporter.util;


/**
 * Utility class to be used internally by the formatter.
 * 
 * @author Santhosh Kumar
 */
public class Util {
    
    public static String createSpacer(int length) {
        return createString(" ", length);
    }
    
    public static String createString(String chr, int length) {
        if (length <= 0) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        while(sb.length() < length) {
            sb.append(chr);
        }
        
        return sb.toString().substring(0, length);
    }
    
    /**
     * Checks the specified object for not null and throws IllegalArgumentException if it is
     * null. Message reads <code>The parameter {name} cannot be null</code>
     * 
     * @param object - object to be checked for not-null
     * @param name - parameter name to be included in the message
     * 
     * @throws NullPointerException if object is null
     */
    public static void checkForNotNull(Object object, String name) {
        if (object == null) {
            throw new IllegalArgumentException("The parameter '" + name + "' cannot be null");
        }
    }
}
