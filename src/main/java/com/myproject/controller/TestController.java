package com.myproject.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.model.AjaxResponse;

@Controller
public class TestController {
	
	@RequestMapping("/testPage")
	public ModelAndView testPage() {
		ModelAndView view = new ModelAndView("test/TestPage");

		view.addObject("name", "This is from /test/testPage().");

		return view;
	}
	
	/**
	 * Angular JS Ajax
	 */
	@RequestMapping("/testAngularJS")
	@ResponseBody
	public AjaxResponse testAngularJS() {
		AjaxResponse result = new AjaxResponse();
		Map<String, Object> obj = new HashMap<String, Object>();

		obj.put("testAngularJSKey", "thisTestAngularJSValue");

		result.setReturnCode("testAngularJS SUCCESS");
		result.setReturnObj(obj);

		return result;
	}

	/**
	 * JavaScript Ajax
	 */
	@RequestMapping("/testJSAjax")
	@ResponseBody
	public AjaxResponse test2() {
		AjaxResponse result = new AjaxResponse();
		Map<String, Object> obj = new HashMap<String, Object>();

		obj.put("testJSAjaxKey", "testJSAjaxValue");

		result.setReturnCode("SUCCESS");
		result.setReturnObj(obj);

		return result;
	}
	
}
