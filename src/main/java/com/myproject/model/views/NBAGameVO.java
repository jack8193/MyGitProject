package com.myproject.model.views;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NBAGameVO {

	private String season;

	private String gameId;
	private String gameType;
	private String gameDate;
	private boolean gameActivated;
	private String gameClock;
	private String currentPeriod;

	private String arenaName;
	private String arenaCity;

	private NBATeamVO homeTeam;
	private String homeTeamScore;
	private List<String> homeTeamPeriodScore;

	private NBATeamVO awayTeam;
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

	public boolean isGameActivated() {
		return gameActivated;
	}

	public void setGameActivated(boolean gameActivated) {
		this.gameActivated = gameActivated;
	}

	public String getGameClock() {
		return gameClock;
	}

	public void setGameClock(String gameClock) {
		this.gameClock = gameClock;
	}

	public String getCurrentPeriod() {
		return currentPeriod;
	}

	public void setCurrentPeriod(String currentPeriod) {
		this.currentPeriod = currentPeriod;
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

	public NBATeamVO getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(NBATeamVO homeTeam) {
		this.homeTeam = homeTeam;
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

	public void setHomeTeamPeriodScore(List<String> homeTeamPeriodScore) {
		this.homeTeamPeriodScore = homeTeamPeriodScore;
	}

	public NBATeamVO getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(NBATeamVO awayTeam) {
		this.awayTeam = awayTeam;
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

	public void setAwayTeamPeriodScore(List<String> awayTeamPeriodScore) {
		this.awayTeamPeriodScore = awayTeamPeriodScore;
	}

	@Override
	public String toString() {
		return "NBAGameVO [season=" + season + ", gameId=" + gameId + ", gameType=" + gameType + ", gameDate="
				+ gameDate + ", gameActivated=" + gameActivated + ", gameClock=" + gameClock + ", currentPeriod="
				+ currentPeriod + ", arenaName=" + arenaName + ", arenaCity=" + arenaCity + ", homeTeam=" + homeTeam
				+ ", homeTeamScore=" + homeTeamScore + ", homeTeamPeriodScore=" + homeTeamPeriodScore + ", awayTeam="
				+ awayTeam + ", awayTeamScore=" + awayTeamScore + ", awayTeamPeriodScore=" + awayTeamPeriodScore + "]";
	}

}
