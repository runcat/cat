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
package net.noday.cat.model;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

/**
 * cat Tag
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-12-25
 * @since 
 */
public class Tag implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private int refCount;
	/**
	 * 
	 */
	public Tag() {
		super();
	}
	/**
	 * @param name
	 */
	public Tag(String name) {
		super();
		this.name = name;
	}
	public Tag(Long id, String name, int refCount) {
		super();
		this.id = id;
		this.name = name;
		this.refCount = refCount;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRefCount() {
		return refCount;
	}
	public void setRefCount(int refCount) {
		this.refCount = refCount;
	}
	@Override
	public int hashCode() {
		return getName().hashCode();
	}
	@Override
	public String toString() {
		return getName();
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Tag) {
			return StringUtils.equalsIgnoreCase(getName(), ((Tag) obj).getName());
		} else if (obj instanceof String) {
			return StringUtils.equalsIgnoreCase(getName(), (String) obj);
		} else {
			return false;
		}
	}
}
