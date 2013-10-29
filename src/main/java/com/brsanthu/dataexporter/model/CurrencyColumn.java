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
 * Currency column, which formats the given number with 2 digits precision and prefixes
 * the given currency symbol.
 * 
 * @author Santhosh Kumar
 *
 */
public class CurrencyColumn extends NumberColumn {
    
    private String currencySign;

    public CurrencyColumn(String name, String title, int width, String currencySign) {
        this(name, title, width, AlignType.MIDDLE_RIGHT, currencySign);
    }

    public CurrencyColumn(String name, int width, String currencySign) {
        this(name, null, width, AlignType.MIDDLE_RIGHT, currencySign);
    }

    public CurrencyColumn(String name, String title, int width, AlignType align, String currencySign) {
        super(name, title, width, align, 2);
        this.currencySign = currencySign;
    }
    public String getCurrencySign() {
        return currencySign;
    }

    public void setCurrencySign(String currencySign) {
        this.currencySign = currencySign;
    }
    
    @Override
    public int getMaxRowHeight(CellDetails cellDetails) {
        return super.getMaxRowHeight(currencySign + cellDetails.getCellValue());
    }
    
    @Override
    public String format(CellDetails cellDetails) {
        return currencySign + format(cellDetails.getCellValue());
    }
}
