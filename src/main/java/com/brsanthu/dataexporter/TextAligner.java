package com.brsanthu.dataexporter;

import java.util.ArrayList;
import java.util.List;

import com.brsanthu.dataexporter.model.AlignType;
import com.brsanthu.dataexporter.util.Util;

/**
 * Class used to align the text according to different alignment modes. This is completely independent
 * class and can be used in other applications. Sample usage is shown below.
 * 
 * <pre>
 *     public static void main(String[] args) {
 *         TextAligner textAligner = new TextAligner();
 *         for (AlignType align : AlignType.values()) {
 *             
 *             System.out.println("&lt;h1&gt;" + align.toString() + "&lt;/h1&gt;");
 *             List&lt;String&gt; list = (textAligner.align(15, 10, align, "Hello world is the common phrase used everywhere. In this sentense somewordsarereallyreallybig ones."));
 *             for (String string : list) {
 *                 System.out.println("|" + string + "|");
 *             }
 *             System.out.println("");
 *         }
 *     }
 * </pre>
 * which produces the following output
 * <pre>
 * <h1>TOP_LEFT</h1>
 * |Hello world is |
 * |the common     |
 * |phrase used    |
 * |everywhere. In |
 * |this sentense  |
 * |somewordsarerea|
 * |llyreallybig   |
 * |ones.          |
 * |               |
 * |               |
 * 
 * <h1>TOP_CENTER</h1>
 * |Hello world is |
 * |  the common   |
 * |  phrase used  |
 * |everywhere. In |
 * | this sentense |
 * |somewordsarerea|
 * | llyreallybig  |
 * |     ones.     |
 * |               |
 * |               |
 * 
 * <h1>TOP_RIGHT</h1>
 * | Hello world is|
 * |     the common|
 * |    phrase used|
 * | everywhere. In|
 * |  this sentense|
 * |somewordsarerea|
 * |   llyreallybig|
 * |          ones.|
 * |               |
 * |               |
 * 
 * <h1>MIDDLE_LEFT</h1>
 * |               |
 * |Hello world    |
 * |is the common  |
 * |phrase used    |
 * |everywhere.    |
 * |In this sentense|
 * |somewordsarerea|
 * |llyreallybig   |
 * |ones.          |
 * |               |
 * 
 * <h1>MIDDLE_CENTER</h1>
 * |               |
 * |  Hello world  |
 * | is the common |
 * |  phrase used  |
 * |  everywhere.  |
 * |In this sentense|
 * |somewordsarerea|
 * | llyreallybig  |
 * |     ones.     |
 * |               |
 * 
 * <h1>MIDDLE_RIGHT</h1>
 * |               |
 * |    Hello world|
 * |  is the common|
 * |    phrase used|
 * |    everywhere.|
 * |In this sentense|
 * |somewordsarerea|
 * |   llyreallybig|
 * |          ones.|
 * |               |
 * 
 * <h1>BOTTOM_LEFT</h1>
 * |               |
 * |               |
 * |Hello world    |
 * |is the common  |
 * |phrase used    |
 * |everywhere. In |
 * |this sentense  |
 * |somewordsarerea|
 * |llyreallybig   |
 * |ones.          |
 * 
 * <h1>BOTTOM_CENTER</h1>
 * |               |
 * |               |
 * |  Hello world  |
 * | is the common |
 * |  phrase used  |
 * |everywhere. In |
 * | this sentense |
 * |somewordsarerea|
 * | llyreallybig  |
 * |     ones.     |
 * 
 * <h1>BOTTOM_RIGHT</h1>
 * |               |
 * |               |
 * |    Hello world|
 * |  is the common|
 * |    phrase used|
 * | everywhere. In|
 * |  this sentense|
 * |somewordsarerea|
 * |   llyreallybig|
 * |          ones.|
 * 
 * </pre>
 * @author Santhosh Kumar
 */
public class TextAligner {
    
    /**
     * Aligns the given text according to requested alignment and returns the list of strings.
     * 
     * @param width width of the cell. Cannot be less than 0
     * @param height height of the cell. Cannot be less than 0
     * @param align alignment mode. 
     * @param data string data to be aligned. Can be null and if so, assumed empty.
     * 
     * @return returns the ArrayList of Strings, corresponding to aligned lines.
     */
    public List<String> align(int width, int height, AlignType align, String data) {
    	return align(width, height, align, data, " ");
    }

	public List<String> align(int width, int height, AlignType align, String data, String space) {
        
        if (height <= 0 || width <= 0) {
            throw new IllegalArgumentException("Height or width cannot be less than or equal to zero.");
        }
        
        if (align == null) {
            throw new IllegalArgumentException("Parameter align cannot be null");
        }
        
        if (data == null) {
            data = "";
        } else {
            //data = data.trim();
        }
        
        int totalChars = width * height;
        if (data.length() > totalChars) {
            throw new IllegalArgumentException("Data given (" + data.length() 
                + " chars) is bigger than cell size of " + totalChars + " chars (width " + width + " x height " 
                + height + ")");
        }
        
        //Split at the word boundary
        String[] words = data.split("\\s");
        
        //Check if any word is bigger than the width. If so, split into multiple words.
        List<String> wordsFinal = new ArrayList<String>();
        for (String word : words) {
            if (word.trim().length() >= width) {
                wordsFinal.addAll(splitWord(word, width));
            } else {
                wordsFinal.add(word.trim());
            }
        }
        
        List<String> compacted = new ArrayList<String>();
        //If number of words are larger than height, compact to at least height.
        //Compacting happens starting at top, middle or bottom as requested
        StringBuilder sb = new StringBuilder();
        int numerOfFillers = 0;
        
        switch (align) {
            case TOP_LEFT:
            case TOP_CENTER:
            case TOP_RIGHT:
                for (int i = 0; i < wordsFinal.size(); i++) {
                    //See if this word could be joined with previous string and still fits
                    //in the width
                    if (sb.length() + wordsFinal.get(i).length() <= width) {
                        if (sb.length() > 0) {
                            sb.append(" ");
                        }
                        sb.append(wordsFinal.get(i));
                    } else {
                        compacted.add(sb.toString());
                        sb = new StringBuilder();
                        sb.append(wordsFinal.get(i));
                    }
                }
                if (sb.length() > 0) {
                   compacted.add(sb.toString());
                }

                //We may need to add filler lines at the end of the list.
                numerOfFillers = height - compacted.size();
                for (int i = 0; i < numerOfFillers; i++) {
                    compacted.add("");
                }
                break;
                
            case MIDDLE_LEFT:
            case MIDDLE_CENTER:
            case MIDDLE_RIGHT:
                
                //Compact mid way towards beginning
                int midwayIndex = (int) Math.ceil((float) wordsFinal.size()/2);
                if (midwayIndex >= wordsFinal.size()) {
                    midwayIndex--;
                }
                
                for (int i = midwayIndex; i >= 0; i--) {
                    //See if this word could be joined with previous string and still fits
                    //in the widths
                    if (sb.length() + wordsFinal.get(i).length() <= width - 1) {
                        if (sb.length() > 0) {
                            sb.insert(0, " ");
                        }
                        sb.insert(0, wordsFinal.get(i));
                    } else {
                        compacted.add(0, sb.toString());
                        sb = new StringBuilder();
                        sb.insert(0, wordsFinal.get(i));
                    }
                }
                if (sb.length() > 0) {
                   compacted.add(0, sb.toString());
                }

                sb = new StringBuilder();
                //Compact mid way towards beginning
                for (int i = midwayIndex + 1; i < wordsFinal.size(); i++) {
                    //See if this word could be joined with previous string and still fits
                    //in the width
                    if (sb.length() + wordsFinal.get(i).length() <= width) {
                        if (sb.length() > 0) {
                            sb.append(" ");
                        }
                        sb.append(wordsFinal.get(i));
                    } else {
                        compacted.add(sb.toString());
                        sb = new StringBuilder();
                        sb.append(wordsFinal.get(i));
                    }
                }
                if (sb.length() > 0) {
                   compacted.add(sb.toString());
                }

                //We may need to add filler lines at beginning and as well at the end.
                numerOfFillers = Math.max(0, height - compacted.size()) / 2; 
                for (int i = 0; i < numerOfFillers; i++) {
                    compacted.add(0, "");
                }
                
                numerOfFillers = height - compacted.size();
                for (int i = 0; i < numerOfFillers; i++) {
                    compacted.add("");
                }
                break;

            case BOTTOM_LEFT:
            case BOTTOM_CENTER:
            case BOTTOM_RIGHT:
                for (int i = wordsFinal.size() - 1; i >= 0; i--) {
                    //See if this word could be joined with previous string and still fits
                    //in the widths
                    if (sb.length() + wordsFinal.get(i).length() <= width - 1) {
                        if (sb.length() > 0) {
                            sb.insert(0, " ");
                        }
                        sb.insert(0, wordsFinal.get(i));
                    } else {
                        compacted.add(0, sb.toString());
                        sb = new StringBuilder();
                        sb.insert(0, wordsFinal.get(i));
                    }
                }
                if (sb.length() > 0) {
                   compacted.add(0, sb.toString());
                }
                
                numerOfFillers = height - compacted.size();
                for (int i = 0; i < numerOfFillers; i++) {
                    compacted.add(0, "");
                }
                
                break;
        }
        
        List<String> aligned = new ArrayList<String>();
        
        //Align Horizontal
        for (int i = 0; i < compacted.size(); i++) {
            int prefixCount = 0;
            int suffixCount = 0;
            String tempData = compacted.get(i);
            if (tempData == null) {
                tempData = "";
            }
            
            switch (align) {
                case TOP_LEFT:
                case MIDDLE_LEFT:
                case BOTTOM_LEFT:
                    suffixCount = width - tempData.length();
                    break;
    
                case TOP_CENTER:
                case MIDDLE_CENTER:
                case BOTTOM_CENTER:
                    prefixCount = (width - tempData.length())/2;
                    suffixCount = width - prefixCount - tempData.length();
                    break;
                    
                case TOP_RIGHT:
                case MIDDLE_RIGHT:
                case BOTTOM_RIGHT:
                    prefixCount = width - tempData.length();
                    break;
                
            }
            
            aligned.add(Util.createSpacer(prefixCount) + tempData + Util.createSpacer(suffixCount));
        }
        
        return aligned;
    }
    
    private String substring(String data, int startIndex, int endIndex) {
        if (startIndex < 0) {
            startIndex = 0;
        }
        
        if (endIndex > data.length()) {
            endIndex = data.length();
        }
        
        return data.substring(startIndex, endIndex);
    }
    
    private List<String> splitWord(String word, int width) {
        List<String> words = new ArrayList<String>();
        int startIndex = 0;
        while (startIndex < word.length()) {
            words.add(substring(word, startIndex, startIndex + width).trim());
            startIndex += width;
        }
        
        return words;
    }
}
