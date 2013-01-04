/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package net.noday.core.security;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import net.noday.core.model.User;
import net.noday.core.security.CaptchaUsernamePasswordToken;
import net.noday.core.security.IncorrectCaptchaException;
import net.noday.core.service.SecurityService;
import net.noday.core.utils.Captcha;
import net.noday.core.utils.Digests;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.AllowAllCredentialsMatcher;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;

/**
 * cat ShiroDbRealm
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-11-24
 * @since 
 */
public class ShiroDbRealm extends AuthorizingRealm {

	public static final String LOGINFAILEDCOUNTKEY = "longin_failed_count";
	
	protected SecurityService service;
	private CredentialsMatcher  hashedCredentialsMatcher;
	private CredentialsMatcher  allowAllCredentialsMatcher;

	public void setService(SecurityService service) {
		this.service = service;
	}

	/**
	 * 认证回调函数,登录时调用.
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		if (authcToken instanceof CaptchaUsernamePasswordToken) {
			setCredentialsMatcher(hashedCredentialsMatcher);
			CaptchaUsernamePasswordToken token = (CaptchaUsernamePasswordToken) authcToken;
			String captcha = null;
//		Object s_count = getSession().getAttribute(LOGINFAILEDCOUNTKEY);
			
			Object s_captcha = getSession().getAttribute(Captcha.CAPTCHAKEY);
			if (s_captcha != null && s_captcha instanceof String) {
				captcha = (String) s_captcha;
			}
			if (!StringUtils.equalsIgnoreCase(captcha, token.getCaptcha())) {
				throw new IncorrectCaptchaException("验证码错误");
			}
			
			User user = service.findUserByLoginName(token.getUsername());
			if (user != null) {
				return new SimpleAuthenticationInfo(new ShiroUser(user.getId(), user.getEmail(), user.getName()),// 为什么不直接用User呐？
						user.getPassword(), ByteSource.Util.bytes(Base64.decode(user.getSalt())), getName());
			}
		} else {
			setCredentialsMatcher(allowAllCredentialsMatcher);
			UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
			// TODO 验证 根据token
			User user = service.findUserByLoginName(token.getUsername());
			return new SimpleAuthenticationInfo(new ShiroUser(user.getId(), user.getEmail(), user.getName()), user.getPassword(), getName());
		}
		return null;
	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
		User user = service.findUserByLoginName(shiroUser.loginName);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addRole(user.getRole());
		if ("admin@noday.net".equalsIgnoreCase(user.getEmail())) {
			info.addStringPermission("oper");
		}
//		info.addRoles(user.getRoles());
//		info.addStringPermissions(user.getPermissions());
		return info;
	}

	/**
	 * 设定Password校验的Hash算法与迭代次数.
	 */
	@PostConstruct
	public void initCredentialsMatcher() {
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(Digests.HASH_ALGORITHM);
		matcher.setHashIterations(Digests.HASH_INTERATIONS);
		matcher.setStoredCredentialsHexEncoded(false);
//		matcher.setHashSalted(true);
		{// 根据不同登录来源选择不同的matcher
			hashedCredentialsMatcher = matcher;
			allowAllCredentialsMatcher = new AllowAllCredentialsMatcher();
		}
//		setCredentialsMatcher(matcher);
	}
	
	public void loginWithoutCredentials(AuthenticationToken authcToken) {
		getSubject().login(authcToken);
	}
	
	protected Session getSession() {
		return getSubject().getSession();
	}
	
	protected Subject getSubject() {
		return SecurityUtils.getSubject();
	}

	/**
	 * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
	 */
	public static class ShiroUser implements Serializable {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -3350074487024599768L;
		public Long id;
		public String loginName;
		public String name;

		public ShiroUser(Long id, String loginName, String name) {
			this.id = id;
			this.loginName = loginName;
			this.name = name;
		}
		
		public Long getId() {
			return this.id;
		}

		public String getName() {
			return name;
		}
		
		public String getLoginName() {
			return loginName;
		}

		/**
		 * 本函数输出将作为默认的<shiro:principal/>输出.
		 */
		@Override
		public String toString() {
			return loginName;
		}

		/**
		 * 重载equals,只计算loginName;
		 */
		@Override
		public int hashCode() {
			return HashCodeBuilder.reflectionHashCode(this, "loginName");
		}

		/**
		 * 重载equals,只比较loginName
		 */
		@Override
		public boolean equals(Object obj) {
			return EqualsBuilder.reflectionEquals(this, obj, "loginName");
		}
	}
}
