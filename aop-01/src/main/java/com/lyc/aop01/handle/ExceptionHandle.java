package com.lyc.aop01.handle;

import com.lyc.aop01.entity.Result;
import com.lyc.aop01.exception.ResponseException;
import com.lyc.aop01.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author LYC
 * @desc   全局异常
 * @create 2020-09-11 15:02
 **/
@ControllerAdvice
public class ExceptionHandle  {
	private final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
//	log.info("");
	/**
	 * 全局异常返回处理
	 *
	 * @param ex 异常
	 * @return 处理后的返回结果
	 */
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Result handle(Exception ex) {
		if (ex instanceof ResponseException) {
			ResponseException responseException = (ResponseException) ex;
			return ResultUtil.error(responseException.getResponseCode(), responseException.getMessage());
		}
		logger.error("系统异常：", ex);
		return ResultUtil.error(ResultUtil.RESPONSE_CODE_ERROR_SERVICE, "未知错误");
	}
}
