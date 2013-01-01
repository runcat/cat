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

import java.util.List;

import net.noday.cat.dao.LinkDao;
import net.noday.cat.model.Link;
import net.noday.cat.service.LinkService;
import net.noday.core.pagination.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * cat LinkService
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-12-28
 * @since 
 */
@Service
public class LinkServiceImpl implements LinkService {

	@Autowired private LinkDao dao;
	
	/* (non-Javadoc)
	 * @see net.noday.cat.service.impl.LinkService#get(long)
	 */
	@Override
	public Link get(long id) {
		return dao.get(id);
	}
	
	/* (non-Javadoc)
	 * @see net.noday.cat.service.impl.LinkService#save(net.noday.cat.model.Link)
	 */
	@Override
	public long save(Link obj) {
		long aid = dao.save(obj);
		return aid;
	}
	
	/* (non-Javadoc)
	 * @see net.noday.cat.service.impl.LinkService#update(net.noday.cat.model.Link)
	 */
	@Override
	public void update(Link obj) {
		dao.update(obj);
	}
	
	/* (non-Javadoc)
	 * @see net.noday.cat.service.impl.LinkService#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long id) {
		dao.delete(id);
	}
	
	/* (non-Javadoc)
	 * @see net.noday.cat.service.impl.LinkService#findAll()
	 */
	@Override
	public List<Link> findAll() {
		return dao.findAll();
	}
	
	/* (non-Javadoc)
	 * @see net.noday.cat.service.impl.LinkService#listPage(int)
	 */
	@Override
	public Page<Link> listPage(int index) {
		Page<Link> page = new Page<Link>(index, Page.DEFAULTSIZE);
		page.setRowCount(dao.findCount());
		page.setRows(dao.findByPage(page.getPageIndex(), page.getSize()));
		return page;
	}
	
}
