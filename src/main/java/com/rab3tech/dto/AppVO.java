package com.rab3tech.dto;

public class AppVO {

	private String code;
	private String message;
	private String description;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "AppVO [code=" + code + ", message=" + message + ", description=" + description + "]";
	}

}
