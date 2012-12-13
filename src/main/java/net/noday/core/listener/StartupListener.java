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

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import net.noday.core.dao.AppDao;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

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
    Map<String, Object> appConfigs;
    
	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@SuppressWarnings("unchecked")
	@Override
    public void contextInitialized(ServletContextEvent sce) {
        ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(context = sce.getServletContext());
        appConfigs = ctx.getBean("appConfigs", Map.class);
        initMysql();
        loadSkinMessage();
        // load config
        setWebProperty();
    }
	
	private void initMysql() {
		AppDao appDao = ctx.getBean(AppDao.class);
		appDao.initMysql();
	}
	
	private void loadSkinMessage() {
		
	}

    private void setWebProperty() {
        setAttribute("contextPath", context.getContextPath());
        setAttribute("skin", "default");
    }

    private void setAttribute(String key, Object value) {
        context.setAttribute(key, value);
        appConfigs.put(key, value);
        log.info("ServletContext add " + key + ":" + value);
    }

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

}
