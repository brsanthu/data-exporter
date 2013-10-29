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

/**
 * Class to configure the text table style. This class offers extensive set of properties to configure
 * every aspect of text table. There are many pre-defined styles which you can use or customize from scratch
 * or over existing style to your needs. Note that pre-defined styles are static instnaces. So if you modify,
 * they would retain the changes till JVM restart.
 * <p>
 * Here are the available styles and their names.
 * 
 * <h2>CLASSIC</h2><pre>
 * +=====+=======================+==========+===============+==========+==========+==========+==========+
 * |Line |    Date Purchased     | Item No  |   Item Name   | Shipped? | Quantity |Unit Price|  Price   |
 * | No  |                       |          |               |          |          |          |          |
 * +=====+=======================+==========+===============+==========+==========+==========+==========+
 * |    1|2011/04/09 11:00:43 PM |         1|Laptop         |No        |         1|   $799.78|   $799.78|
 * |    2|2011/04/07 07:13:19 AM |         2|Mouse          |Yes       |         2|    $49.30|    $98.60|
 * |    3|2011/04/07 06:39:17 AM |         3|Keyboard       |No        |         5|    $75.00|   $375.00|
 * +=====+=======================+==========+===============+==========+==========+==========+==========+
 * </pre>
 * 
 * <h2>CLASSIC_SIMPLE</h2><pre>
 * +=====+=======================+==========+===============+==========+==========+==========+==========+
 * |Line |    Date Purchased     | Item No  |   Item Name   | Shipped? | Quantity |Unit Price|  Price   |
 * | No  |                       |          |               |          |          |          |          |
 * +=====+=======================+==========+===============+==========+==========+==========+==========+
 * |    1|2011/04/09 11:00:43 PM |         1|Laptop         |No        |         1|   $799.78|   $799.78|
 * |    2|2011/04/07 07:13:19 AM |         2|Mouse          |Yes       |         2|    $49.30|    $98.60|
 * |    3|2011/04/07 06:39:17 AM |         3|Keyboard       |No        |         5|    $75.00|   $375.00|
 * +=====+=======================+==========+===============+==========+==========+==========+==========+
 * </pre>
 * 
 * <h2>CLASSIC_NO_DIVIDER_NO_ROW</h2><pre>
 * +=====+=======================+==========+===============+==========+==========+==========+==========+
 *  Line      Date Purchased       Item No      Item Name     Shipped?   Quantity  Unit Price   Price    
 *   No                                                                                                  
 * +=====+=======================+==========+===============+==========+==========+==========+==========+
 *      1 2011/04/09 11:00:43 PM           1 Laptop          No                  1    $799.78    $799.78 
 *      2 2011/04/07 07:13:19 AM           2 Mouse           Yes                 2     $49.30     $98.60 
 *      3 2011/04/07 06:39:17 AM           3 Keyboard        No                  5     $75.00    $375.00 
 * +=====+=======================+==========+===============+==========+==========+==========+==========+
 * </pre>
 * 
 * <h2>CLASSIC_NO_DIVIDER</h2><pre>
 * +=====+=======================+==========+===============+==========+==========+==========+==========+
 *  Line      Date Purchased       Item No      Item Name     Shipped?   Quantity  Unit Price   Price    
 *   No                                                                                                  
 * +=====+=======================+==========+===============+==========+==========+==========+==========+
 *      1 2011/04/09 11:00:43 PM           1 Laptop          No                  1    $799.78    $799.78 
 *      2 2011/04/07 07:13:19 AM           2 Mouse           Yes                 2     $49.30     $98.60 
 *      3 2011/04/07 06:39:17 AM           3 Keyboard        No                  5     $75.00    $375.00 
 * +=====+=======================+==========+===============+==========+==========+==========+==========+
 * </pre>
 * 
 * <h2>HEAVY</h2><pre>
 * +=====+=======================+==========+===============+==========+==========+==========+==========+
 * |Line |    Date Purchased     | Item No  |   Item Name   | Shipped? | Quantity |Unit Price|  Price   |
 * | No  |                       |          |               |          |          |          |          |
 * +=====+=======================+==========+===============+==========+==========+==========+==========+
 * |    1|2011/04/09 11:00:43 PM |         1|Laptop         |No        |         1|   $799.78|   $799.78|
 * |    2|2011/04/07 07:13:19 AM |         2|Mouse          |Yes       |         2|    $49.30|    $98.60|
 * |    3|2011/04/07 06:39:17 AM |         3|Keyboard       |No        |         5|    $75.00|   $375.00|
 * +=====+=======================+==========+===============+==========+==========+==========+==========+
 * </pre>
 * 
 * <h2>DOUBLE_HEAVY</h2><pre>
 * ++=====++=======================++==========++===============++==========++==========++==========++==========++
 * ||Line ||    Date Purchased     || Item No  ||   Item Name   || Shipped? || Quantity ||Unit Price||  Price   ||
 * || No  ||                       ||          ||               ||          ||          ||          ||          ||
 * ++=====++=======================++==========++===============++==========++==========++==========++==========++
 * ||    1||2011/04/09 11:00:43 PM ||         1||Laptop         ||No        ||         1||   $799.78||   $799.78||
 * ||    2||2011/04/07 07:13:19 AM ||         2||Mouse          ||Yes       ||         2||    $49.30||    $98.60||
 * ||    3||2011/04/07 06:39:17 AM ||         3||Keyboard       ||No        ||         5||    $75.00||   $375.00||
 * ++=====++=======================++==========++===============++==========++==========++==========++==========++
 * </pre>
 * 
 * <h2>OO</h2><pre>
 * O=====O=======================O==========O===============O==========O==========O==========O==========O
 * |Line |    Date Purchased     | Item No  |   Item Name   | Shipped? | Quantity |Unit Price|  Price   |
 * | No  |                       |          |               |          |          |          |          |
 * O=====O=======================O==========O===============O==========O==========O==========O==========O
 * |    1|2011/04/09 11:00:43 PM |         1|Laptop         |No        |         1|   $799.78|   $799.78|
 * |    2|2011/04/07 07:13:19 AM |         2|Mouse          |Yes       |         2|    $49.30|    $98.60|
 * |    3|2011/04/07 06:39:17 AM |         3|Keyboard       |No        |         5|    $75.00|   $375.00|
 * O=====O=======================O==========O===============O==========O==========O==========O==========O
 * </pre>
 * 
 * <h2>BIG_OO</h2><pre>
 * O=====O=======================O==========O===============O==========O==========O==========O==========O
 * |Line |    Date Purchased     | Item No  |   Item Name   | Shipped? | Quantity |Unit Price|  Price   |
 * | No  |                       |          |               |          |          |          |          |
 * O=====O=======================O==========O===============O==========O==========O==========O==========O
 * |    1|2011/04/09 11:00:43 PM |         1|Laptop         |No        |         1|   $799.78|   $799.78|
 * |    2|2011/04/07 07:13:19 AM |         2|Mouse          |Yes       |         2|    $49.30|    $98.60|
 * |    3|2011/04/07 06:39:17 AM |         3|Keyboard       |No        |         5|    $75.00|   $375.00|
 * O=====O=======================O==========O===============O==========O==========O==========O==========O
 * </pre>
 * 
 * <h2>ZERO</h2><pre>
 * 0=====0=======================0==========0===============0==========0==========0==========0==========0
 * |Line |    Date Purchased     | Item No  |   Item Name   | Shipped? | Quantity |Unit Price|  Price   |
 * | No  |                       |          |               |          |          |          |          |
 * 0=====0=======================0==========0===============0==========0==========0==========0==========0
 * |    1|2011/04/09 11:00:43 PM |         1|Laptop         |No        |         1|   $799.78|   $799.78|
 * |    2|2011/04/07 07:13:19 AM |         2|Mouse          |Yes       |         2|    $49.30|    $98.60|
 * |    3|2011/04/07 06:39:17 AM |         3|Keyboard       |No        |         5|    $75.00|   $375.00|
 * 0=====0=======================0==========0===============0==========0==========0==========0==========0
 * </pre>
 * 
 * <h2>WEAVY</h2><pre>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * |Line |    Date Purchased     | Item No  |   Item Name   | Shipped? | Quantity |Unit Price|  Price   |
 * | No  |                       |          |               |          |          |          |          |
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * |    1|2011/04/09 11:00:43 PM |         1|Laptop         |No        |         1|   $799.78|   $799.78|
 * |    2|2011/04/07 07:13:19 AM |         2|Mouse          |Yes       |         2|    $49.30|    $98.60|
 * |    3|2011/04/07 06:39:17 AM |         3|Keyboard       |No        |         5|    $75.00|   $375.00|
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * </pre>
 * 
 * <h2>WEAVY_SIMPLE</h2><pre>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * |Line |    Date Purchased     | Item No  |   Item Name   | Shipped? | Quantity |Unit Price|  Price   |
 * | No  |                       |          |               |          |          |          |          |
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * |    1|2011/04/09 11:00:43 PM |         1|Laptop         |No        |         1|   $799.78|   $799.78|
 * |    2|2011/04/07 07:13:19 AM |         2|Mouse          |Yes       |         2|    $49.30|    $98.60|
 * |    3|2011/04/07 06:39:17 AM |         3|Keyboard       |No        |         5|    $75.00|   $375.00|
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * </pre>
 * 
 * <h2>DOTS</h2><pre>
 * ......................................................................................................
 * |Line |    Date Purchased     | Item No  |   Item Name   | Shipped? | Quantity |Unit Price|  Price   |
 * | No  |                       |          |               |          |          |          |          |
 * ......................................................................................................
 * |    1|2011/04/09 11:00:43 PM |         1|Laptop         |No        |         1|   $799.78|   $799.78|
 * |    2|2011/04/07 07:13:19 AM |         2|Mouse          |Yes       |         2|    $49.30|    $98.60|
 * |    3|2011/04/07 06:39:17 AM |         3|Keyboard       |No        |         5|    $75.00|   $375.00|
 * ......................................................................................................
 * </pre>
 * 
 * <h2>DOTS_SIMPLE</h2><pre>
 * ......................................................................................................
 * |Line |    Date Purchased     | Item No  |   Item Name   | Shipped? | Quantity |Unit Price|  Price   |
 * | No  |                       |          |               |          |          |          |          |
 * ......................................................................................................
 * |    1|2011/04/09 11:00:43 PM |         1|Laptop         |No        |         1|   $799.78|   $799.78|
 * |    2|2011/04/07 07:13:19 AM |         2|Mouse          |Yes       |         2|    $49.30|    $98.60|
 * |    3|2011/04/07 06:39:17 AM |         3|Keyboard       |No        |         5|    $75.00|   $375.00|
 * ......................................................................................................
 * </pre>
 * 
 * <h2>QUOTED</h2><pre>
 * &quot;=====&quot;=======================&quot;==========&quot;===============&quot;==========&quot;==========&quot;==========&quot;==========&quot;
 * |Line |    Date Purchased     | Item No  |   Item Name   | Shipped? | Quantity |Unit Price|  Price   |
 * | No  |                       |          |               |          |          |          |          |
 * &quot;=====&quot;=======================&quot;==========&quot;===============&quot;==========&quot;==========&quot;==========&quot;==========&quot;
 * |    1|2011/04/09 11:00:43 PM |         1|Laptop         |No        |         1|   $799.78|   $799.78|
 * |    2|2011/04/07 07:13:19 AM |         2|Mouse          |Yes       |         2|    $49.30|    $98.60|
 * |    3|2011/04/07 06:39:17 AM |         3|Keyboard       |No        |         5|    $75.00|   $375.00|
 * &quot;=====&quot;=======================&quot;==========&quot;===============&quot;==========&quot;==========&quot;==========&quot;==========&quot;
 * </pre>
 * 
 * <h2>QUOTED_SIMPLE</h2><pre>
 * &quot;=====&quot;=======================&quot;==========&quot;===============&quot;==========&quot;==========&quot;==========&quot;==========&quot;
 * |Line |    Date Purchased     | Item No  |   Item Name   | Shipped? | Quantity |Unit Price|  Price   |
 * | No  |                       |          |               |          |          |          |          |
 * &quot;=====&quot;=======================&quot;==========&quot;===============&quot;==========&quot;==========&quot;==========&quot;==========&quot;
 * |    1|2011/04/09 11:00:43 PM |         1|Laptop         |No        |         1|   $799.78|   $799.78|
 * |    2|2011/04/07 07:13:19 AM |         2|Mouse          |Yes       |         2|    $49.30|    $98.60|
 * |    3|2011/04/07 06:39:17 AM |         3|Keyboard       |No        |         5|    $75.00|   $375.00|
 * &quot;=====&quot;=======================&quot;==========&quot;===============&quot;==========&quot;==========&quot;==========&quot;==========&quot;
 * </pre>
 * 
 * <h2>ANGLES</h2><pre>
 * &lt;-&gt;=====&lt;-&gt;=======================&lt;-&gt;==========&lt;-&gt;===============&lt;-&gt;==========&lt;-&gt;==========&lt;-&gt;==========&lt;-&gt;==========&lt;-&gt;
 *  | Line  |     Date Purchased      |  Item No   |    Item Name    |  Shipped?  |  Quantity  | Unit Price |   Price    | 
 *  |  No   |                         |            |                 |            |            |            |            | 
 * &lt;-&gt;=====&lt;-&gt;=======================&lt;-&gt;==========&lt;-&gt;===============&lt;-&gt;==========&lt;-&gt;==========&lt;-&gt;==========&lt;-&gt;==========&lt;-&gt;
 *  |     1 | 2011/04/09 11:00:43 PM  |          1 | Laptop          | No         |          1 |    $799.78 |    $799.78 | 
 *  |     2 | 2011/04/07 07:13:19 AM  |          2 | Mouse           | Yes        |          2 |     $49.30 |     $98.60 | 
 *  |     3 | 2011/04/07 06:39:17 AM  |          3 | Keyboard        | No         |          5 |     $75.00 |    $375.00 | 
 * &lt;-&gt;=====&lt;-&gt;=======================&lt;-&gt;==========&lt;-&gt;===============&lt;-&gt;==========&lt;-&gt;==========&lt;-&gt;==========&lt;-&gt;==========&lt;-&gt;
 * </pre>
 * 
 * <h2>TEST</h2><pre>
 * #=====#=======================#==========#===============#==========#==========#==========#==========#
 * |Line |    Date Purchased     | Item No  |   Item Name   | Shipped? | Quantity |Unit Price|  Price   |
 * | No  |                       |          |               |          |          |          |          |
 * #=====#=======================#==========#===============#==========#==========#==========#==========#
 * |    1|2011/04/09 11:00:43 PM |         1|Laptop         |No        |         1|   $799.78|   $799.78|
 * |    2|2011/04/07 07:13:19 AM |         2|Mouse          |Yes       |         2|    $49.30|    $98.60|
 * |    3|2011/04/07 06:39:17 AM |         3|Keyboard       |No        |         5|    $75.00|   $375.00|
 * #=====#=======================#==========#===============#==========#==========#==========#==========#
 * </pre>
 * 
 *  @author Santhosh Kumar
 */
public class TextTableExportStyle {
    
    public static TextTableExportStyle CLASSIC = new TextTableExportStyle("+", "=", "-", "|");
    public static TextTableExportStyle CLASSIC_SIMPLE = new TextTableExportStyle("+", "", "=", "", "|", "|");
    public static TextTableExportStyle CLASSIC_NO_DIVIDER_NO_ROW = new TextTableExportStyle("+", "", "=", "", " ", " ");
    public static TextTableExportStyle CLASSIC_NO_DIVIDER = new TextTableExportStyle("+", "+", "=", "-", " ", " ");
    public static TextTableExportStyle HEAVY = new TextTableExportStyle("+", "+", "=", "=", "|", "|");
    public static TextTableExportStyle DOUBLE_HEAVY = new TextTableExportStyle("++", "++", "=", "=", "||", "||");
    public static TextTableExportStyle OO = new TextTableExportStyle("O", "o", "=", "-", "|", "|");
    public static TextTableExportStyle BIG_OO = new TextTableExportStyle("O", "O", "=", "-", "|", "|");
    public static TextTableExportStyle ZERO = new TextTableExportStyle("0", "0", "=", "-", "|", "|");
    public static TextTableExportStyle WEAVY = new TextTableExportStyle("~", "~", "~", "~", "|", "|");
    public static TextTableExportStyle WEAVY_SIMPLE = new TextTableExportStyle("~", "", "~", "", "|", "|");
    public static TextTableExportStyle DOTS = new TextTableExportStyle(".", ".", ".", ".", "|", "|");
    public static TextTableExportStyle DOTS_SIMPLE = new TextTableExportStyle(".", "", ".", "", "|", "|");
    public static TextTableExportStyle QUOTED = new TextTableExportStyle("\"", "'", "=", "-", "|", "|");
    public static TextTableExportStyle QUOTED_SIMPLE = new TextTableExportStyle("\"", "", "=", "", "|", "|");
    public static TextTableExportStyle ANGLES = new TextTableExportStyle("<->", "", "=", "", " | ", " | ");
    public static TextTableExportStyle TEST = new TextTableExportStyle("#", "", "=", "", "|", "|");
    
    private String topLeftIntersection = null;
    private String topLeftRightIntersection = null;
    private String topCenterIntersection = null;
    private String topRightLeftIntersection = null;
    private String topRightIntersection = null;
    
    private String topDownLeftIntersection = null;
    private String topDownLeftRightIntersection = null;
    private String topDownCenterIntersection = null;
    private String topDownRightLeftIntersection = null;
    private String topDownRightIntersection = null;
    
    private String centerLeftIntersection = null;
    private String centerLeftRightIntersection = null;
    private String centerCenterIntersection = null;
    private String centerRightLeftIntersection = null;
    private String centerRightIntersection = null;
    
    private String bottomUpLeftIntersection = null;
    private String bottomUpLeftRightIntersection = null;
    private String bottomUpCenterIntersection = null;
    private String bottomUpRightLeftIntersection = null;
    private String bottomUpRightIntersection = null;
    
    private String bottomLeftIntersection = null;
    private String bottomLeftRightIntersection = null;
    private String bottomCenterIntersection = null;
    private String bottomRightLeftIntersection = null;
    private String bottomRightIntersection = null;
    
    private String topBorder = null;
    private String topDownBorder = null;
    private String centerBorder = null;
    private String bottomUpBorder = null;
    private String bottomBorder = null;
    
    private String topLeftDivider = null;
    private String topLeftRightDivider = null;
    private String topCenterDivider = null;
    private String topRightLeftDivider = null;
    private String topRightDivider = null;
    
    private String centerLeftDivider = null;
    private String centerLeftRightDivider = null;
    private String centerCenterDivider = null;
    private String centerRightLeftDivider = null;
    private String centerRightDivider = null;
    
    private String bottomLeftDivider = null;
    private String bottomLeftRightDivider = null;
    private String bottomCenterDivider = null;
    private String bottomRightLeftDivider = null;
    private String bottomRightDivider = null;

    public TextTableExportStyle(String headerFooterIntersection, String rowIntersection, String headerFooterBorder, 
                    String rowBorder, String headerFooterDividers, String rowDividers) {
        this(headerFooterIntersection, headerFooterIntersection, headerFooterIntersection, headerFooterIntersection, headerFooterIntersection
            , headerFooterIntersection, headerFooterIntersection, headerFooterIntersection, headerFooterIntersection, headerFooterIntersection
            , rowIntersection, rowIntersection, rowIntersection, rowIntersection, rowIntersection
            , headerFooterIntersection, headerFooterIntersection, headerFooterIntersection, headerFooterIntersection, headerFooterIntersection
            , headerFooterIntersection, headerFooterIntersection, headerFooterIntersection, headerFooterIntersection, headerFooterIntersection
            , headerFooterBorder, headerFooterBorder, rowBorder, headerFooterBorder, headerFooterBorder
            , headerFooterDividers, headerFooterDividers, headerFooterDividers, headerFooterDividers, headerFooterDividers
            , rowDividers, rowDividers, rowDividers, rowDividers, rowDividers
            , headerFooterDividers, headerFooterDividers, headerFooterDividers, headerFooterDividers, headerFooterDividers);
    }

    public TextTableExportStyle(String allIntersections, String headerFooterBorder, String rowBorder, String allCellDividers) {
        this(allIntersections, allIntersections, allIntersections, allIntersections, allIntersections
            , allIntersections, allIntersections, allIntersections, allIntersections, allIntersections
            , allIntersections, allIntersections, allIntersections, allIntersections, allIntersections
            , allIntersections, allIntersections, allIntersections, allIntersections, allIntersections
            , allIntersections, allIntersections, allIntersections, allIntersections, allIntersections
            , headerFooterBorder, headerFooterBorder, rowBorder, headerFooterBorder, headerFooterBorder
            , allCellDividers, allCellDividers, allCellDividers, allCellDividers, allCellDividers
            , allCellDividers, allCellDividers, allCellDividers, allCellDividers, allCellDividers
            , allCellDividers, allCellDividers, allCellDividers, allCellDividers, allCellDividers);
    }

    public TextTableExportStyle(String topLeftIntersection, String topLeftRightIntersection,
                    String topCenterIntersection, String topRightLeftIntersection,
                    String topRightIntersection, String topDownLeftIntersection,
                    String topDownLeftRightIntersection, String topDownCenterIntersection,
                    String topDownRightLeftIntersection, String topDownRightIntersection,
                    String centerLeftIntersection, String centerLeftRightIntersection,
                    String centerCenterIntersection, String centerRightLeftIntersection,
                    String centerRightIntersection, String bottomUpLeftIntersection,
                    String bottomUpLeftRightIntersection, String bottomUpCenterIntersection,
                    String bottomUpRightLeftIntersection, String bottomUpRightIntersection,
                    String bottomLeftIntersection, String bottomLeftRightIntersection,
                    String bottomCenterIntersection, String bottomRightLeftIntersection,
                    String bottomRightIntersection, String topBorder, String topDownBorder,
                    String centerBorder, String bottomUpBorder, String bottomBorder,
                    String topLeftDivider, String topLeftRightDivider, String topCenterDivider,
                    String topRightLeftDivider, String topRightDivider, String centerLeftDivider,
                    String centerLeftRightDivider, String centerCenterDivider,
                    String centerRightLeftDivider, String centerRightDivider,
                    String bottomLeftDivider, String bottomLeftRightDivider,
                    String bottomCenterDivider, String bottomRightLeftDivider,
                    String bottomRightDivider) {
        super();
        this.topLeftIntersection = topLeftIntersection;
        this.topLeftRightIntersection = topLeftRightIntersection;
        this.topCenterIntersection = topCenterIntersection;
        this.topRightLeftIntersection = topRightLeftIntersection;
        this.topRightIntersection = topRightIntersection;
        this.topDownLeftIntersection = topDownLeftIntersection;
        this.topDownLeftRightIntersection = topDownLeftRightIntersection;
        this.topDownCenterIntersection = topDownCenterIntersection;
        this.topDownRightLeftIntersection = topDownRightLeftIntersection;
        this.topDownRightIntersection = topDownRightIntersection;
        this.centerLeftIntersection = centerLeftIntersection;
        this.centerLeftRightIntersection = centerLeftRightIntersection;
        this.centerCenterIntersection = centerCenterIntersection;
        this.centerRightLeftIntersection = centerRightLeftIntersection;
        this.centerRightIntersection = centerRightIntersection;
        this.bottomUpLeftIntersection = bottomUpLeftIntersection;
        this.bottomUpLeftRightIntersection = bottomUpLeftRightIntersection;
        this.bottomUpCenterIntersection = bottomUpCenterIntersection;
        this.bottomUpRightLeftIntersection = bottomUpRightLeftIntersection;
        this.bottomUpRightIntersection = bottomUpRightIntersection;
        this.bottomLeftIntersection = bottomLeftIntersection;
        this.bottomLeftRightIntersection = bottomLeftRightIntersection;
        this.bottomCenterIntersection = bottomCenterIntersection;
        this.bottomRightLeftIntersection = bottomRightLeftIntersection;
        this.bottomRightIntersection = bottomRightIntersection;
        this.topBorder = topBorder;
        this.topDownBorder = topDownBorder;
        this.centerBorder = centerBorder;
        this.bottomUpBorder = bottomUpBorder;
        this.bottomBorder = bottomBorder;
        this.topLeftDivider = topLeftDivider;
        this.topLeftRightDivider = topLeftRightDivider;
        this.topCenterDivider = topCenterDivider;
        this.topRightLeftDivider = topRightLeftDivider;
        this.topRightDivider = topRightDivider;
        this.centerLeftDivider = centerLeftDivider;
        this.centerLeftRightDivider = centerLeftRightDivider;
        this.centerCenterDivider = centerCenterDivider;
        this.centerRightLeftDivider = centerRightLeftDivider;
        this.centerRightDivider = centerRightDivider;
        this.bottomLeftDivider = bottomLeftDivider;
        this.bottomLeftRightDivider = bottomLeftRightDivider;
        this.bottomCenterDivider = bottomCenterDivider;
        this.bottomRightLeftDivider = bottomRightLeftDivider;
        this.bottomRightDivider = bottomRightDivider;
    }

    public String getTopLeftIntersection() {
        return topLeftIntersection;
    }

    public void setTopLeftIntersection(String topLeftIntersection) {
        this.topLeftIntersection = topLeftIntersection;
    }

    public String getTopLeftRightIntersection() {
        return topLeftRightIntersection;
    }

    public void setTopLeftRightIntersection(String topLeftRightIntersection) {
        this.topLeftRightIntersection = topLeftRightIntersection;
    }

    public String getTopCenterIntersection() {
        return topCenterIntersection;
    }

    public void setTopCenterIntersection(String topCenterIntersection) {
        this.topCenterIntersection = topCenterIntersection;
    }

    public String getTopRightLeftIntersection() {
        return topRightLeftIntersection;
    }

    public void setTopRightLeftIntersection(String topRightLeftIntersection) {
        this.topRightLeftIntersection = topRightLeftIntersection;
    }

    public String getTopRightIntersection() {
        return topRightIntersection;
    }

    public void setTopRightIntersection(String topRightIntersection) {
        this.topRightIntersection = topRightIntersection;
    }

    public String getTopDownLeftIntersection() {
        return topDownLeftIntersection;
    }

    public void setTopDownLeftIntersection(String topDownLeftIntersection) {
        this.topDownLeftIntersection = topDownLeftIntersection;
    }

    public String getTopDownLeftRightIntersection() {
        return topDownLeftRightIntersection;
    }

    public void setTopDownLeftRightIntersection(String topDownLeftRightIntersection) {
        this.topDownLeftRightIntersection = topDownLeftRightIntersection;
    }

    public String getTopDownCenterIntersection() {
        return topDownCenterIntersection;
    }

    public void setTopDownCenterIntersection(String topDownCenterIntersection) {
        this.topDownCenterIntersection = topDownCenterIntersection;
    }

    public String getTopDownRightLeftIntersection() {
        return topDownRightLeftIntersection;
    }

    public void setTopDownRightLeftIntersection(String topDownRightLeftIntersection) {
        this.topDownRightLeftIntersection = topDownRightLeftIntersection;
    }

    public String getTopDownRightIntersection() {
        return topDownRightIntersection;
    }

    public void setTopDownRightIntersection(String topDownRightIntersection) {
        this.topDownRightIntersection = topDownRightIntersection;
    }

    public String getCenterLeftIntersection() {
        return centerLeftIntersection;
    }

    public void setCenterLeftIntersection(String centerLeftIntersection) {
        this.centerLeftIntersection = centerLeftIntersection;
    }

    public String getCenterLeftRightIntersection() {
        return centerLeftRightIntersection;
    }

    public void setCenterLeftRightIntersection(String centerLeftRightIntersection) {
        this.centerLeftRightIntersection = centerLeftRightIntersection;
    }

    public String getCenterCenterIntersection() {
        return centerCenterIntersection;
    }

    public void setCenterCenterIntersection(String centerCenterIntersection) {
        this.centerCenterIntersection = centerCenterIntersection;
    }

    public String getCenterRightLeftIntersection() {
        return centerRightLeftIntersection;
    }

    public void setCenterRightLeftIntersection(String centerRightLeftIntersection) {
        this.centerRightLeftIntersection = centerRightLeftIntersection;
    }

    public String getCenterRightIntersection() {
        return centerRightIntersection;
    }

    public void setCenterRightIntersection(String centerRightIntersection) {
        this.centerRightIntersection = centerRightIntersection;
    }

    public String getBottomUpLeftIntersection() {
        return bottomUpLeftIntersection;
    }

    public void setBottomUpLeftIntersection(String bottomUpLeftIntersection) {
        this.bottomUpLeftIntersection = bottomUpLeftIntersection;
    }

    public String getBottomUpLeftRightIntersection() {
        return bottomUpLeftRightIntersection;
    }

    public void setBottomUpLeftRightIntersection(String bottomUpLeftRightIntersection) {
        this.bottomUpLeftRightIntersection = bottomUpLeftRightIntersection;
    }

    public String getBottomUpCenterIntersection() {
        return bottomUpCenterIntersection;
    }

    public void setBottomUpCenterIntersection(String bottomUpCenterIntersection) {
        this.bottomUpCenterIntersection = bottomUpCenterIntersection;
    }

    public String getBottomUpRightLeftIntersection() {
        return bottomUpRightLeftIntersection;
    }

    public void setBottomUpRightLeftIntersection(String bottomUpRightLeftIntersection) {
        this.bottomUpRightLeftIntersection = bottomUpRightLeftIntersection;
    }

    public String getBottomUpRightIntersection() {
        return bottomUpRightIntersection;
    }

    public void setBottomUpRightIntersection(String bottomUpRightIntersection) {
        this.bottomUpRightIntersection = bottomUpRightIntersection;
    }

    public String getBottomLeftIntersection() {
        return bottomLeftIntersection;
    }

    public void setBottomLeftIntersection(String bottomLeftIntersection) {
        this.bottomLeftIntersection = bottomLeftIntersection;
    }

    public String getBottomLeftRightIntersection() {
        return bottomLeftRightIntersection;
    }

    public void setBottomLeftRightIntersection(String bottomLeftRightIntersection) {
        this.bottomLeftRightIntersection = bottomLeftRightIntersection;
    }

    public String getBottomCenterIntersection() {
        return bottomCenterIntersection;
    }

    public void setBottomCenterIntersection(String bottomCenterIntersection) {
        this.bottomCenterIntersection = bottomCenterIntersection;
    }

    public String getBottomRightLeftIntersection() {
        return bottomRightLeftIntersection;
    }

    public void setBottomRightLeftIntersection(String bottomRightLeftIntersection) {
        this.bottomRightLeftIntersection = bottomRightLeftIntersection;
    }

    public String getBottomRightIntersection() {
        return bottomRightIntersection;
    }

    public void setBottomRightIntersection(String bottomRightIntersection) {
        this.bottomRightIntersection = bottomRightIntersection;
    }

    public String getTopBorder() {
        return topBorder;
    }

    public void setTopBorder(String topBorder) {
        this.topBorder = topBorder;
    }

    public String getTopDownBorder() {
        return topDownBorder;
    }

    public void setTopDownBorder(String topDownBorder) {
        this.topDownBorder = topDownBorder;
    }

    public String getCenterBorder() {
        return centerBorder;
    }

    public void setCenterBorder(String centerBorder) {
        this.centerBorder = centerBorder;
    }

    public String getBottomUpBorder() {
        return bottomUpBorder;
    }

    public void setBottomUpBorder(String bottomUpBorder) {
        this.bottomUpBorder = bottomUpBorder;
    }

    public String getBottomBorder() {
        return bottomBorder;
    }

    public void setBottomBorder(String bottomBorder) {
        this.bottomBorder = bottomBorder;
    }

    public String getTopLeftDivider() {
        return topLeftDivider;
    }

    public void setTopLeftDivider(String topLeftDivider) {
        this.topLeftDivider = topLeftDivider;
    }

    public String getTopLeftRightDivider() {
        return topLeftRightDivider;
    }

    public void setTopLeftRightDivider(String topLeftRightDivider) {
        this.topLeftRightDivider = topLeftRightDivider;
    }

    public String getTopCenterDivider() {
        return topCenterDivider;
    }

    public void setTopCenterDivider(String topCenterDivider) {
        this.topCenterDivider = topCenterDivider;
    }

    public String getTopRightLeftDivider() {
        return topRightLeftDivider;
    }

    public void setTopRightLeftDivider(String topRightLeftDivider) {
        this.topRightLeftDivider = topRightLeftDivider;
    }

    public String getTopRightDivider() {
        return topRightDivider;
    }

    public void setTopRightDivider(String topRightDivider) {
        this.topRightDivider = topRightDivider;
    }

    public String getCenterLeftDivider() {
        return centerLeftDivider;
    }

    public void setCenterLeftDivider(String centerLeftDivider) {
        this.centerLeftDivider = centerLeftDivider;
    }

    public String getCenterLeftRightDivider() {
        return centerLeftRightDivider;
    }

    public void setCenterLeftRightDivider(String centerLeftRightDivider) {
        this.centerLeftRightDivider = centerLeftRightDivider;
    }

    public String getCenterCenterDivider() {
        return centerCenterDivider;
    }

    public void setCenterCenterDivider(String centerCenterDivider) {
        this.centerCenterDivider = centerCenterDivider;
    }

    public String getCenterRightLeftDivider() {
        return centerRightLeftDivider;
    }

    public void setCenterRightLeftDivider(String centerRightLeftDivider) {
        this.centerRightLeftDivider = centerRightLeftDivider;
    }

    public String getCenterRightDivider() {
        return centerRightDivider;
    }

    public void setCenterRightDivider(String centerRightDivider) {
        this.centerRightDivider = centerRightDivider;
    }

    public String getBottomLeftDivider() {
        return bottomLeftDivider;
    }

    public void setBottomLeftDivider(String bottomLeftDivider) {
        this.bottomLeftDivider = bottomLeftDivider;
    }

    public String getBottomLeftRightDivider() {
        return bottomLeftRightDivider;
    }

    public void setBottomLeftRightDivider(String bottomLeftRightDivider) {
        this.bottomLeftRightDivider = bottomLeftRightDivider;
    }

    public String getBottomCenterDivider() {
        return bottomCenterDivider;
    }

    public void setBottomCenterDivider(String bottomCenterDivider) {
        this.bottomCenterDivider = bottomCenterDivider;
    }

    public String getBottomRightLeftDivider() {
        return bottomRightLeftDivider;
    }

    public void setBottomRightLeftDivider(String bottomRightLeftDivider) {
        this.bottomRightLeftDivider = bottomRightLeftDivider;
    }

    public String getBottomRightDivider() {
        return bottomRightDivider;
    }

    public void setBottomRightDivider(String bottomRightDivider) {
        this.bottomRightDivider = bottomRightDivider;
    }
}
