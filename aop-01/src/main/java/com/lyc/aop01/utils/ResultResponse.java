package com.lyc.aop01.utils;

/**
 * @author LYC
 * @desc
 * @create 2020-09-09 13:45
 **/
public enum ResultResponse {

	SUCCESS(0,"成功"),
	UNKONW_ERROR(-1,"未知错误"),
	SERVES_EXCEPTION(-2,"业务异常"),
	NOT_FOUNT(-3,"不存在此数据")
	;

	private Integer responseCode;
	private String responseMsg;

	ResultResponse(int responseCode, String responseMsg) {
		this.responseCode = responseCode;
		this.responseMsg = responseMsg;
	}

	public Integer getResponseCode() {
		return responseCode;
	}

	public String getResponseMsg() {
		return responseMsg;
	}
}
