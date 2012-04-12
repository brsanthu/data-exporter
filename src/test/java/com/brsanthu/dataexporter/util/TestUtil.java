package com.brsanthu.dataexporter.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestUtil {
    
    @Test
    public void testCheckForNotNull() throws Exception {
        try {
            Util.checkForNotNull(null, null);
            fail("Expected a exception");
        } catch (IllegalArgumentException e) {
            //all is well
        }
    }
}
