package com.lyc.aop01.exception;

import com.lyc.aop01.utils.ResultResponse;
import lombok.Data;

/**
 * @author LYC
 * @desc
 * @create 2020-09-09 15:08
 **/
@Data
public class ResponseException extends RuntimeException {

	private Integer responseCode;

	public ResponseException(ResultResponse resultResponse){
		super(resultResponse.getResponseMsg());
		this.responseCode=resultResponse.getResponseCode();
	}

}
