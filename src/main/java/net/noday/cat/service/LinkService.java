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
package net.noday.cat.service;

import java.util.List;

import net.noday.cat.model.Link;
import net.noday.core.pagination.Page;

/**
 * cat LinkService
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2013-1-1
 * @since 
 */
public interface LinkService {

	public abstract Link get(long id);

	public abstract long save(Link obj);

	public abstract void update(Link obj);

	public abstract void delete(Long id);

	public abstract List<Link> findAll();

	public abstract Page<Link> listPage(int index);

}