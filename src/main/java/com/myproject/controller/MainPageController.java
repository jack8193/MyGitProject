package com.myproject.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.model.AjaxResponse;
import com.myproject.model.constant.ResponseType;
import com.myproject.model.main.MenuItem;
import com.myproject.model.main.Version;
import com.myproject.util.DateUtil;

@Controller
public class MainPageController extends BaseController {

	@RequestMapping("/")
	public String mainPage(Map<String, Object> model) {
		ModelAndView view = new ModelAndView("mainPage");
		view.addObject("copyright", Version.getCopyRight());

		return "mainPage";
	}

	@RequestMapping("/loadMainPage")
	@ResponseBody
	public AjaxResponse loadMainPage() {
		AjaxResponse result = new AjaxResponse();

		MenuItem m1 = new MenuItem();
		m1.setMenuId("menuId1");
		m1.setWording("NBA btn");
		m1.setUrl("html/views/nba.html");
		m1.setShow(true);

		MenuItem m2 = new MenuItem();
		m2.setMenuId("menuId2");
		m2.setWording("Stock btn");
		m2.setUrl("html/views/stock.html");
		m2.setShow(true);

		List<MenuItem> l = new ArrayList<MenuItem>();
		l.add(m1);
		l.add(m2);

		result.setReturnObj("menu", l);

		result.setReturnCode(ResponseType.SUCCESS);
		return result;
	}

	@RequestMapping("/stock")
	public ModelAndView stock() {
		ModelAndView view = new ModelAndView("views/stock");
		return view;
	}

}
