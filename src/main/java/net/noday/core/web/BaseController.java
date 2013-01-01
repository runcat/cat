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
package net.noday.core.web;

import java.util.Map;

import javax.annotation.Resource;

import net.noday.core.model.App;
import net.noday.core.security.IncorrectCaptchaException;
import net.noday.core.security.SecurityDao;
import net.noday.core.security.ShiroDbRealm;
import net.noday.core.security.ShiroDbRealm.ShiroUser;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * cat BaseController
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-12-25
 * @since 
 */
public abstract class BaseController {

	@Autowired protected SecurityDao securityDao;
	@Resource protected Map<String, Object> appCache;
	@Autowired protected ShiroDbRealm realm;

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
	protected void shiro() {
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		session.setAttribute("key", "value");
		if (!currentUser.isAuthenticated()) {
			UsernamePasswordToken token = new UsernamePasswordToken("username", "password");
			try {
				currentUser.login(token);
				currentUser.getPrincipal();//用户名
				currentUser.hasRole("admin");//是否有admin角色
				currentUser.isPermitted("");
				currentUser.logout();
			} catch (IncorrectCaptchaException e) {
			} catch (UnknownAccountException e) {//用户名不存在
			} catch (IncorrectCredentialsException e) {//密码不正确
			} catch (LockedAccountException e) {//锁定
			} catch (AuthenticationException e) {
			}
		}
	}
	
	protected void response(Model m, boolean succ, String message, Object data) {
		m.addAttribute("result", succ);
		m.addAttribute("message", message);
		m.addAttribute("data", data);
	}
	protected void responseResult(Model m, boolean succ) {
		m.addAttribute("result", succ);
	}
	protected void responseMsg(Model m, boolean succ, String message) {
		m.addAttribute("result", succ);
		m.addAttribute("message", message);
	}
	protected void responseData(Model m, Object data) {
		m.addAttribute("result", true);
		m.addAttribute("data", data);
	}
	protected void responseValidError(Model m, BindingResult r) {
		m.addAttribute(r.getFieldErrors());
	}
	protected void responseMsg(ModelAndView m, boolean succ, String message) {
		m.addObject("result", succ);
		m.addObject("message", message);
	}
	
	@ExceptionHandler
	public ModelAndView resolveException(EmptyResultDataAccessException e, WebRequest req) {
		return new ModelAndView("404").addObject("msg", e.getMessage());
	}
	@ExceptionHandler
	public ModelAndView resolveException(Exception e, WebRequest req) {
		ModelAndView m = new ModelAndView("500");
		responseMsg(m, false, e.getMessage());
		return m;
	}
}
