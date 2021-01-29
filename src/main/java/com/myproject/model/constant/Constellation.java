package com.myproject.model.constant;

import java.util.Calendar;
import java.util.Date;

public enum Constellation {

	AQUARIUS("水瓶座", "the Water Carrier", 21), //  January 1/21 ~ 2/18
	PISCES("雙魚座", "the Two Fish", 19), //  February 2/19 ~ 3/20
	ARIES("牡羊座", "the Ram", 21), //  March 3/21 ~ 4/20
	TAURUS("金牛座", "the Bull", 21), //  April 4/21 ~ 5/20
	GEMINI("雙子座", "the Twins", 21), //  May 5/21 ~ 6/21
	CANCER("巨蟹座", "the Crab", 22), //  June 6/22 ~ 7/22
	LEO("獅子座", "the Lion", 23), //  July 7/23 ~ 8/22
	VIRGO("處女座", "the Virgin", 23), //  August 8/23 ~ 9/22
	LIBRA("天秤座", "the Scales", 23), //  Septemper 9/23 ~ 10/23
	SCORPIO("天蠍座", "the Scorpion", 24), //  October 10/24 ~ 11/22
	SAGITTARIUS("射手座", "the Archer", 23), //  November 11/23 ~ 12/21
	CAPRICORN("摩羯座", "the Goat", 22), //  December 12/22 ~ 1/20
	UNDEFINED("無定義", "undefined", 0);

	private String sign;
	private String title;
	private int dateOfMonth;

	private Constellation(String sign, String title, int dateOfMonth) {
		this.sign = sign;
		this.title = title;
		this.dateOfMonth = dateOfMonth;
	}

	public static String getSign(Constellation constellation) {
		return constellation.sign;
	}
	
	public static String getTitle(Constellation constellation) {
		return constellation.title;
	}

	public static Constellation getConstellation(Date birth) {
		Constellation result;
		try {
			Calendar c = Calendar.getInstance();
			c.setTime(birth);

			int month = c.get(Calendar.MONTH);
			result = Constellation.values()[month];

			if (c.get(Calendar.DATE) < result.dateOfMonth) {
				if (month == 0) { // birth = january
					month = 12;
				}
				result = Constellation.values()[month - 1];
			}

			return result;
		} catch (Exception e) {
			return Constellation.UNDEFINED;
		}
	}

}
