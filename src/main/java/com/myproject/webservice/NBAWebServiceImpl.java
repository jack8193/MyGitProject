package com.myproject.webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import com.myproject.util.JSONUtil;
import com.myproject.webservice.bean.NBATeamBean;

public class NBAWebServiceImpl {

	private final static String TEAM_URL = "https://data.nba.net/prod/v1/2020/teams.json";
	private final static String SCORE_URL = "https://data.nba.net/prod/v2/20210122/scoreboard.json";

	public static List<NBATeamBean> getTeams(int season) {
		List<NBATeamBean> teams = new ArrayList<NBATeamBean>();

		RestTemplate restTemplate = new RestTemplate();
		String res;
		JSONObject jsonObject;

		try {
			res = restTemplate.getForObject(NBAWebServiceImpl.TEAM_URL, String.class);

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
								
								System.out.println(i+":"+oneTeam);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return teams;
	}

	public static void test() {
		RestTemplate restTemplate = new RestTemplate();
		String res = restTemplate.getForObject(NBAWebServiceImpl.TEAM_URL, String.class);

		JSONObject jo = null;
		try {
			jo = new JSONObject(res);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			System.out.println("new JSONObject() error!");
		}

		System.out.println(res);
		System.out.println("-----");
		System.out.println(jo);
	}

}
