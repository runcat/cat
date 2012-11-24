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
package net.noday.cat.web;

import java.io.IOException;

import net.noday.core.model.User;
import net.noday.core.security.IncorrectCaptchaException;
import net.noday.core.utils.Captcha;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * cat MainController
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-11-24
 * @since 
 */
@Controller @RequestMapping("/")
public class MainController {

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		
		return "index";
	}
	

	/**
	 * 注册页
	 * @return
	 */
	@RequestMapping(value = "regist", method = RequestMethod.GET)
	public String preRegist() {
		
		return "user/regist";
	}
	/**
	 * 注册提交
	 * @param u
	 * @return
	 */
	@RequestMapping(value = "regist", method = RequestMethod.POST)
	public String regist(User u) {
		
		return "user/regist-success";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String preLogin() {
		
		return "user/login";
	}
	
	@Deprecated
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login() {
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "captcha", method = RequestMethod.GET) @ResponseBody
	public byte[] loginCaptcha() throws IOException {
		return FileCopyUtils.copyToByteArray(Captcha.captchInputStream(getSession(), 60, 30));
	}
	
	protected Subject getSubject() {
		return SecurityUtils.getSubject();
	}
	protected Session getSession() {
		return getSubject().getSession();
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
}