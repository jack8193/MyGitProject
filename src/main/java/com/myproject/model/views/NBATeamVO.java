package com.myproject.model.views;

public class NBATeamVO {

	private String season;

	private String teamId;
	private String fullName;
	private String triCode;
	private String confName;
	private String city;

	private String seasonWin;
	private String seasonLoss;

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getTriCode() {
		return triCode;
	}

	public void setTriCode(String triCode) {
		this.triCode = triCode;
	}

	public String getConfName() {
		return confName;
	}

	public void setConfName(String confName) {
		this.confName = confName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSeasonWin() {
		return seasonWin;
	}

	public void setSeasonWin(String seasonWin) {
		this.seasonWin = seasonWin;
	}

	public String getSeasonLoss() {
		return seasonLoss;
	}

	public void setSeasonLoss(String seasonLoss) {
		this.seasonLoss = seasonLoss;
	}

	@Override
	public String toString() {
		return "NBATeamVO [season=" + season + ", teamId=" + teamId + ", fullName=" + fullName + ", triCode=" + triCode
				+ ", confName=" + confName + ", city=" + city + ", seasonWin=" + seasonWin + ", seasonLoss="
				+ seasonLoss + "]";
	}

}
