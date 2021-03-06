package com.myproject.model.constant;

public enum ResponseType {

	SUCCESS(200), WARNING(199), ERROR(500);
	
	private int code;
	
	private ResponseType(int code) {
		this.code = code;
	}
}
