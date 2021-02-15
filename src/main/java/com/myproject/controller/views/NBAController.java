package com.myproject.controller.views;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.controller.BaseController;
import com.myproject.dao.entity.NBATeamEntity;
import com.myproject.dao.repository.NBATeamRepository;
import com.myproject.model.AjaxResponse;
import com.myproject.model.constant.ResponseType;
import com.myproject.service.NBAServiceImpl;
import com.myproject.util.DateUtil;

@Controller
public class NBAController extends BaseController {
	
	@Autowired
	NBAServiceImpl nbaService;
	
	@RequestMapping("/loadNBA") 
	@ResponseBody
	public AjaxResponse loadNBA() {		
		AjaxResponse result = new AjaxResponse();

		List<NBATeamEntity> allNBATeam = nbaService.getTeams(2020);
		result.addReturnObj("nbaTeam", allNBATeam);
		
		nbaService.getGames(DateUtil.convertStringToDate("20210214", DateUtil.FORMAT_YYYYMMDD));
		
		result.setReturnCode(ResponseType.SUCCESS);
		return result;
	}
}
