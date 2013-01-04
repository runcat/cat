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
import net.noday.core.model.AppRhythmSetting;
import net.noday.core.model.AppUserSign;
import net.noday.core.model.AppWebInfo;
import net.noday.core.model.AppWebSetting;
import net.noday.core.web.BaseController;

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
public class SettingsManager extends BaseController {

//	private static final Logger log = Logger.getLogger(SettingsManager.class);
	
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
			service.modifyWebInfo(settings);
			responseResult(m, true);
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
			service.modifyWebSetting(settings);
			responseResult(m, true);
		}
		return m;
	}
	
	@RequestMapping(value = "webSkin", method = RequestMethod.GET)
	public String editWebSkin() {
		return "admin/settings/webSkin";
	}
	
	@RequestMapping(value = "webSkin", method = RequestMethod.POST)
	public Model modifyWebSkin(@RequestParam("skin") String skinName, Model m) {
		responseMsg(m, true, service.modifyWebSkin(skinName));
		return m;
	}
	
	@RequestMapping(value = "userSign", method = RequestMethod.GET)
	public String editUserSign() {
		return "admin/settings/userSign";
	}
	
	@RequestMapping(value = "userSign", method = RequestMethod.POST)
	public Model modifyUserSign(AppUserSign sign, Model m) {
		service.modifyUserSign(sign);
		responseResult(m, true);
		return m;
	}
	
	@RequestMapping(value = "socialSetting", method = RequestMethod.GET)
	public String editSocialSetting() {
		return "admin/settings/socialSetting";
	}
	
	@RequestMapping(value = "socialSetting", method = RequestMethod.POST)
	public Model modifySocialSetting(AppRhythmSetting obj, Model m) {
		service.modifySocialSetting(obj);
		responseResult(m, true);
		return m;
	}
	
	//-------------------
}
