/**
 * 
 */
package net.noday.core.security;

/**
 * @author Administrator
 *
 */
public interface Registable {

	void setSalt(String salt);
	
	String getPlainPassword();
	
	void setPassword(String password);
}
