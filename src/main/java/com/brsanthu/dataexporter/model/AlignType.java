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

/**
 * Various alignment types.
 * 
 * @author Santhosh Kumar
 */
public enum AlignType {
    TOP_LEFT ("top", "left"),
    TOP_CENTER ("top", "center"),
    TOP_RIGHT ("top", "right"),
    MIDDLE_LEFT ("middle", "left"),
    MIDDLE_CENTER ("middle", "center"),
    MIDDLE_RIGHT ("middle", "right"),
    BOTTOM_LEFT ("bottom", "left"),
    BOTTOM_CENTER ("bottom", "center"),
    BOTTOM_RIGHT  ("bottom", "right");
    
    private String horAlign = null;
    private String verAlign = null;
    
	private AlignType(String verAlign, String horAlign) {
		this.verAlign = verAlign;
		this.horAlign = horAlign;
	}
    
    public String getHorizontalAlignment() {
    	return horAlign;
    }

    public String getVerticalAlignment() {
    	return verAlign;
    }
    
    public boolean isLeft() {
    	return horAlign.equals("left");
    }
    public boolean isCenter() {
    	return horAlign.equals("center");
    }
    public boolean isRight() {
    	return horAlign.equals("right");
    }
}
