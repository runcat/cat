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
package net.noday.core.model;

import java.io.Serializable;

/**
 * cat AppUserSign
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2013-1-3
 * @since 
 */
public class AppUserSign implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String sign1;
	private String sign2;
	public String getSign1() {
		return sign1;
	}
	public void setSign1(String sign1) {
		this.sign1 = sign1;
	}
	public String getSign2() {
		return sign2;
	}
	public void setSign2(String sign2) {
		this.sign2 = sign2;
	}
}
