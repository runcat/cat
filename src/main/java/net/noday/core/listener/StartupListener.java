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
package net.noday.core.listener;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import net.noday.cat.dao.TagDao;
import net.noday.cat.model.Tag;
import net.noday.core.dao.AppDao;
import net.noday.core.model.App;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * cat StartupListener
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-10-20
 * @since 
 */
public class StartupListener implements ServletContextListener {
	
	private static Logger log = Logger.getLogger(StartupListener.class);

    private ServletContext context;
    private ApplicationContext ctx;
    private AppDao appDao;
    private TagDao tagDao;
    private App cfg;
    private Map<String, Object> appCache;
    
	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@SuppressWarnings("unchecked")
	@Override
    public void contextInitialized(ServletContextEvent sce) {
        ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(context = sce.getServletContext());
        appDao = ctx.getBean(AppDao.class);
        tagDao = ctx.getBean(TagDao.class);
        appCache = ctx.getBean("appCache", Map.class);
        loadAppConfig();
        loadTags();
        loadSkinMessage();
        loadSkins();
        setWebProperty();
    }
	
	private void loadAppConfig() {
		appCache.put("cfg", cfg = appDao.getAppConfig());// TODO cfg应该改个名app
		// TODO 正在想更好的实现方式[将cfg加入spring容器，不行就放到spring管理的bean里或cache
	}
	
	private void loadTags() {
		appCache.put("tags", new HashSet<Tag>(tagDao.findAllTag()));
	}
	
	private void loadSkinMessage() {
		
	}
	
	private void loadSkins() {
		String[] skins = new String[]{"default"};// TODO 从skin目录中读
		cfg.setSkins(Arrays.asList(skins));
	}

    private void setWebProperty() {
        setAttribute("contextPath", context.getContextPath());
        setAttribute("skin", cfg.getSkin());
        setAttribute("version", cfg.getVersion());
        setAttribute("cfg", cfg);// 将配置放入context
        setAttribute("staticServePath", context.getContextPath());// TODO 待定…上线后修改静态资源方式为<resource…
    }

    private void setAttribute(String key, Object value) {
        context.setAttribute(key, value);
        log.info("ServletContext add " + key + ":" + value);
    }

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

}
