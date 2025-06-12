package com.micro.account.dto;

public class ResponseDto {

	private Object data;

	private String statusMsg;

	public ResponseDto(Object data, String statusMsg) {
		super();
		this.data = data;
		this.statusMsg = statusMsg;
	}

	public ResponseDto() {
		super();
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getStatusMsg() {
		return statusMsg;
	}

	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}

}
