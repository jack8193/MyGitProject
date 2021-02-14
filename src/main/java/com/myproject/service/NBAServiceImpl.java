package com.myproject.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.dao.entity.NBATeamEntity;
import com.myproject.dao.repository.NBATeamRepository;
import com.myproject.webservice.NBAWebServiceImpl;
import com.myproject.webservice.bean.NBATeamBean;

@Service
public class NBAServiceImpl {

	@Autowired
	NBATeamRepository nbaTeamRepository;

	@Autowired
	NBAWebServiceImpl nbaWebService;

	public List<NBATeamEntity> getTeams(int season) {
		List<NBATeamEntity> result = nbaTeamRepository.findBySeason(season);

		if (result == null || result.isEmpty()) {
			result = new ArrayList<NBATeamEntity>();
			List<NBATeamBean> teams = nbaWebService.getTeams(season);

			if (teams != null && !teams.isEmpty()) {
				for (NBATeamBean bean : teams) {
					result.add(new NBATeamEntity(bean));
				}
			}
		}

		return result;
	}

	public void getGames(Date date) {

	}

}
