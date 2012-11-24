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
package net.noday.core.utils;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.util.ByteSource;

/**
 * cat Digests
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2013-2-8
 * @since 
 */
public class Digests {

	public static final int SALT_SIZE = 8;
	public static final int HASH_INTERATIONS = 1024;
	public static final String HASH_ALGORITHM = Sha256Hash.ALGORITHM_NAME;
	
	private static RandomNumberGenerator random = new SecureRandomNumberGenerator();
	
	public static ByteSource generateSalt() {
		return random.nextBytes();
	}
	
	public static ByteSource generateSalt(int size) {
		return random.nextBytes(size);
	}
	
//	public static String generateSaltString() {
//		return generateSalt().toBase64();
//	}
//	
//	public static String generateSaltString(int size) {
//		return generateSalt(size).toBase64();
//	}
	
	public static String sha256Hash(Object source, Object salt, int hashIterations) {
		return new Sha256Hash(source, salt, hashIterations).toBase64();
	}
	
	public static String sha256Hash(Object source, Object salt) {
		return new Sha256Hash(source, salt, HASH_INTERATIONS).toBase64();
	}
	
	public static String randomSha256Hash(Object source) {
		return new Sha256Hash(source, generateSalt(), HASH_INTERATIONS).toBase64();
	}
	
	public static String Sha256Hash(Object source) {
		return new Sha256Hash(source, HASH_INTERATIONS).toBase64();
	}
}
