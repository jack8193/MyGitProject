package com.myproject.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.dao.entity.NBATeamEntity;
import com.myproject.dao.repository.NBATeamRepository;
import com.myproject.util.DateUtil;
import com.myproject.webservice.NBAWebServiceImpl;
import com.myproject.webservice.bean.NBAGameBean;
import com.myproject.webservice.bean.NBATeamBean;

@Service
public class NBAServiceImpl {

	@Autowired
	NBATeamRepository nbaTeamRepository;

	@Autowired
	NBAWebServiceImpl nbaWebService;

	private final static int NBA_SEASON_MONTH = 6;
	private final static int NBA_GAME_DATE = -1;

	private String getNBASeason(Date date) {
		String nbaSeason = null;
		Calendar c = Calendar.getInstance();

		c.setTime(date);

		// Jan ~ Jun
		if (c.get(Calendar.MONTH) < NBAServiceImpl.NBA_SEASON_MONTH) {
			c.add(Calendar.YEAR, -1); // Last year
		}

		nbaSeason = DateUtil.convertDateToString(c.getTime(), DateUtil.FORMAT_YYYY);

		return nbaSeason;
	}

	private String getNBADate(Date date) {
		String nbaDate = null;
		Calendar c = Calendar.getInstance();

		c.setTime(date);
		c.add(Calendar.DATE, NBAServiceImpl.NBA_GAME_DATE);

		nbaDate = DateUtil.convertDateToString(c.getTime(), DateUtil.FORMAT_YYYYMMDD);

		return nbaDate;
	}

	public List<NBATeamEntity> getTeams(Date season) {
		List<NBATeamEntity> result = nbaTeamRepository.findBySeason(getNBASeason(season));

		if (result == null || result.isEmpty()) {
			result = new ArrayList<NBATeamEntity>();
			List<NBATeamBean> teams = nbaWebService.getTeams(getNBASeason(season));

			if (teams != null && !teams.isEmpty()) {
				for (NBATeamBean bean : teams) {
					nbaTeamRepository.save(new NBATeamEntity(bean));
					result.add(new NBATeamEntity(bean));
				}
			}
		}

		return result;
	}

	public List<NBAGameBean> getGames(Date date) {
		List<NBAGameBean> result = nbaWebService.getGames(getNBADate(date));

		return result;
	}

}
