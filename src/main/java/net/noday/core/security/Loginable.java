/**
 * 
 */
package net.noday.core.security;

/**
 * @author Administrator
 *
 */
public interface Loginable<T> {
	
	T getId();
	String getLoginName();
	String getName();
	String getPassword();
	String getSalt();
	String getRole();
}
