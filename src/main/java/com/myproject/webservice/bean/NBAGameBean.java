package com.myproject.webservice.bean;

import java.util.ArrayList;
import java.util.List;

public class NBAGameBean {

	private String season;

	private String gameId;
	private String gameType;
	private String gameDate;
	private String gameAttendance;
	private String gameActivated;
	private String gameClock;
	private String gameDuration;

	private String arenaName;
	private String arenaCity;
	private String arenaCountry;

	private String currentPeriod;

	private String homeTeamId;
	private String homeTeamSeasonWin;
	private String homeTeamSeasonLoss;
	private String homeTeamScore;
	private List<String> homeTeamPeriodScore;

	private String awayTeamId;
	private String awayTeamSeasonWin;
	private String awayTeamSeasonLoss;
	private String awayTeamScore;
	private List<String> awayTeamPeriodScore;

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

	public String getGameType() {
		return gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public String getGameDate() {
		return gameDate;
	}

	public void setGameDate(String gameDate) {
		this.gameDate = gameDate;
	}

	public String getGameAttendance() {
		return gameAttendance;
	}

	public void setGameAttendance(String gameAttendance) {
		this.gameAttendance = gameAttendance;
	}

	public String getGameActivated() {
		return gameActivated;
	}

	public void setGameActivated(String gameActivated) {
		this.gameActivated = gameActivated;
	}

	public String getGameClock() {
		return gameClock;
	}

	public void setGameClock(String gameClock) {
		this.gameClock = gameClock;
	}

	public String getGameDuration() {
		return gameDuration;
	}

	public void setGameDuration(String gameDuration) {
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

	public String getCurrentPeriod() {
		return currentPeriod;
	}

	public void setCurrentPeriod(String currentPeriod) {
		this.currentPeriod = currentPeriod;
	}

	public String getHomeTeamId() {
		return homeTeamId;
	}

	public void setHomeTeamId(String homeTeamId) {
		this.homeTeamId = homeTeamId;
	}

	public String getHomeTeamSeasonWin() {
		return homeTeamSeasonWin;
	}

	public void setHomeTeamSeasonWin(String homeTeamSeasonWin) {
		this.homeTeamSeasonWin = homeTeamSeasonWin;
	}

	public String getHomeTeamSeasonLoss() {
		return homeTeamSeasonLoss;
	}

	public void setHomeTeamSeasonLoss(String homeTeamSeasonLoss) {
		this.homeTeamSeasonLoss = homeTeamSeasonLoss;
	}

	public String getHomeTeamScore() {
		return homeTeamScore;
	}

	public void setHomeTeamScore(String homeTeamScore) {
		this.homeTeamScore = homeTeamScore;
	}

	public List<String> getHomeTeamPeriodScore() {
		return homeTeamPeriodScore;
	}

	public void addHomeTeamPeriodScore(String homeTeamPeriodScore) {
		if (getHomeTeamPeriodScore() == null) {
			this.homeTeamPeriodScore = new ArrayList<String>();
		}
		this.homeTeamPeriodScore.add(homeTeamPeriodScore);
	}

	public String getAwayTeamId() {
		return awayTeamId;
	}

	public void setAwayTeamId(String awayTeamId) {
		this.awayTeamId = awayTeamId;
	}

	public String getAwayTeamSeasonWin() {
		return awayTeamSeasonWin;
	}

	public void setAwayTeamSeasonWin(String awayTeamSeasonWin) {
		this.awayTeamSeasonWin = awayTeamSeasonWin;
	}

	public String getAwayTeamSeasonLoss() {
		return awayTeamSeasonLoss;
	}

	public void setAwayTeamSeasonLoss(String awayTeamSeasonLoss) {
		this.awayTeamSeasonLoss = awayTeamSeasonLoss;
	}

	public String getAwayTeamScore() {
		return awayTeamScore;
	}

	public void setAwayTeamScore(String awayTeamScore) {
		this.awayTeamScore = awayTeamScore;
	}

	public List<String> getAwayTeamPeriodScore() {
		return awayTeamPeriodScore;
	}

	public void addAwayTeamPeriodScore(String awayTeamPeriodScore) {
		if (getAwayTeamPeriodScore() == null) {
			this.awayTeamPeriodScore = new ArrayList<String>();
		}
		this.awayTeamPeriodScore.add(awayTeamPeriodScore);
	}

	@Override
	public String toString() {
		return "NBAGameBean [season=" + season + ", gameId=" + gameId + ", gameType=" + gameType + ", gameDate="
				+ gameDate + ", gameAttendance=" + gameAttendance + ", gameActivated=" + gameActivated + ", gameClock="
				+ gameClock + ", gameDuration=" + gameDuration + ", arenaName=" + arenaName + ", arenaCity=" + arenaCity
				+ ", arenaCountry=" + arenaCountry + ", currentPeriod=" + currentPeriod + ", homeTeamId=" + homeTeamId
				+ ", homeTeamSeasonWin=" + homeTeamSeasonWin + ", homeTeamSeasonLoss=" + homeTeamSeasonLoss
				+ ", homeTeamScore=" + homeTeamScore + ", homeTeamPeriodScore=" + homeTeamPeriodScore + ", awayTeamId="
				+ awayTeamId + ", awayTeamSeasonWin=" + awayTeamSeasonWin + ", awayTeamSeasonLoss=" + awayTeamSeasonLoss
				+ ", awayTeamScore=" + awayTeamScore + ", awayTeamPeriodScore=" + awayTeamPeriodScore + "]";
	}

}
