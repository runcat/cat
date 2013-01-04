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
package net.noday.cat.model.ext;

import java.io.Serializable;

import net.noday.core.model.App;

/**
 * cat RhythmArticle
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-12-28
 * @since 
 */
public class RhythmArticle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Article article;
	private String blogVersion;
	private String blog = "Cat";
	private String blogTitle;
	private String blogHost;
	private String userB3Key;
	private String clientAdminEmail;
	private String clientRuntimeEnv;
	public RhythmArticle(net.noday.cat.model.Article a, App cfg, String email) {
		this.setArticle(new Article(a, email));
		this.setCfg(cfg, email);
	}
	public void setCfg(App cfg, String email) {
		setBlogVersion(cfg.getRhythmVersion());
		setBlogTitle(cfg.getWebTitle());
		setBlogHost(cfg.getHostUrl());
		setUserB3Key(cfg.getRhythmKey());
		setClientAdminEmail(email);
		setClientRuntimeEnv("cloudfoundry");
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public String getBlogVersion() {
		return blogVersion;
	}
	public void setBlogVersion(String blogVersion) {
		this.blogVersion = blogVersion;
	}
	public String getBlog() {
		return blog;
	}
	public void setBlog(String blog) {
		this.blog = blog;
	}
	public String getBlogTitle() {
		return blogTitle;
	}
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}
	public String getBlogHost() {
		return blogHost;
	}
	public void setBlogHost(String blogHost) {
		this.blogHost = blogHost;
	}
	public String getUserB3Key() {
		return userB3Key;
	}
	public void setUserB3Key(String userB3Key) {
		this.userB3Key = userB3Key;
	}
	public String getClientAdminEmail() {
		return clientAdminEmail;
	}
	public void setClientAdminEmail(String clientAdminEmail) {
		this.clientAdminEmail = clientAdminEmail;
	}
	public String getClientRuntimeEnv() {
		return clientRuntimeEnv;
	}
	public void setClientRuntimeEnv(String clientRuntimeEnv) {
		this.clientRuntimeEnv = clientRuntimeEnv;
	}
	
	public class Article implements Serializable {
		
		private static final long serialVersionUID = 1L;
		
		private String oId;
		private String articleTitle;
		private String articlePermalink;
		private String articleTags;
		private String articleAuthorEmail;
		private String articleContent;
		private long articleCreateDate;
		private boolean postToCommunity;
		public Article(net.noday.cat.model.Article a, String email) {
			super();
			setOId(a.getId()+"");
			setArticleTitle(a.getTitle());
			setArticlePermalink("/articles/"+a.getId());
			setArticleTags(a.getTags());
			setArticleAuthorEmail(email);
			setArticleContent(a.getContent());
			setArticleCreateDate(System.currentTimeMillis());
			setPostToCommunity(true);
		}
		public String getOId() {
			return oId;
		}
		public void setOId(String oId) {
			this.oId = oId;
		}
		public String getArticleTitle() {
			return articleTitle;
		}
		public void setArticleTitle(String articleTitle) {
			this.articleTitle = articleTitle;
		}
		public String getArticlePermalink() {
			return articlePermalink;
		}
		public void setArticlePermalink(String articlePermalink) {
			this.articlePermalink = articlePermalink;
		}
		public String getArticleTags() {
			return articleTags;
		}
		public void setArticleTags(String articleTags) {
			this.articleTags = articleTags;
		}
		public String getArticleAuthorEmail() {
			return articleAuthorEmail;
		}
		public void setArticleAuthorEmail(String articleAuthorEmail) {
			this.articleAuthorEmail = articleAuthorEmail;
		}
		public String getArticleContent() {
			return articleContent;
		}
		public void setArticleContent(String articleContent) {
			this.articleContent = articleContent;
		}
		public long getArticleCreateDate() {
			return articleCreateDate;
		}
		public void setArticleCreateDate(long articleCreateDate) {
			this.articleCreateDate = articleCreateDate;
		}
		public boolean isPostToCommunity() {
			return postToCommunity;
		}
		public void setPostToCommunity(boolean postToCommunity) {
			this.postToCommunity = postToCommunity;
		}
	}
	
}
