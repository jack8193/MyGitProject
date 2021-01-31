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
import com.myproject.model.constant.Constellation;
import com.myproject.model.constant.ResponseType;
import com.myproject.model.constant.Zodiac;
import com.myproject.util.DateUtil;
import com.myproject.dao.repository.StockInfoRepository;
import com.myproject.webservice.NBAWebServiceImpl;
import com.myproject.webservice.TWSEWebServiceImpl;

@Controller
public class TestIndexController extends BaseController {

	@Autowired
	StockInfoRepository stockInfoRepository;

	@Autowired
	NBAWebServiceImpl nbaWebService;

	@RequestMapping("/testIndex")
	public String hello(Model model) {
//		List<StockInfoEntity> allStockInfo = stockInfoRepository.testFind("2330", "台積電");
//
//		for (StockInfoEntity one : allStockInfo) {
//			System.out.println(one.getStockId() + "," + one.getStockName());
//		}
//
//		nbaWebService.getTeams(2020);

		ResponseType r = ResponseType.SUCCESS;
		System.out.println(r);
		System.out.println(ResponseType.valueOf("ERROR"));

		model.addAttribute("name", "01/29 Main Controller hello().");
		return "/test/testIndex";
	}
}
