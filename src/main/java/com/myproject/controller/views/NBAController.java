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

@Controller
public class NBAController extends BaseController {
	
	@Autowired
	NBATeamRepository nbaTeamRepository;
	
	@RequestMapping("/loadNBA") 
	@ResponseBody
	public AjaxResponse loadNBA() {		
		AjaxResponse result = new AjaxResponse();

		List<NBATeamEntity> allNBATeam = nbaTeamRepository.findAll();
		result.addReturnObj("nbaTeam", allNBATeam);
		
		result.setReturnCode(ResponseType.SUCCESS);
		return result;
	}
}
