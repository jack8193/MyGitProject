package com.myproject.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static Date getDate(String yyyyMMdd) {
		Date date = null;
		SimpleDateFormat sdf = null;		
		
		try {
			sdf = new SimpleDateFormat("yyyyMMdd");
			date = sdf.parse(yyyyMMdd);
		} catch (Exception e) {
			date = null;
		}
		
		return date;
	}
}
