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
package net.noday.cat.listener;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.annotation.Resource;

import net.noday.cat.event.ArticleSaveEvent;
import net.noday.cat.model.Article;
import net.noday.cat.model.ext.RhythmArticle;
import net.noday.core.model.App;
import net.noday.core.security.ShiroDbRealm.ShiroUser;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * cat DwzManager
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-12-28
 * @since 
 */
@Service
public class ArticleSaveNotifier implements ApplicationListener<ArticleSaveEvent> {

	private static final Logger log = Logger.getLogger(ArticleSaveNotifier.class);
	
	@Resource private Map<String, Object> appCache;
	/**
     * B3log Rhythm address.
     */
    public static final String B3LOG_RHYTHM_ADDRESS = "http://rhythm.b3log.org:80";
    /**
     * URL of adding article to Rhythm.
     */
    private static final String ADD_ARTICLE_URL = B3LOG_RHYTHM_ADDRESS + "/add-article.do";
	@Override
	public void onApplicationEvent(ArticleSaveEvent e) {
		//https://github.com/b3log/b3log-symphony/blob/master/src/main/java/org/b3log/symphony/processor/ArticleProcessor.java
		//https://github.com/b3log/b3log-solo/blob/master/core/src/main/java/org/b3log/solo/event/rhythm/ArticleSender.java
		System.out.println(e.getArticle().getTitle());
		try {
			Article a = e.getArticle();
			HttpClient client = new DefaultHttpClient();
			HttpPost post = new HttpPost(ADD_ARTICLE_URL);
			post.setEntity(new StringEntity(toPostString(a), "UTF-8"));
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			String responseBody = client.execute(post, responseHandler);
			log.info(responseBody);
		} catch (UnsupportedEncodingException ex) {
			log.error(ex.getMessage(), ex);
		} catch (ClientProtocolException ex) {
			log.error(ex.getMessage(), ex);
		} catch (IOException ex) {
			log.error(ex.getMessage(), ex);
		}
	}

	private String toPostString(Article a) {
		RhythmArticle obj = new RhythmArticle(a, getCfgs(), getUser().getLoginName());
		String str = JSON.toJSONString(obj, SerializerFeature.UseSingleQuotes);
		return str;
	}

	protected App getCfgs() {
		return (App) appCache.get("cfg");
	}
	protected ShiroUser getUser() {
		ShiroUser shiroUser = (ShiroUser) getPrimaryPrincipal();
		return shiroUser;
	}
	protected Subject getSubject() {
		return SecurityUtils.getSubject();
	}
	protected Session getSession() {
		return getSubject().getSession();
	}
	protected PrincipalCollection getPrincipals() {
		return getSubject().getPrincipals();
	}
	protected Object getPrimaryPrincipal() {
		return getPrincipals().getPrimaryPrincipal();
	}
//	ObjectMapper m = new ObjectMapper();
//	StringWriter sw = new StringWriter();
//	JsonGenerator g = new JsonFactory().createJsonGenerator(sw);
//	m.writeValue(g, e.getArticle());
//	g.close();
//	sw.toString();
}
