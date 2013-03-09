/*
 * Copyright 2013 the original author or authors.
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
package net.noday.core.service;

/**
 * cat SecurityService
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2013-1-1
 * @since 
 */
public interface SecurityService<T> {

	public abstract T findUserByLoginName(String loginName);

	public abstract T getUserByToken(String token);

	public abstract boolean checkLogin(T u);
	/**
	 * 判断是否超级管理员.
	 */
	public abstract boolean isSupervisor(Long id);

	/**
	 * 取出Shiro中的当前用户LoginName.
	 */
	public abstract String getCurrentUserName();
}