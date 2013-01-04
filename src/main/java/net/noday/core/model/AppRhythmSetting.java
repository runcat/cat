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
 * cat AppRhythmSetting
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2013-1-4
 * @since 
 */
public class AppRhythmSetting implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String rhythmKey;
	private String rhythmVersion;
	public String getRhythmKey() {
		return rhythmKey;
	}
	public void setRhythmKey(String rhythmKey) {
		this.rhythmKey = rhythmKey;
	}
	public String getRhythmVersion() {
		return rhythmVersion;
	}
	public void setRhythmVersion(String rhythmVersion) {
		this.rhythmVersion = rhythmVersion;
	}
}
