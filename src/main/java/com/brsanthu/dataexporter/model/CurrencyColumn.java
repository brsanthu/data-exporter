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
