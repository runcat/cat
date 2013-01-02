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
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import net.noday.cat.event.ArticleSaveEvent;
import net.noday.cat.model.Article;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * cat DwzManager
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-12-28
 * @since 
 */
@Service
public class ArticleSaveNotifier implements ApplicationListener<ArticleSaveEvent> {
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
		// TODO https://github.com/b3log/b3log-solo/blob/master/core/src/main/java/org/b3log/solo/event/rhythm/ArticleSender.java
		System.out.println(e.getArticle().getTitle());
		try {
			Article a = e.getArticle();
			HttpClient client = new DefaultHttpClient();
			HttpPost post = new HttpPost(ADD_ARTICLE_URL);
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			ObjectMapper m = new ObjectMapper();
			StringWriter sw = new StringWriter();
			JsonGenerator g = new JsonFactory().createJsonGenerator(sw);
			m.writeValue(g, e.getArticle());
			g.close();
			StringBuffer sb = new StringBuffer()
				.append("{\"oId\":\"")
				.append(a.getId())
				.append("\",\"articleTitle\":\"")
				.append(a.getTitle())
				.append("\",\"articlePermalink\":\"")
				.append(a.getUrl())// TODO url不对
				.append("\",\"articleTags\":\"")
				.append(a.getTags())
				.append("\",\"articleAuthorEmail\":\"")
				.append(a.getTags())
				.append("\",\"articleContent\":\"")
				.append(a.getContent())
				.append("\",\"articleCreateDate\":")
				.append(a.getCreateTime())
				.append(",\"postToCommunity\":true}");
			sb.toString();
			params.add(new BasicNameValuePair("article", sw.toString()));
			params.add(new BasicNameValuePair("blogVersion", "0.5.5"));
			params.add(new BasicNameValuePair("blog", "B3log Solo"));
			params.add(new BasicNameValuePair("blogTitle", "TODO"));
			params.add(new BasicNameValuePair("blogHost", "TODO"));
			params.add(new BasicNameValuePair("userB3Key", "TODO"));
			params.add(new BasicNameValuePair("clientAdminEmail", "TODO"));
			params.add(new BasicNameValuePair("clientRuntimeEnv", "TODO"));
			params.add(new BasicNameValuePair("article", "TODO"));
			params.add(new BasicNameValuePair("article", "TODO"));
			params.add(new BasicNameValuePair("article", "TODO"));
			params.add(new BasicNameValuePair("article", "TODO"));
			post.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			String responseBody = client.execute(post, responseHandler);
			System.out.println(responseBody);
		} catch (UnsupportedEncodingException ex) {
			ex.printStackTrace();
		} catch (ClientProtocolException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
