package com.myproject.controller.views;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myproject.controller.BaseController;
import com.myproject.dao.entity.NBATeamEntity;
import com.myproject.model.AjaxResponse;
import com.myproject.model.constant.ResponseType;
import com.myproject.model.views.NBAGameVO;
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
		Date nowDate = new Date();
		
		result.addReturnObj("gameDate", nowDate);

		List<NBATeamEntity> allNBATeam = nbaService.getTeams(nowDate);
		result.addReturnObj("nbaTeam", allNBATeam);

		List<NBAGameVO> allNBAGame = nbaService.getGames(nowDate);
		result.addReturnObj("nbaGame", allNBAGame);

		result.setReturnCode(ResponseType.SUCCESS);
		return result;
	}
}
