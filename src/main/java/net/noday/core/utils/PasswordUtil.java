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
package net.noday.core.utils;

import org.apache.shiro.util.ByteSource;

/**
 * cat Captcha
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-01-05
 * @since 
 */
public class PasswordUtil {

	public static void main(String[] args) {
		ByteSource salt = Digests.generateSalt(Digests.SALT_SIZE);
		String hashPassword = Digests.sha256Hash("yourPassword", salt, 1024);
		System.out.println("salt:" + salt.toBase64());
		System.out.println("password:" + hashPassword);
	}
}
