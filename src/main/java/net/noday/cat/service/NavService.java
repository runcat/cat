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

import net.noday.cat.dao.NavDao;
import net.noday.cat.model.Nav;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * cat NavService
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-12-29
 * @since 
 */
@Service
public class NavService {

	@Autowired private NavDao dao;
	
	public Nav get(long id) {
		return dao.get(id);
	}
	
	public long save(Nav obj) {
		long aid = dao.save(obj);
		return aid;
	}
	
	public void update(Nav obj) {
		dao.update(obj);
	}
	
	public void delete(Long id) {
		dao.delete(id);
	}
	
	public List<Nav> findAll() {
		return dao.findAll();
	}
}
