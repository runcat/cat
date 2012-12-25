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
package net.noday.cat.web.admin;

import javax.validation.Valid;

import net.noday.cat.service.SettingsService;
import net.noday.core.model.AppWebInfo;
import net.noday.core.model.AppWebSetting;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * cat SettingsManager
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-12-20
 * @since 
 */
@Controller @RequestMapping("/admin/settings")
public class SettingsManager {

	private static final Logger log = Logger.getLogger(SettingsManager.class);
	
	@Autowired private SettingsService service;
	
	@RequestMapping(value = "webInfo", method = RequestMethod.GET)
	public String editWebInfo() {
		return "admin/settings/webInfo";
	}
	
	@RequestMapping(value = "webInfo", method = RequestMethod.POST)
	public Model modifyWebInfo(@Valid AppWebInfo settings, BindingResult result, Model m) {
		if (result.hasErrors()) {
			m.addAttribute(result.getFieldErrors());
		} else {
			try {
				service.modifyWebInfo(settings);
				responseResult(m, true);
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				responseMsg(m, false, e.getMessage());
			}
		}
		return m;
	}
	
	@RequestMapping(value = "webSetting", method = RequestMethod.GET)
	public String editWebSetting() {
		return "admin/settings/webSetting";
	}
	
	@RequestMapping(value = "webSetting", method = RequestMethod.POST)
	public Model modifyWebSetting(@Valid AppWebSetting settings, BindingResult result, Model m) {
		if (result.hasErrors()) {
			m.addAttribute(result.getFieldErrors());
		} else {
			try {
				service.modifyWebSetting(settings);
				responseResult(m, true);
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				responseMsg(m, false, e.getMessage());
			}
		}
		return m;
	}
	
	@RequestMapping(value = "webSkin", method = RequestMethod.GET)
	public String editWebSkin() {
		return "admin/settings/webSkin";
	}
	
	@RequestMapping(value = "webSkin", method = RequestMethod.POST)
	public Model modifyWebSkin(@RequestParam("skin") String skinName, Model m) {
		try {
			responseMsg(m, true, service.modifyWebSkin(skinName));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			responseMsg(m, false, e.getMessage());
		}
		return m;
	}
	
	@RequestMapping(value = "userSign", method = RequestMethod.GET)
	public String editUserSign() {
		return "admin/settings/userSign";
	}
	
	@RequestMapping(value = "userSign", method = RequestMethod.POST)
	public Model modifyUserSign(Object[] signs, Model m) {
		try {
			service.modifyUserSign(signs);
			responseResult(m, true);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			responseMsg(m, false, e.getMessage());
		}
		return m;
	}
	
	//-------------------
	protected void response(Model m, boolean succ, String message, Object data) {
		m.addAttribute("result", succ);
		m.addAttribute("message", message);
		m.addAttribute("data", data);
	}
	protected void responseResult(Model m, boolean succ) {
		m.addAttribute("result", succ);
	}
	protected void responseMsg(Model m, boolean succ, String message) {
		m.addAttribute("result", succ);
		m.addAttribute("message", message);
	}
	protected void responseData(Model m, Object data) {
		m.addAttribute("result", true);
		m.addAttribute("data", data);
	}
}
