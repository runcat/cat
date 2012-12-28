package net.noday.core.web;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public abstract class GeneralController<T> extends BaseController {

	@RequestMapping(value = "create", method = RequestMethod.GET)
	public abstract String create();
	
	@RequestMapping(method = RequestMethod.POST)
	public abstract String save(@Valid T obj, BindingResult result, Model m);
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public abstract String delete(@PathVariable("id") long id, Model m);
	
	@RequestMapping(value = "{id}/edit", method = RequestMethod.GET)
	public abstract String edit(@PathVariable("id") long id, Model m);
	
	@RequestMapping(value = "{id}", method = RequestMethod.POST)//put收不到数据
	public abstract String modify(@PathVariable("id") long id, @Valid T obj, BindingResult result, Model m);
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model m) {
		return list(1, m);
	}
	
	@RequestMapping(value = "p/{index}", method = RequestMethod.GET)
	public abstract String list(@PathVariable("index") int index, Model m);
}
