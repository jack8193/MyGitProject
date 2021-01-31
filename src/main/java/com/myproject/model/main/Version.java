package com.myproject.model.main;

import java.util.Date;

import com.myproject.util.DateUtil;

public class Version {

	private static String SYMBOL = "©";
	private static String AUTHOR = "Cheng";

	private static String MAIN_VERSION = "0";
	private static String SUB_VERSION = "0";
	private static String VERSION = "0130";

	public static String getVersion() {
		return MAIN_VERSION + "." + SUB_VERSION + "." + VERSION;
	}

	public static String getCopyRight() {
		String year = DateUtil.convertDateToString(new Date(), DateUtil.FORMAT_YYYY);

		return SYMBOL + " " + year + " " + AUTHOR + " " + getVersion();
	}
}
