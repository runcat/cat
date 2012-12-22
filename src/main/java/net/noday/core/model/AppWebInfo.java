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

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * cat AppWebInfo
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-12-22
 * @since 
 */
public class AppWebInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotEmpty @Length(max = 20)
	private String webTitle;
	@Length(max = 100)
	private String subTitle;
	@Length(max = 50)
	private String hostUrl;
	@Length(max = 100)
	private String metaKeywords;
	@Length(max = 200)
	private String metaDescription;
	private String boardSource;
	private String hiddenSource;
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
}
