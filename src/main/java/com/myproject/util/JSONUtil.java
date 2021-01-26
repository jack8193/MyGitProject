package com.myproject.util;

import org.json.JSONObject;

public class JSONUtil {

	public static boolean validJSON(JSONObject json, String name) {
		boolean result = false;
		
		if (json!=null && json.has(name) && !json.isNull(name)) {
			result = true;
		}
		
		return result;
	}
	
}
