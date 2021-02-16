package com.myproject.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.dao.entity.NBAGameEntity;
import com.myproject.dao.entity.NBATeamEntity;
import com.myproject.dao.repository.NBAGameRepository;
import com.myproject.dao.repository.NBATeamRepository;
import com.myproject.model.views.NBAGameVO;
import com.myproject.model.views.NBATeamVO;
import com.myproject.util.DateUtil;
import com.myproject.webservice.NBAWebServiceImpl;
import com.myproject.webservice.bean.NBAGameBean;
import com.myproject.webservice.bean.NBATeamBean;

@Service
public class NBAServiceImpl {

	@Autowired
	NBAWebServiceImpl nbaWebService;

	@Autowired
	NBATeamRepository nbaTeamRepository;

	@Autowired
	NBAGameRepository nbaGameRepository;

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

	private Date getNBADate(Date date) {
		Calendar c = Calendar.getInstance();

		c.setTime(date);
		c.add(Calendar.DATE, NBAServiceImpl.NBA_GAME_DATE);

		return c.getTime();
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

	public List<NBAGameVO> getGames(Date date) {
		List<NBAGameVO> result = new ArrayList<NBAGameVO>();
		Date gameDate = getNBADate(date);

		List<NBAGameBean> games = nbaWebService
				.getGames(DateUtil.convertDateToString(gameDate, DateUtil.FORMAT_YYYYMMDD));

		if (games != null && games.size() > 0) {
			for (NBAGameBean oneGame : games) {
				NBAGameVO gameVO = new NBAGameVO();
				gameVO.setSeason(oneGame.getSeason());

				gameVO.setGameId(oneGame.getGameId());
				gameVO.setGameType(oneGame.getGameType());
				gameVO.setGameDate(oneGame.getGameDate());
				gameVO.setGameActivated("true".equals(oneGame.getGameActivated()));
				gameVO.setGameClock(oneGame.getGameClock());
				gameVO.setCurrentPeriod(oneGame.getCurrentPeriod());

				gameVO.setArenaName(oneGame.getArenaName());
				gameVO.setArenaCity(oneGame.getArenaCity());

				gameVO.setHomeTeamScore(oneGame.getHomeTeamScore());
				gameVO.setHomeTeamPeriodScore(oneGame.getHomeTeamPeriodScore());

				gameVO.setAwayTeamScore(oneGame.getAwayTeamScore());
				gameVO.setAwayTeamPeriodScore(oneGame.getAwayTeamPeriodScore());

				List<NBATeamEntity> homeTeamEntity = nbaTeamRepository.findBySeasonAndTeamId(oneGame.getSeason(),
						oneGame.getHomeTeamId());
				if (homeTeamEntity != null && homeTeamEntity.size() > 0) {
					NBATeamVO homeTeamVO = new NBATeamVO();
					homeTeamVO.setSeason(homeTeamEntity.get(0).getSeason());
					homeTeamVO.setTeamId(homeTeamEntity.get(0).getTeamId());
					homeTeamVO.setFullName(homeTeamEntity.get(0).getFullName());
					homeTeamVO.setTriCode(homeTeamEntity.get(0).getTriCode());
					homeTeamVO.setConfName(homeTeamEntity.get(0).getConfName());
					homeTeamVO.setCity(homeTeamEntity.get(0).getCity());
					homeTeamVO.setSeasonWin(oneGame.getHomeTeamSeasonWin());
					homeTeamVO.setSeasonLoss(oneGame.getHomeTeamSeasonLoss());
					gameVO.setHomeTeam(homeTeamVO);
				}

				List<NBATeamEntity> awayTeamEntity = nbaTeamRepository.findBySeasonAndTeamId(oneGame.getSeason(),
						oneGame.getAwayTeamId());
				if (awayTeamEntity != null && awayTeamEntity.size() > 0) {
					NBATeamVO awayTeamVO = new NBATeamVO();
					awayTeamVO.setSeason(awayTeamEntity.get(0).getSeason());
					awayTeamVO.setTeamId(awayTeamEntity.get(0).getTeamId());
					awayTeamVO.setFullName(awayTeamEntity.get(0).getFullName());
					awayTeamVO.setTriCode(awayTeamEntity.get(0).getTriCode());
					awayTeamVO.setConfName(awayTeamEntity.get(0).getConfName());
					awayTeamVO.setCity(awayTeamEntity.get(0).getCity());
					awayTeamVO.setSeasonWin(oneGame.getAwayTeamSeasonWin());
					awayTeamVO.setSeasonLoss(oneGame.getAwayTeamSeasonLoss());
					gameVO.setAwayTeam(awayTeamVO);
				}

				result.add(gameVO);
				nbaGameRepository.save(new NBAGameEntity(oneGame));
			}
		}

		return result;
	}

}
