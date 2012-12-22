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

import javax.validation.constraints.Max;

/**
 * cat AppWebSetting
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-12-22
 * @since 
 */
public class AppWebSetting implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Max(100)
	private int listArticles;
	@Max(40)
	private int recentArticles;
	@Max(40)
	private int mostViewArticles;
	@Max(40)
	private int mostReplyArticles;
	@Max(40)
	private int recentComments;
	@Max(100)
	private int mostUsedTags;
	private boolean registable;
	private boolean commentable;
	public int getListArticles() {
		return listArticles;
	}
	public void setListArticles(int listArticles) {
		this.listArticles = listArticles;
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
