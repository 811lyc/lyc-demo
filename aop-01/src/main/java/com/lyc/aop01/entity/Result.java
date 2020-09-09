package com.lyc.aop01.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @author LYC
 * @desc http请求封装bean
 * @create 2020-09-09 11:28
 **/
@ToString
@Data
public class Result<T> {
	/**
	 * 状态码
	 */
	private Integer responseCode;
	/**
	 *响应消息
	 */
	private String responseMsg;
	/**
	 * 具体内容
	 */
	private T data;


}
