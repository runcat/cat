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
package net.noday.core.web;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * cat GeneralController
 * 增删改查抽象类，限定了url到方法。
 * 子类方法不用再配置映射注解，但参数中需要配置@PathVariable和@Valid
 * 方法返回值为String，配合ContentNegotiatingViewResolver使用既可以返回html又可以处理json和……
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-12-31
 * @since 
 */
public abstract class GeneralController<T> extends BaseController {

	/**
	 * url:{mapping on class}/create
	 * method:get
	 * 进入新增
	 * @return view
	 */
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public abstract String create();
	
	/**
	 * url:{mapping on class}/
	 * method:post
	 * 提交新增
	 * @param obj 新增数据对象
	 * @param result 校验信息
	 * @param m springmvc的Model
	 * @return view
	 */
	@RequestMapping(method = RequestMethod.POST)
	public abstract String save(@Valid T obj, BindingResult result, Model m);
	
	/**
	 * url:{mapping on class}/{id}
	 * method:delete
	 * 请求删除单个记录
	 * @param id 记录id
	 * @param m springmvc的Model
	 * @return view
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public abstract String delete(@PathVariable("id") long id, Model m);
	
	/**
	 * url:{mapping on class}/{id}/edit
	 * method:get
	 * 请求修改单个记录
	 * @param id 要修改的记录id
	 * @param m springmvc的Model
	 * @return view
	 */
	@RequestMapping(value = "{id}/edit", method = RequestMethod.GET)
	public abstract String edit(@PathVariable("id") long id, Model m);
	
	/**
	 * url:{mapping on class}/{id}
	 * method:post(本来想用put，但obj接收不到数据)
	 * 提交修改
	 * @param id 修改对象的id
	 * @param obj 提交的数据
	 * @param result 校验结果
	 * @param m springmvc的Model
	 * @return view
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.POST)//put收不到数据
	public abstract String modify(@PathVariable("id") long id, @Valid T obj, BindingResult result, Model m);
	
	/**
	 * url:{mapping on class}/
	 * method:get
	 * 请求列表
	 * @param m springmvc的Model
	 * @return view
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model m) {
		return list(1, m);
	}
	
	/**
	 * url:{mapping on class}/p/{index}
	 * method:get
	 * 请求指定页列表
	 * @param index 页号
	 * @param m springmvc的Model
	 * @return view
	 */
	@RequestMapping(value = "p/{index}", method = RequestMethod.GET)
	public abstract String list(@PathVariable("index") int index, Model m);
}
