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
