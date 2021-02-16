package com.myproject.dao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.myproject.util.DateUtil;
import com.myproject.webservice.bean.NBAGameBean;

@IdClass(NBAGameEntity.NBAGameId.class)
@Entity
@Table(name = "nba_game")
public class NBAGameEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "season")
	private String season;

	@Id
	@Column(name = "game_id")
	private String gameId;

	@Column(name = "game_date")
	private Date gameDate;

	@Column(name = "game_type")
	private String gameType;

	@Column(name = "game_activated")
	private int gameActivated = 0;

	@Column(name = "home_team_id")
	private String homeTeamId;

	@Column(name = "home_team_score")
	private int homeTeamScore = 0;

	@Column(name = "home_team_q1")
	private int homeTeamQ1 = 0;

	@Column(name = "home_team_q2")
	private int homeTeamQ2 = 0;

	@Column(name = "home_team_q3")
	private int homeTeamQ3 = 0;

	@Column(name = "home_team_q4")
	private int homeTeamQ4 = 0;

	@Column(name = "home_team_ot1")
	private int homeTeamOT1 = 0;

	@Column(name = "home_team_ot2")
	private int homeTeamOT2 = 0;

	@Column(name = "home_team_ot3")
	private int homeTeamOT3 = 0;

	@Column(name = "away_team_id")
	private String awayTeamId;

	@Column(name = "away_team_score")
	private int awayTeamScore = 0;

	@Column(name = "away_team_q1")
	private int awayTeamQ1 = 0;

	@Column(name = "away_team_q2")
	private int awayTeamQ2 = 0;

	@Column(name = "away_team_q3")
	private int awayTeamQ3 = 0;

	@Column(name = "away_team_q4")
	private int awayTeamQ4 = 0;

	@Column(name = "away_team_ot1")
	private int awayTeamOT1 = 0;

	@Column(name = "away_team_ot2")
	private int awayTeamOT2 = 0;

	@Column(name = "away_team_ot3")
	private int awayTeamOT3 = 0;

	public NBAGameEntity() {

	}

	public NBAGameEntity(NBAGameBean nbaGameBean) {
		super();
		this.season = nbaGameBean.getSeason();
		this.gameId = nbaGameBean.getGameId();
		this.gameDate = DateUtil.convertStringToDate(nbaGameBean.getGameDate(), DateUtil.FORMAT_YYYYMMDD);
		this.gameType = nbaGameBean.getGameType();
		this.gameActivated = "false".equals(nbaGameBean.getGameActivated()) ? 0 : 1;
		this.homeTeamId = nbaGameBean.getHomeTeamId();
		this.awayTeamId = nbaGameBean.getAwayTeamId();

		try {
			this.homeTeamScore = Integer.parseInt(nbaGameBean.getHomeTeamScore());

			if (nbaGameBean.getHomeTeamPeriodScore() != null && !nbaGameBean.getHomeTeamPeriodScore().isEmpty()) {
				this.homeTeamQ1 = Integer.parseInt(nbaGameBean.getHomeTeamPeriodScore().get(0));
				this.homeTeamQ2 = Integer.parseInt(nbaGameBean.getHomeTeamPeriodScore().get(1));
				this.homeTeamQ3 = Integer.parseInt(nbaGameBean.getHomeTeamPeriodScore().get(2));
				this.homeTeamQ4 = Integer.parseInt(nbaGameBean.getHomeTeamPeriodScore().get(3));

				if (nbaGameBean.getHomeTeamPeriodScore().size() > 4) {
					this.homeTeamOT1 = Integer.parseInt(nbaGameBean.getHomeTeamPeriodScore().get(4));
				}

				if (nbaGameBean.getHomeTeamPeriodScore().size() > 5) {
					this.homeTeamOT1 = Integer.parseInt(nbaGameBean.getHomeTeamPeriodScore().get(5));
				}

				if (nbaGameBean.getHomeTeamPeriodScore().size() > 6) {
					this.homeTeamOT1 = Integer.parseInt(nbaGameBean.getHomeTeamPeriodScore().get(6));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			this.awayTeamScore = Integer.parseInt(nbaGameBean.getAwayTeamScore());

			if (nbaGameBean.getAwayTeamPeriodScore() != null && !nbaGameBean.getAwayTeamPeriodScore().isEmpty()) {
				this.awayTeamQ1 = Integer.parseInt(nbaGameBean.getAwayTeamPeriodScore().get(0));
				this.awayTeamQ2 = Integer.parseInt(nbaGameBean.getAwayTeamPeriodScore().get(1));
				this.awayTeamQ3 = Integer.parseInt(nbaGameBean.getAwayTeamPeriodScore().get(2));
				this.awayTeamQ4 = Integer.parseInt(nbaGameBean.getAwayTeamPeriodScore().get(3));

				if (nbaGameBean.getAwayTeamPeriodScore().size() > 4) {
					this.awayTeamOT1 = Integer.parseInt(nbaGameBean.getAwayTeamPeriodScore().get(4));
				}

				if (nbaGameBean.getAwayTeamPeriodScore().size() > 5) {
					this.awayTeamOT1 = Integer.parseInt(nbaGameBean.getAwayTeamPeriodScore().get(5));
				}

				if (nbaGameBean.getAwayTeamPeriodScore().size() > 6) {
					this.awayTeamOT1 = Integer.parseInt(nbaGameBean.getAwayTeamPeriodScore().get(6));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public Date getGameDate() {
		return gameDate;
	}

	public void setGameDate(Date gameDate) {
		this.gameDate = gameDate;
	}

	public String getGameType() {
		return gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public int getGameActivated() {
		return gameActivated;
	}

	public void setGameActivated(int gameActivated) {
		this.gameActivated = gameActivated;
	}

	public String getHomeTeamId() {
		return homeTeamId;
	}

	public void setHomeTeamId(String homeTeamId) {
		this.homeTeamId = homeTeamId;
	}

	public int getHomeTeamScore() {
		return homeTeamScore;
	}

	public void setHomeTeamScore(int homeTeamScore) {
		this.homeTeamScore = homeTeamScore;
	}

	public int getHomeTeamQ1() {
		return homeTeamQ1;
	}

	public void setHomeTeamQ1(int homeTeamQ1) {
		this.homeTeamQ1 = homeTeamQ1;
	}

	public int getHomeTeamQ2() {
		return homeTeamQ2;
	}

	public void setHomeTeamQ2(int homeTeamQ2) {
		this.homeTeamQ2 = homeTeamQ2;
	}

	public int getHomeTeamQ3() {
		return homeTeamQ3;
	}

	public void setHomeTeamQ3(int homeTeamQ3) {
		this.homeTeamQ3 = homeTeamQ3;
	}

	public int getHomeTeamQ4() {
		return homeTeamQ4;
	}

	public void setHomeTeamQ4(int homeTeamQ4) {
		this.homeTeamQ4 = homeTeamQ4;
	}

	public int getHomeTeamOT1() {
		return homeTeamOT1;
	}

	public void setHomeTeamOT1(int homeTeamOT1) {
		this.homeTeamOT1 = homeTeamOT1;
	}

	public int getHomeTeamOT2() {
		return homeTeamOT2;
	}

	public void setHomeTeamOT2(int homeTeamOT2) {
		this.homeTeamOT2 = homeTeamOT2;
	}

	public int getHomeTeamOT3() {
		return homeTeamOT3;
	}

	public void setHomeTeamOT3(int homeTeamOT3) {
		this.homeTeamOT3 = homeTeamOT3;
	}

	public String getAwayTeamId() {
		return awayTeamId;
	}

	public void setAwayTeamId(String awayTeamId) {
		this.awayTeamId = awayTeamId;
	}

	public int getAwayTeamScore() {
		return awayTeamScore;
	}

	public void setAwayTeamScore(int awayTeamScore) {
		this.awayTeamScore = awayTeamScore;
	}

	public int getAwayTeamQ1() {
		return awayTeamQ1;
	}

	public void setAwayTeamQ1(int awayTeamQ1) {
		this.awayTeamQ1 = awayTeamQ1;
	}

	public int getAwayTeamQ2() {
		return awayTeamQ2;
	}

	public void setAwayTeamQ2(int awayTeamQ2) {
		this.awayTeamQ2 = awayTeamQ2;
	}

	public int getAwayTeamQ3() {
		return awayTeamQ3;
	}

	public void setAwayTeamQ3(int awayTeamQ3) {
		this.awayTeamQ3 = awayTeamQ3;
	}

	public int getAwayTeamQ4() {
		return awayTeamQ4;
	}

	public void setAwayTeamQ4(int awayTeamQ4) {
		this.awayTeamQ4 = awayTeamQ4;
	}

	public int getAwayTeamOT1() {
		return awayTeamOT1;
	}

	public void setAwayTeamOT1(int awayTeamOT1) {
		this.awayTeamOT1 = awayTeamOT1;
	}

	public int getAwayTeamOT2() {
		return awayTeamOT2;
	}

	public void setAwayTeamOT2(int awayTeamOT2) {
		this.awayTeamOT2 = awayTeamOT2;
	}

	public int getAwayTeamOT3() {
		return awayTeamOT3;
	}

	public void setAwayTeamOT3(int awayTeamOT3) {
		this.awayTeamOT3 = awayTeamOT3;
	}

	@Override
	public String toString() {
		return "NBAGameEntity [season=" + season + ", gameId=" + gameId + ", gameDate=" + gameDate + ", gameType="
				+ gameType + ", gameActivated=" + gameActivated + ", homeTeamId=" + homeTeamId + ", homeTeamScore="
				+ homeTeamScore + ", homeTeamQ1=" + homeTeamQ1 + ", homeTeamQ2=" + homeTeamQ2 + ", homeTeamQ3="
				+ homeTeamQ3 + ", homeTeamQ4=" + homeTeamQ4 + ", homeTeamOT1=" + homeTeamOT1 + ", homeTeamOT2="
				+ homeTeamOT2 + ", homeTeamOT3=" + homeTeamOT3 + ", awayTeamId=" + awayTeamId + ", awayTeamScore="
				+ awayTeamScore + ", awayTeamQ1=" + awayTeamQ1 + ", awayTeamQ2=" + awayTeamQ2 + ", awayTeamQ3="
				+ awayTeamQ3 + ", awayTeamQ4=" + awayTeamQ4 + ", awayTeamOT1=" + awayTeamOT1 + ", awayTeamOT2="
				+ awayTeamOT2 + ", awayTeamOT3=" + awayTeamOT3 + "]";
	}

	public static class NBAGameId implements Serializable {
		private static final long serialVersionUID = 1L;

		private String season;
		private String gameId;

		public String getSeason() {
			return season;
		}

		public void setSeason(String season) {
			this.season = season;
		}

		public String getGameId() {
			return gameId;
		}

		public void setGameId(String gameId) {
			this.gameId = gameId;
		}

	}

}
