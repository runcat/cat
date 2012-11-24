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

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.util.Map;

import freemarker.core.Environment;
import freemarker.log.Logger;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;

/**
 * cat PrincipalTag
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2013-2-8
 * @since 
 */
public class PrincipalTag extends SecureTag {

	private static final Logger log = Logger.getLogger("PrincipalTag");
	/* (non-Javadoc)
	 * @see net.noday.core.security.freemarker.SecureTag#onExecute(freemarker.core.Environment, java.util.Map, freemarker.template.TemplateModel[], freemarker.template.TemplateDirectiveBody)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void onExecute(Environment env, Map params,
			TemplateModel[] loopVars, TemplateDirectiveBody body)
			throws TemplateException, IOException {
        String result = null;

        if (getSubject() != null) {
            // Get the principal to print out
            Object principal;

            if (getType(params) == null) {
                principal = getSubject().getPrincipal();
            } else {
                principal = getPrincipalFromClassName(params);
            }

            // Get the string value of the principal
            if (principal != null) {
                String property = getProperty(params);

                if (property == null) {
                    result = principal.toString();
                } else {
                    result = getPrincipalProperty(principal, property);
                }
            }
        }

        // Print out the principal value if not null
        if (result != null) {
            try {
                env.getOut().write(result);
            } catch (IOException ex) {
                throw new TemplateException("Error writing ["+result+"] to Freemarker.", ex, env);
            }
        }
	}
	@SuppressWarnings("rawtypes")
	String getType(Map params) {
        return getParam(params, "type");
    }
	
	@SuppressWarnings("rawtypes")
	String getProperty(Map params) {
        return getParam(params, "property");
    }
	
    @SuppressWarnings({ "rawtypes", "unchecked" })
	Object getPrincipalFromClassName(Map params) {
        String type = getType(params);

        try {
            Class cls = Class.forName(type);
            
            return getSubject().getPrincipals().oneByType(cls);
        } catch (ClassNotFoundException ex) {
            log.error("Unable to find class for name ["+type+"]", ex);
        }

        return null;
    }
    
    String getPrincipalProperty(Object principal, String property) throws TemplateModelException {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(principal.getClass());

            // Loop through the properties to get the string value of the specified property
            for (PropertyDescriptor propertyDescriptor : beanInfo.getPropertyDescriptors()) {
                if (propertyDescriptor.getName().equals(property)) {
                    Object value = propertyDescriptor.getReadMethod().invoke(principal, (Object[]) null);

                    return String.valueOf(value);
                }
            }

            // property not found, throw
            throw new TemplateModelException("Property ["+property+"] not found in principal of type ["+principal.getClass().getName()+"]");
        } catch (Exception ex) {
            throw new TemplateModelException("Error reading property ["+property+"] from principal of type ["+principal.getClass().getName()+"]", ex);
        }
    }
}
