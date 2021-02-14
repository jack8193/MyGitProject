package com.myproject.dao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.myproject.webservice.bean.NBATeamBean;

@IdClass(NBATeamEntity.NBATeamId.class)
@Entity
@Table(name = "nba_team")
public class NBATeamEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="season")
	private int season;
	
	@Id
	@Column(name="team_id")
	private String teamId;
	
	@Column(name="full_name")
	private String fullName;
	
	@Column(name="tri_code")
	private String triCode;
	
	@Column(name="conf_name")
	private String confName;
	
	@Column(name="city")
	private String city;
	
	public NBATeamEntity() {
		
	}

	public NBATeamEntity(NBATeamBean nbaTeamBean) {
		super();
		this.season = nbaTeamBean.getSeason();
		this.teamId = nbaTeamBean.getTeamId();
		this.fullName = nbaTeamBean.getFullName();
		this.triCode = nbaTeamBean.getTriCode();
		this.confName = nbaTeamBean.getConfName();
		this.city = nbaTeamBean.getCity();
	}

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
		return "NBATeamEntity [season=" + season + ", teamId=" + teamId + ", fullName=" + fullName + ", triCode="
				+ triCode + ", confName=" + confName + ", city=" + city + "]";
	}

	public static class NBATeamId implements Serializable {
		private static final long serialVersionUID = 1L;
		
		private int season;
		private String teamId;
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
		
	}
	
}
