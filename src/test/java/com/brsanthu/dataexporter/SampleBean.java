package com.brsanthu.dataexporter;

import java.util.Date;

public class SampleBean {

    private Date datePurchased = null;
    private int itemNo = 0;
    private String itemName = null;
    private boolean shipped = false;
    private int quantity = 0;
    private double unitPrice = 0.0;
    public SampleBean(Date datePurchased, int itemNum, String itemName, boolean shipped,
                    int quantity, double unitPrice) {
        super();
        this.datePurchased = datePurchased;
        this.itemNo = itemNum;
        this.itemName = itemName;
        this.shipped = shipped;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }
    public Date getDatePurchased() {
        return datePurchased;
    }
    public void setDatePurchased(Date datePurchased) {
        this.datePurchased = datePurchased;
    }
    public int getItemNo() {
        return itemNo;
    }
    public void setItemNo(int itemNum) {
        this.itemNo = itemNum;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public boolean isShipped() {
        return shipped;
    }
    public void setShipped(boolean shipped) {
        this.shipped = shipped;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    
    
}
