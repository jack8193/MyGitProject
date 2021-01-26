package com.myproject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.dao.entity.StockInfoEntity;
import com.myproject.model.AjaxResponse;
import com.myproject.dao.repository.StockInfoRepository;
import com.myproject.webservice.NBAWebServiceImpl;
import com.myproject.webservice.TWSEWebServiceImpl;

@Controller
public class MainController {

	@Autowired
	StockInfoRepository stockInfoRepository;

	@RequestMapping("/")
	public String hello(Model model) {
//		List<StockInfoEntity> allStockInfo = stockInfoRepository.testFind("2330", "台積電");
//
//		for (StockInfoEntity one : allStockInfo) {
//			System.out.println(one.getStockId() + "," + one.getStockName());
//		}

		NBAWebServiceImpl.getTeams(2020);

		model.addAttribute("name", "Main Controller hello().");
		return "TestIndex";
	}
}
