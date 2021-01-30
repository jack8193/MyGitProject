package com.myproject.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.model.AjaxResponse;
import com.myproject.model.main.MenuItem;

@Controller
public class MainPageController extends BaseController {

	@RequestMapping("/")
	public ModelAndView mainPage() {
		ModelAndView view = new ModelAndView("mainPage");

		view.addObject("name", "This is from MainPageController....");

		return view;
	}
	
	@RequestMapping("/loadMainPage")
	@ResponseBody
	public AjaxResponse loadMainPage() {
		AjaxResponse result = new AjaxResponse();
		
		MenuItem m1 = new MenuItem();
		m1.setMenuId("menuId1");
		m1.setUrl("/nba");
		
		MenuItem m2 = new MenuItem();
		m2.setMenuId("menuId2");
		m2.setUrl("/stock");
		
		List<MenuItem> l = new ArrayList<MenuItem>();
		l.add(m1);
		l.add(m2);
		
		result.setReturnObj("menu", l);
		
		result.setMessage("MainPageController : loadMainPage() completed.");
		return result;
	}
	
	@RequestMapping("/nba")
	public ModelAndView nba() {
		ModelAndView view = new ModelAndView("views/nba");
		return view;
	}
	
	@RequestMapping("/stock")
	public ModelAndView stock() {
		ModelAndView view = new ModelAndView("views/stock");
		return view;
	}
	
}
