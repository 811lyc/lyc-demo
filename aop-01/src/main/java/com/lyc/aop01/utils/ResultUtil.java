package com.lyc.aop01.utils;

import com.lyc.aop01.entity.Result;

/**
 * @author LYC
 * @desc
 * @create 2020-09-09 11:26
 **/
public class ResultUtil {
	/**
	 * 成功
	 */
	public final static Integer RESPONSE_CODE_SUCCESS = 200;
	/**
	 * 请求参数错误
	 */
	public final static Integer RESPONSE_CODE_ERROR_PARAM = 300;
	/**
	 * 系统内部业务错误
	 */
	public final static Integer RESPONSE_CODE_ERROR_SERVICE = 400;
	/**
	 * 系统内部异常
	 */
	public final static Integer RESPONSE_CODE_ERROR_EXECEPTION = 500;

	/**
	 * 执行成功
	 * @param data
	 * @param <T>
	 * @return
	 */
	public static <T> Result<T> success(T data){
		Result<T> result = new Result<>();
		result.setResponseCode(ResultUtil.RESPONSE_CODE_SUCCESS);
		result.setResponseMsg("成功");
		result.setData(data);
		return result;
	}

	/**
	 * 无参
	 * @return
	 */
	public static Result success(){
		return success(null);
	}

	/**
	 * 返回错误
	 * @param responseCode
	 * @param responseMsg
	 * @param <T>
	 * @return
	 */
	public static <T> Result<T> error(Integer responseCode,String responseMsg){
		Result<T> result = new Result<>();
		result.setResponseCode(responseCode);
		result.setResponseMsg(responseMsg);
		return result;
	}
}
