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
package net.noday.cat.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import net.noday.cat.dao.TagDao;
import net.noday.cat.model.Tag;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * cat TagService
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-12-25
 * @since 
 */
@Service
public class TagService {

	@Autowired private TagDao dao;
	@Resource private Map<String, Object> appCache;
	
	public List<Tag> findAll() {
		return dao.findAll();
	}
	
	public void save(long aid, String tagStr) {
		@SuppressWarnings("unchecked")
		Set<Tag> tags = (Set<Tag>) appCache.get("tags");
		String[] ts = StringUtils.split(tagStr, ",");
		for (String tag : ts) {
			if (tags.contains(tag)) {
				dao.updateTagRefCount(tag);
			} else {
				tags.add(dao.saveTagAndRef(aid, tag));
			}
		}
	}
	
	public void update(long aid, String tagStr) {
		@SuppressWarnings("unchecked")
		Set<Tag> tags = (Set<Tag>) appCache.get("tags");
		String[] ts = StringUtils.split(tagStr, ",");
		for (String tag : ts) {
			if (tags.contains(tag)) {
				dao.updateTagRef(aid, tag);
			} else {
				tags.add(tag);
				dao.saveTagAndRef(aid, tag);
			}
		}
	}
}
