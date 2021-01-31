package com.myproject.controller.views;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/nba")
@Controller
public class NBAController {

	@RequestMapping("/")
	public ModelAndView nba() {
		ModelAndView view = new ModelAndView("views/nba");
		return view;
	}
}
