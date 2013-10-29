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
