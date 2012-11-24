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

/**
 * cat AjaxMsg
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-10-18
 * @since 
 */
public class AjaxMsg {

	private boolean succ;
	private String msg;
	private Object data;
	
	public boolean isSucc() {
		return succ;
	}
	public void setSucc(boolean succ) {
		this.succ = succ;
	}
	public String getMsg() {
		return msg;
	}
	public AjaxMsg setMsg(String msg) {
		this.msg = msg;
		return this;
	}
	public Object getData() {
		return data;
	}
	public AjaxMsg setData(Object data) {
		this.data = data;
		return this;
	}
	public AjaxMsg succeed() {
		setSucc(true);
		return this;
	}
	public AjaxMsg succeed(String msg) {
		setSucc(true);
		setMsg(msg);
		return this;
	}
	public AjaxMsg fail() {
		setSucc(false);
		return this;
	}
	public AjaxMsg fail(String msg) {
		setSucc(false);
		setMsg(msg);
		return this;
	}
}
