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
package net.noday.cat.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import net.noday.cat.dao.SettingsDao;
import net.noday.cat.service.SettingsService;
import net.noday.core.model.App;
import net.noday.core.model.AppRhythmSetting;
import net.noday.core.model.AppUserSign;
import net.noday.core.model.AppWebInfo;
import net.noday.core.model.AppWebSetting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * cat SettingsService
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-12-20
 * @since 
 */
@Service
public class SettingsServiceImpl implements SettingsService {
	
	@Autowired private SettingsDao dao;
	@Resource private Map<String, Object> appCache;

	/* (non-Javadoc)
	 * @see net.noday.cat.service.impl.SettingsService#modifyWebInfo(net.noday.core.model.AppWebInfo)
	 */
	@Override
	public void modifyWebInfo(AppWebInfo app) {
		dao.updateWebInfo(app);
		getCfgs().update(app);
	}
	
	/* (non-Javadoc)
	 * @see net.noday.cat.service.impl.SettingsService#modifyWebSetting(net.noday.core.model.AppWebSetting)
	 */
	@Override
	public void modifyWebSetting(AppWebSetting app) {
		dao.updateWebSetting(app);
		getCfgs().update(app);
	}
	
	/* (non-Javadoc)
	 * @see net.noday.cat.service.impl.SettingsService#modifyWebSkin(java.lang.String)
	 */
	@Override
	public String modifyWebSkin(String skinName) {
		if (!getCfgs().hasSkin(skinName)) {
			skinName = getCfgs().getSkins().get(0);
		}
		dao.updateWebSkin(skinName);
		getCfgs().setSkin(skinName);
		return skinName;
	}
	
	/* (non-Javadoc)
	 * @see net.noday.cat.service.impl.SettingsService#modifyUserSign(java.lang.Object)
	 */
	@Override
	public void modifyUserSign(AppUserSign sign) {
		dao.updateUserSign(sign);
		getCfgs().update(sign);
	}
	
	/* (non-Javadoc)
	 * @see net.noday.cat.service.impl.SettingsService#modifySocialSetting(java.lang.Object)
	 */
	@Override
	public void modifySocialSetting(AppRhythmSetting obj) {
		dao.modifySocialSetting(obj);
		getCfgs().update(obj);
	}
	
	/* (non-Javadoc)
	 * @see net.noday.cat.service.impl.SettingsService#modifyDuoshuoSetting(java.lang.String)
	 */
	@Override
	public void modifyDuoshuoSetting(String obj) {
		dao.modifySocialSetting(obj);
		getCfgs().setDuoshuoKey(obj);
	}
	
	protected App getCfgs() {
		return (App) appCache.get("cfg");
	}
}
