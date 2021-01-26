package com.myproject.model;

import java.util.Map;

public class AjaxResponse {
	
	String returnCode;
	String message;
	
	Map<String, Object> returnObj;

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getReturnObj() {
		return returnObj;
	}

	public void setReturnObj(Map<String, Object> returnObj) {
		this.returnObj = returnObj;
	}
	
}
