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
package net.noday.core.service.impl;

import net.noday.core.model.User;
import net.noday.core.pagination.Page;
import net.noday.core.security.SecurityDao;
import net.noday.core.security.ShiroDbRealm.ShiroUser;
import net.noday.core.service.SecurityService;
import net.noday.core.utils.Digests;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * cat SecurityService
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-10-21
 * @since 
 */
@Service
public class SecurityServiceImpl implements SecurityService {

	@Autowired private SecurityDao dao;
	
	/* (non-Javadoc)
	 * @see net.noday.core.service.SecurityService#findPage(net.noday.core.model.User, net.noday.core.pagination.Page)
	 */
	@Override
	public void findPage(User condition, Page<User> pageData) {
		pageData.setPageCount(dao.findCount(condition));
		pageData.setRows(dao.findPage(condition, pageData.getPageIndex(), pageData.getSize()));
	}
	
	/* (non-Javadoc)
	 * @see net.noday.core.service.SecurityService#regist(net.noday.core.model.User)
	 */
	@Override
	public void regist(User u) {
		entryptPassword(u);
		u.setRole("user");
		dao.save(u);
	}
	
	/* (non-Javadoc)
	 * @see net.noday.core.service.SecurityService#findUserByLoginName(java.lang.String)
	 */
	@Override
	public User findUserByLoginName(String email) {
		User u = dao.findUserByLoginName(email);
		return u;
	}
	
	/* (non-Javadoc)
	 * @see net.noday.core.service.SecurityService#findUserByDuoshuo(java.lang.String)
	 */
	@Override
	public User findUserByDuoshuo(String duoshuoUserId) {
		User u = dao.findUserByDuoshuo(duoshuoUserId);
		return u;
	}
	
	/* (non-Javadoc)
	 * @see net.noday.core.service.SecurityService#getUserByToken(java.lang.String)
	 */
	@Override
	public User getUserByToken(String token) {
		User u = new User();
		return u;
	}
	
	/* (non-Javadoc)
	 * @see net.noday.core.service.SecurityService#checkLogin(net.noday.core.model.User)
	 */
	@Override
	public boolean checkLogin(User u) {
		
		return true;
	}
	
	/**
	 * 判断是否超级管理员.
	 */
	protected boolean isSupervisor(Long id) {
		return id == 1;
	}

	/**
	 * 取出Shiro中的当前用户LoginName.
	 */
	protected String getCurrentUserName() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.loginName;
	}

	/**
	 * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
	 */
	private void entryptPassword(User user) {
		ByteSource salt = Digests.generateSalt(Digests.SALT_SIZE);
		user.setSalt(salt.toBase64());

		String hashPassword = Digests.sha256Hash(user.getPlainPassword(), salt, 1024);
		user.setPassword(hashPassword);
	}
}
