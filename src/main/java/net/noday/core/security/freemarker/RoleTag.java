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

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * cat RoleTag
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2013-2-8
 * @since 
 */
public abstract class RoleTag extends SecureTag {

	/* (non-Javadoc)
	 * @see net.noday.core.security.freemarker.SecureTag#onExecute(freemarker.core.Environment, java.util.Map, freemarker.template.TemplateModel[], freemarker.template.TemplateDirectiveBody)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void onExecute(Environment env, Map params,
			TemplateModel[] loopVars, TemplateDirectiveBody body)
			throws TemplateException, IOException {
        boolean show = showTagBody(getName(params));
        if (show) {
            renderBody(env, body);
        }
	}
	
    @SuppressWarnings("rawtypes")
	String getName(Map params) {
        return getParam(params, "name");
    }
    
    protected abstract boolean showTagBody(String roleNames);
}
