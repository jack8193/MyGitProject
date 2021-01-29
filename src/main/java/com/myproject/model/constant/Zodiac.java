package com.myproject.model.constant;

import java.util.Calendar;
import java.util.Date;

public enum Zodiac {

	RAT("鼠"), OX("牛"), TIGER("虎"), RABBIT("兔"), DRAGON("龍"), SNAKE("蛇"), HORSE("馬"), GOAT("羊"), MONKEY("猴"),
	ROOSTER("雞"), DOG("狗"), PIG("豬"), UNDEFINED("無定義");

	private String sign;

	private Zodiac(String sign) {
		this.sign = sign;
	}

	public static String getSign(Zodiac zodiac) {
		return zodiac.sign;
	}

	public static Zodiac getZodiac(Date birth) {
		try {
			Calendar c = Calendar.getInstance();
			c.setTime(birth);

			int year = (c.get(Calendar.YEAR) - 1900) % 12;
			return Zodiac.values()[year];
		} catch (Exception e) {
			return Zodiac.UNDEFINED;
		}
	}

}
