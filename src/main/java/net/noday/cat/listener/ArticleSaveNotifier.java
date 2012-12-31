/**
 * 
 */
package net.noday.cat.listener;

import net.noday.cat.event.ArticleSaveEvent;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 *
 */
@Service
public class ArticleSaveNotifier implements ApplicationListener<ArticleSaveEvent> {

	@Override
	public void onApplicationEvent(ArticleSaveEvent arg0) {
		// TODO https://github.com/b3log/b3log-solo/blob/master/core/src/main/java/org/b3log/solo/event/rhythm/ArticleSender.java
		
	}

}
