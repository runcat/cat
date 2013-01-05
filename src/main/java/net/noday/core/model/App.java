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
import java.util.Collection;
import java.util.List;

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
	private int listStyle;
	private boolean registable;
	private boolean commentable;
	private String sign1;
	private String sign2;
	private String rhythmKey;
	private String rhythmVersion;// TODO 为了迎合接口
	private String duoshuoKey;
	private List<String> skins;// TODO 也许换成skin类

	public String getVersion() {
		return version;
	}
	public App setVersion(String version) {
		this.version = version;
		return this;
	}
	public String getWebTitle() {
		return webTitle;
	}
	public App setWebTitle(String webTitle) {
		this.webTitle = webTitle;
		return this;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public App setSubTitle(String subTitle) {
		this.subTitle = subTitle;
		return this;
	}
	public String getHostUrl() {
		return hostUrl;
	}
	public App setHostUrl(String hostUrl) {
		this.hostUrl = hostUrl;
		return this;
	}
	public String getMetaKeywords() {
		return metaKeywords;
	}
	public App setMetaKeywords(String metaKeywords) {
		this.metaKeywords = metaKeywords;
		return this;
	}
	public String getMetaDescription() {
		return metaDescription;
	}
	public App setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
		return this;
	}
	public String getBoardSource() {
		return boardSource;
	}
	public App setBoardSource(String boardSource) {
		this.boardSource = boardSource;
		return this;
	}
	public String getHiddenSource() {
		return hiddenSource;
	}
	public App setHiddenSource(String hiddenSource) {
		this.hiddenSource = hiddenSource;
		return this;
	}
	public String getSkin() {
		return skin;
	}
	public App setSkin(String skin) {
		this.skin = skin;
		return this;
	}
	public int getRecentArticles() {
		return recentArticles;
	}
	public App setRecentArticles(int recentArticles) {
		this.recentArticles = recentArticles;
		return this;
	}
	public int getMostViewArticles() {
		return mostViewArticles;
	}
	public App setMostViewArticles(int mostViewArticles) {
		this.mostViewArticles = mostViewArticles;
		return this;
	}
	public int getMostReplyArticles() {
		return mostReplyArticles;
	}
	public App setMostReplyArticles(int mostReplyArticles) {
		this.mostReplyArticles = mostReplyArticles;
		return this;
	}
	public int getRecentComments() {
		return recentComments;
	}
	public App setRecentComments(int recentComments) {
		this.recentComments = recentComments;
		return this;
	}
	public int getMostUsedTags() {
		return mostUsedTags;
	}
	public App setMostUsedTags(int mostUsedTags) {
		this.mostUsedTags = mostUsedTags;
		return this;
	}
	public int getListArticles() {
		return listArticles;
	}
	public App setListArticles(int listArticles) {
		this.listArticles = listArticles;
		return this;
	}
	public int getListStyle() {
		return listStyle;
	}
	public App setListStyle(int listStyle) {
		this.listStyle = listStyle;
		return this;
	}
	public boolean isRegistable() {
		return registable;
	}
	public App setRegistable(boolean registable) {
		this.registable = registable;
		return this;
	}
	public boolean isCommentable() {
		return commentable;
	}
	public App setCommentable(boolean commentable) {
		this.commentable = commentable;
		return this;
	}
	public List<String> getSkins() {
		return skins;
	}
	public App setSkins(List<String> skins) {
		this.skins = skins;
		return this;
	}
	public boolean hasSkin(String skinName) {
		return this.skins.contains(skinName);
	}
	public App addSkin(String skinName) {
		this.skins.add(skinName);
		return this;
	}
	public App addSkins(Collection<String> skins) {
		this.skins.addAll(skins);
		return this;
	}
	public String getSign1() {
		return sign1;
	}
	public App setSign1(String sign1) {
		this.sign1 = sign1;
		return this;
	}
	public String getSign2() {
		return sign2;
	}
	public App setSign2(String sign2) {
		this.sign2 = sign2;
		return this;
	}
	public String getRhythmKey() {
		return rhythmKey;
	}
	public App setRhythmKey(String rhythmKey) {
		this.rhythmKey = rhythmKey;
		return this;
	}
	public String getRhythmVersion() {
		return rhythmVersion;
	}
	public App setRhythmVersion(String rhythmVersion) {
		this.rhythmVersion = rhythmVersion;
		return this;
	}
	public String getDuoshuoKey() {
		return duoshuoKey;
	}
	public App setDuoshuoKey(String duoshuoKey) {
		this.duoshuoKey = duoshuoKey;
		return this;
	}
	public App update(AppWebInfo info) {
		this.setWebTitle(info.getWebTitle())
			.setSubTitle(info.getSubTitle())
			.setHostUrl(info.getHostUrl())
			.setMetaKeywords(info.getMetaKeywords())
			.setMetaDescription(info.getMetaDescription())
			.setBoardSource(info.getBoardSource())
			.setHiddenSource(info.getHiddenSource());
		return this;
	}
	public App update(AppWebSetting setting) {
		this.setListArticles(setting.getListArticles())
			.setRecentArticles(setting.getRecentArticles())
			.setMostViewArticles(setting.getMostViewArticles())
			.setMostReplyArticles(setting.getMostReplyArticles())
			.setRecentComments(setting.getRecentComments())
			.setMostUsedTags(setting.getMostUsedTags())
			.setRegistable(setting.isRegistable())
			.setCommentable(setting.isCommentable());
		return this;
	}
	public App update(AppUserSign sign) {
		this.setSign1(sign.getSign1())
			.setSign2(sign.getSign2());
		return this;
	}
	public App update(AppRhythmSetting rhythm) {
		this.setRhythmKey(rhythm.getRhythmKey())
			.setRhythmVersion(rhythm.getRhythmVersion());
		return this;
	}
}
