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
package com.brsanthu.dataexporter.output.tree;

public class TreeExportStyle {
	
    public static TreeExportStyle CLASSIC = new TreeExportStyle("", "+-- ", null, "|-- ", "'-- ", "|-- ", "|  ", "   ");
    public static TreeExportStyle EXTENDED_ASCII = new TreeExportStyle(new String(new char[] {196}), null, null, new String(new char[] {195, 196, 196}), new String(new char[] {192, 196, 196}), new String(new char[] {195, 196, 196}), "|  ", "   ");
    //public static TreeExportStyle CLASSIC_NO_CONNECTOR = new TreeExportStyle("+-- ", "|-- ", "   ", "   ");
    //public static TreeExportStyle MAVEN = new TreeExportStyle("", "+-- ", "\\-- ", "+-- ", "|  ", "   ");
	
	private String rootNodePrefix = null;
	private String parentNodePrefix = null;
	private String firstNodePrefix = null;
	private String lastNodePrefix = null;
	private String otherNodesPrefix = null;
	private String levelSeparator = null;
	private String lastLevelSeparator = null;
	private String parentNodeSuffix = null;

	public TreeExportStyle(String rootNodePrefix, String parentNodePrefix, String parentNodeSuffix, String firstNodePrefix,
			String lastNodePrefix, String otherNodesPrefix,
			String levelSeparator, String lastLevelSeparator) {
		super();
		this.rootNodePrefix = rootNodePrefix;
		this.parentNodePrefix = parentNodePrefix;
		this.parentNodeSuffix = parentNodeSuffix;
		this.firstNodePrefix = firstNodePrefix;
		this.lastNodePrefix = lastNodePrefix;
		this.otherNodesPrefix = otherNodesPrefix;
		this.levelSeparator = levelSeparator;
		this.lastLevelSeparator = lastLevelSeparator;
	}

	public String getRootNodePrefix() {
		return rootNodePrefix;
	}

	public void setRootNodePrefix(String rootNodePrefix) {
		this.rootNodePrefix = rootNodePrefix;
	}

	public String getFirstNodePrefix() {
		return firstNodePrefix;
	}

	public void setFirstNodePrefix(String firstNodePrefix) {
		this.firstNodePrefix = firstNodePrefix;
	}

	public String getLastNodePrefix() {
		return lastNodePrefix;
	}

	public void setLastNodePrefix(String lastNodePrefix) {
		this.lastNodePrefix = lastNodePrefix;
	}

	public String getOtherNodesPrefix() {
		return otherNodesPrefix;
	}

	public void setOtherNodesPrefix(String otherNodesPrefix) {
		this.otherNodesPrefix = otherNodesPrefix;
	}

	public String getLevelSeparator() {
		return levelSeparator;
	}

	public void setLevelSeparator(String levelSeparator) {
		this.levelSeparator = levelSeparator;
	}
	
	public void setLastLevelSeparator(String lastLevelSeparator) {
		this.lastLevelSeparator = lastLevelSeparator;
	}
	
	public String getLastLevelSeparator() {
		return lastLevelSeparator;
	}

	public String getParentNodePrefix() {
		return parentNodePrefix;
	}

	public void setParentNodePrefix(String parentNodePrefix) {
		this.parentNodePrefix = parentNodePrefix;
	}

	public String getParentNodeSuffix() {
		return parentNodeSuffix;
	}

	public void setParentNodeSuffix(String parentNodeSuffix) {
		this.parentNodeSuffix = parentNodeSuffix;
	}
}
