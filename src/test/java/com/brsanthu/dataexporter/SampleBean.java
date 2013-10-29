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
