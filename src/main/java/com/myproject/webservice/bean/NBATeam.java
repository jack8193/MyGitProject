package com.myproject.webservice.bean;

public class NBATeam {

	private int season;
	private String teamId;
	private String fullName;
	private String triCode;
	private String confName;
	private String city;

	public int getSeason() {
		return season;
	}

	public void setSeason(int season) {
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

	@Override
	public String toString() {
		return "NBATeam [season=" + season + ", teamId=" + teamId + ", fullName=" + fullName + ", triCode=" + triCode
				+ ", confName=" + confName + ", city=" + city + "]";
	}

}
