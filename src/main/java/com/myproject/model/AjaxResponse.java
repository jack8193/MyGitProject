package com.myproject.model;

import java.util.Map;

import com.myproject.model.constant.ResponseType;

public class AjaxResponse {

	ResponseType returnCode;
	String message;

	Map<String, Object> returnObj;
	
	public ResponseType getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(ResponseType returnCode) {
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
