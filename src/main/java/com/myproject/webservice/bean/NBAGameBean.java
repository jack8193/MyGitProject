package com.myproject.webservice.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NBAGameBean {

	private int season;

	private String gameId;
	private String gameType;
	private Date gameDate;
	private int gameAttendance;
	private boolean isGameActivated;
	private String gameClock;
	private int gameDuration;

	private String arenaName;
	private String arenaCity;
	private String arenaCountry;

	private int currentPeriod;

	private String homeTeamId;
	private int homeTeamSeasonWin;
	private int homeTeamSeasonLoss;
	private int homeTeamScore;
	private List<Integer> homeTeamPeriodScore;

	private String awayTeamId;
	private int awayTeamSeasonWin;
	private int awayTeamSeasonLoss;
	private int awayTeamScore;
	private List<Integer> awayTeamPeriodScore;

	public int getSeason() {
		return season;
	}

	public void setSeason(int season) {
		this.season = season;
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public String getGameType() {
		return gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public Date getGameDate() {
		return gameDate;
	}

	public void setGameDate(Date gameDate) {
		this.gameDate = gameDate;
	}

	public int getGameAttendance() {
		return gameAttendance;
	}

	public void setGameAttendance(int gameAttendance) {
		this.gameAttendance = gameAttendance;
	}

	public boolean isGameActivated() {
		return isGameActivated;
	}

	public void setGameActivated(boolean isGameActivated) {
		this.isGameActivated = isGameActivated;
	}

	public int getGameDuration() {
		return gameDuration;
	}

	public void setGameDuration(int gameDuration) {
		this.gameDuration = gameDuration;
	}

	public String getArenaName() {
		return arenaName;
	}

	public void setArenaName(String arenaName) {
		this.arenaName = arenaName;
	}

	public String getArenaCity() {
		return arenaCity;
	}

	public void setArenaCity(String arenaCity) {
		this.arenaCity = arenaCity;
	}

	public String getArenaCountry() {
		return arenaCountry;
	}

	public void setArenaCountry(String arenaCountry) {
		this.arenaCountry = arenaCountry;
	}

	public int getCurrentPeriod() {
		return currentPeriod;
	}

	public void setCurrentPeriod(int currentPeriod) {
		this.currentPeriod = currentPeriod;
	}

	public String getHomeTeamId() {
		return homeTeamId;
	}

	public void setHomeTeamId(String homeTeamId) {
		this.homeTeamId = homeTeamId;
	}

	public int getHomeTeamSeasonWin() {
		return homeTeamSeasonWin;
	}

	public void setHomeTeamSeasonWin(int homeTeamSeasonWin) {
		this.homeTeamSeasonWin = homeTeamSeasonWin;
	}

	public int getHomeTeamSeasonLoss() {
		return homeTeamSeasonLoss;
	}

	public void setHomeTeamSeasonLoss(int homeTeamSeasonLoss) {
		this.homeTeamSeasonLoss = homeTeamSeasonLoss;
	}

	public int getHomeTeamScore() {
		return homeTeamScore;
	}

	public void setHomeTeamScore(int homeTeamScore) {
		this.homeTeamScore = homeTeamScore;
	}

	public List<Integer> getHomeTeamPeriodScore() {
		return homeTeamPeriodScore;
	}

	public void addHomeTeamPeriodScore(int homeTeamPeriodScore) {
		if (getHomeTeamPeriodScore() == null) {
			this.homeTeamPeriodScore = new ArrayList<Integer>();
		}
		this.homeTeamPeriodScore.add(homeTeamPeriodScore);
	}

	public String getAwayTeamId() {
		return awayTeamId;
	}

	public void setAwayTeamId(String awayTeamId) {
		this.awayTeamId = awayTeamId;
	}

	public int getAwayTeamSeasonWin() {
		return awayTeamSeasonWin;
	}

	public void setAwayTeamSeasonWin(int awayTeamSeasonWin) {
		this.awayTeamSeasonWin = awayTeamSeasonWin;
	}

	public int getAwayTeamSeasonLoss() {
		return awayTeamSeasonLoss;
	}

	public void setAwayTeamSeasonLoss(int awayTeamSeasonLoss) {
		this.awayTeamSeasonLoss = awayTeamSeasonLoss;
	}

	public int getAwayTeamScore() {
		return awayTeamScore;
	}

	public void setAwayTeamScore(int awayTeamScore) {
		this.awayTeamScore = awayTeamScore;
	}

	public List<Integer> getAwayTeamPeriodScore() {
		return awayTeamPeriodScore;
	}

	public void addAwayTeamPeriodScore(int awayTeamPeriodScore) {
		if (getAwayTeamPeriodScore() == null) {
			this.awayTeamPeriodScore = new ArrayList<Integer>();
		}
		this.awayTeamPeriodScore.add(awayTeamPeriodScore);
	}

	public String getGameClock() {
		return gameClock;
	}

	public void setGameClock(String gameClock) {
		this.gameClock = gameClock;
	}

	@Override
	public String toString() {
		return "NBAGameBean [season=" + season + ", gameId=" + gameId + ", gameType=" + gameType + ", gameDate="
				+ gameDate + ", gameAttendance=" + gameAttendance + ", isGameActivated=" + isGameActivated
				+ ", gameClock=" + gameClock + ", gameDuration=" + gameDuration + ", arenaName=" + arenaName
				+ ", arenaCity=" + arenaCity + ", arenaCountry=" + arenaCountry + ", currentPeriod=" + currentPeriod
				+ ", homeTeamId=" + homeTeamId + ", homeTeamSeasonWin=" + homeTeamSeasonWin + ", homeTeamSeasonLoss="
				+ homeTeamSeasonLoss + ", homeTeamScore=" + homeTeamScore + ", homeTeamPeriodScore="
				+ homeTeamPeriodScore + ", awayTeamId=" + awayTeamId + ", awayTeamSeasonWin=" + awayTeamSeasonWin
				+ ", awayTeamSeasonLoss=" + awayTeamSeasonLoss + ", awayTeamScore=" + awayTeamScore
				+ ", awayTeamPeriodScore=" + awayTeamPeriodScore + "]";
	}

}
