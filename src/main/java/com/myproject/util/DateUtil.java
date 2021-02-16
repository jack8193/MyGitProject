package com.myproject.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {

	public static final String FORMAT_YYYY = "yyyy";
	public static final String FORMAT_YYYYMMDD = "yyyyMMdd";
	public static final String FORMAT_YYYYMMDDHHMMSS = "yyyy/MM/dd HH:mm:ss";

	public static Date convertStringToDate(String string, String format) {
		Date result = null;
		SimpleDateFormat sdf = null;

		try {
			sdf = new SimpleDateFormat(format);
			sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
			result = sdf.parse(string);
		} catch (Exception e) {
			result = new Date();
		}

		return result;
	}

	public static String convertDateToString(Date date, String format) {
		String result = null;

		try {
			result = new SimpleDateFormat(format).format(date);
		} catch (Exception e) {
			result = new SimpleDateFormat(FORMAT_YYYYMMDDHHMMSS).format(new Date());
		}

		return result;
	}

}
