/*
 * Copyright 2012 the original author or authors.
 *
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
 */
package net.noday.core.model;

import java.io.Serializable;

/**
 * cat App
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-11-24
 * @since 
 */
public class App implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String version;
	private String webTitle;
	private String subTitle;
	private String hostUrl;
	private String metaKeywords;
	private String metaDescription;
	private String boardSource;
	private String hiddenSource;
	private String skin;
	private int recentArticles;
	private int mostViewArticles;
	private int mostReplyArticles;
	private int recentComments;
	private int mostUsedTags;
	private int listArticles;
	private boolean registable;
	private boolean commentable;

	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getWebTitle() {
		return webTitle;
	}
	public void setWebTitle(String webTitle) {
		this.webTitle = webTitle;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public String getHostUrl() {
		return hostUrl;
	}
	public void setHostUrl(String hostUrl) {
		this.hostUrl = hostUrl;
	}
	public String getMetaKeywords() {
		return metaKeywords;
	}
	public void setMetaKeywords(String metaKeywords) {
		this.metaKeywords = metaKeywords;
	}
	public String getMetaDescription() {
		return metaDescription;
	}
	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}
	public String getBoardSource() {
		return boardSource;
	}
	public void setBoardSource(String boardSource) {
		this.boardSource = boardSource;
	}
	public String getHiddenSource() {
		return hiddenSource;
	}
	public void setHiddenSource(String hiddenSource) {
		this.hiddenSource = hiddenSource;
	}
	public String getSkin() {
		return skin;
	}
	public void setSkin(String skin) {
		this.skin = skin;
	}
	public int getRecentArticles() {
		return recentArticles;
	}
	public void setRecentArticles(int recentArticles) {
		this.recentArticles = recentArticles;
	}
	public int getMostViewArticles() {
		return mostViewArticles;
	}
	public void setMostViewArticles(int mostViewArticles) {
		this.mostViewArticles = mostViewArticles;
	}
	public int getMostReplyArticles() {
		return mostReplyArticles;
	}
	public void setMostReplyArticles(int mostReplyArticles) {
		this.mostReplyArticles = mostReplyArticles;
	}
	public int getRecentComments() {
		return recentComments;
	}
	public void setRecentComments(int recentComments) {
		this.recentComments = recentComments;
	}
	public int getMostUsedTags() {
		return mostUsedTags;
	}
	public void setMostUsedTags(int mostUsedTags) {
		this.mostUsedTags = mostUsedTags;
	}
	public int getListArticles() {
		return listArticles;
	}
	public void setListArticles(int listArticles) {
		this.listArticles = listArticles;
	}
	public boolean isRegistable() {
		return registable;
	}
	public void setRegistable(boolean registable) {
		this.registable = registable;
	}
	public boolean isCommentable() {
		return commentable;
	}
	public void setCommentable(boolean commentable) {
		this.commentable = commentable;
	}
}
