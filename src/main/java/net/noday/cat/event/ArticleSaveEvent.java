/**
 * 
 */
package net.noday.cat.event;

import net.noday.cat.model.Article;

import org.springframework.context.ApplicationEvent;

/**
 * @author Administrator
 *
 */
public class ArticleSaveEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Article article;
	public ArticleSaveEvent(Object source, Article article) {
		super(source);
		this.article = article;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}

}
