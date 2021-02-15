package com.myproject.webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.myproject.util.JSONUtil;
import com.myproject.webservice.bean.NBAGameBean;
import com.myproject.webservice.bean.NBATeamBean;

@Service
public class NBAWebServiceImpl {

	// https://data.nba.net/prod/v1/2020/teams.json
	private final static String TEAM_URL_1 = "https://data.nba.net/prod/v1/";
	private final static String TEAM_URL_2 = "/teams.json";

	// https://data.nba.net/prod/v2/20210214/scoreboard.json
	private final static String SCORE_URL_1 = "https://data.nba.net/prod/v2/";
	private final static String SCORE_URL_2 = "/scoreboard.json";

	public List<NBATeamBean> getTeams(String season) {
		List<NBATeamBean> result = new ArrayList<NBATeamBean>();

		RestTemplate restTemplate = new RestTemplate();
		String url = NBAWebServiceImpl.TEAM_URL_1 + season + NBAWebServiceImpl.TEAM_URL_2;
		String res;
		JSONObject jsonObject;

		try {
			res = restTemplate.getForObject(url, String.class);

			if (res != null) {
				jsonObject = new JSONObject(res);

				if (JSONUtil.validJSON(jsonObject, "league")) {
					JSONObject league = (JSONObject) jsonObject.get("league");

					if (JSONUtil.validJSON(league, "standard")) {
						JSONArray standard = league.getJSONArray("standard");

						if (standard != null && standard.length() > 0) {
							for (int i = 0; i < standard.length(); i++) {
								JSONObject teamJSONObject = (JSONObject) standard.get(i);
								NBATeamBean oneTeam = new NBATeamBean();

								oneTeam.setSeason(season);
								oneTeam.setTeamId(String.valueOf(teamJSONObject.get("teamId")));
								oneTeam.setFullName(String.valueOf(teamJSONObject.get("fullName")));
								oneTeam.setTriCode(String.valueOf(teamJSONObject.get("tricode")));
								oneTeam.setConfName(String.valueOf(teamJSONObject.get("confName")));
								oneTeam.setCity(String.valueOf(teamJSONObject.get("city")));

								result.add(oneTeam);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public List<NBAGameBean> getGames(String gameDate) {
		List<NBAGameBean> result = new ArrayList<NBAGameBean>();

		RestTemplate restTemplate = new RestTemplate();
		String url = NBAWebServiceImpl.SCORE_URL_1 + gameDate + NBAWebServiceImpl.SCORE_URL_2;
		String res;
		JSONObject resJson;

		try {
			res = restTemplate.getForObject(url, String.class);

			if (res != null) {
				resJson = new JSONObject(res);

				if (JSONUtil.validJSON(resJson, "numGames")) {
					int numGames = resJson.getInt("numGames");

					// gameDate has games
					if (numGames > 0) {
						if (JSONUtil.validJSON(resJson, "games")) {
							JSONArray games = resJson.getJSONArray("games");

							for (int gameCnt = 0; gameCnt < games.length(); gameCnt++) {
								JSONObject oneGameJson = games.getJSONObject(gameCnt);
								NBAGameBean oneGameBean = parseOneGame(oneGameJson);

								result.add(oneGameBean);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	private NBAGameBean parseOneGame(JSONObject json) {
		NBAGameBean result = new NBAGameBean();

		if (json != null) {
			try {
				result.setSeason(json.getString("seasonYear"));
				result.setGameId(json.getString("gameId"));
				result.setGameType(json.getString("leagueName"));
				result.setGameDate(json.getString("homeStartDate"));
				result.setGameAttendance(json.getString("attendance"));
				result.setGameActivated(json.getString("isGameActivated"));
				result.setGameClock(json.getString("clock"));

				if (JSONUtil.validJSON(json, "gameDuration")) {
					JSONObject gameDuration = json.getJSONObject("gameDuration");
					String hour = gameDuration.getString("hours");
					String min = gameDuration.getString("minutes");

					try {
						result.setGameDuration(String.valueOf(Integer.parseInt(hour) * 60 + Integer.parseInt(min)));
					} catch (Exception e) {
						result.setGameDuration("");
					}
				}

				if (JSONUtil.validJSON(json, "arena")) {
					JSONObject arena = json.getJSONObject("arena");
					result.setArenaName(arena.getString("name"));
					result.setArenaCity(arena.getString("city"));
					result.setArenaCountry(arena.getString("country"));
				}

				if (JSONUtil.validJSON(json, "period")) {
					JSONObject period = json.getJSONObject("period");
					result.setCurrentPeriod(period.getString("current"));
				}

				if (JSONUtil.validJSON(json, "hTeam")) {
					JSONObject hTeam = json.getJSONObject("hTeam");
					result.setHomeTeamId(hTeam.getString("teamId"));
					result.setHomeTeamSeasonWin(hTeam.getString("win"));
					result.setHomeTeamSeasonLoss(hTeam.getString("loss"));
					result.setHomeTeamScore(hTeam.getString("score"));

					if (JSONUtil.validJSON(hTeam, "linescore")) {
						JSONArray linescore = hTeam.getJSONArray("linescore");
						for (int i = 0; i < linescore.length(); i++) {
							result.addHomeTeamPeriodScore(linescore.getJSONObject(i).getString("score"));
						}
					}
				}

				if (JSONUtil.validJSON(json, "vTeam")) {
					JSONObject vTeam = json.getJSONObject("vTeam");
					result.setAwayTeamId(vTeam.getString("teamId"));
					result.setAwayTeamSeasonWin(vTeam.getString("win"));
					result.setAwayTeamSeasonLoss(vTeam.getString("loss"));
					result.setAwayTeamScore(vTeam.getString("score"));

					if (JSONUtil.validJSON(vTeam, "linescore")) {
						JSONArray linescore = vTeam.getJSONArray("linescore");
						for (int i = 0; i < linescore.length(); i++) {
							result.addAwayTeamPeriodScore(linescore.getJSONObject(i).getString("score"));
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

}
