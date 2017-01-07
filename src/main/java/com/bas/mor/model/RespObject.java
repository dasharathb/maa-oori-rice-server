package com.bas.mor.model;

public class RespObject {

	private String message;

	public RespObject() {
		super();
	}

	public RespObject(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "RespObject [message=" + message + "]";
	}
	
}
