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
package net.noday.core.security.freemarker;

import java.io.IOException;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import freemarker.core.Environment;
import freemarker.template.SimpleScalar;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;

/**
 * cat SecureTag
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2013-2-8
 * @since 
 */
public abstract class SecureTag implements TemplateDirectiveModel {

	/* (non-Javadoc)
	 * @see freemarker.template.TemplateDirectiveModel#execute(freemarker.core.Environment, java.util.Map, freemarker.template.TemplateModel[], freemarker.template.TemplateDirectiveBody)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		verifyParameters(params);
		onExecute(env, params, loopVars, body);
	}

	@SuppressWarnings("rawtypes")
	protected void verifyParameters(Map params) throws TemplateModelException {
		
	}
	
	@SuppressWarnings("rawtypes")
	public abstract void onExecute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException;
	
	protected Subject getSubject() {
		return SecurityUtils.getSubject();
	}
	
	@SuppressWarnings("rawtypes")
	protected String getParam(Map params, String name) {
		Object value = params.get(name);
		if (value instanceof SimpleScalar) {
			return ((SimpleScalar)value).getAsString();
		}
		return null;
	}
	
	protected void renderBody(Environment env, TemplateDirectiveBody body) throws TemplateException, IOException {
		if (body != null) {
			body.render(env.getOut());
		}
	}
}
