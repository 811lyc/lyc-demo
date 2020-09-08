package com.lyc.aop01.controller;

import com.lyc.aop01.Aop01ApplicationTests;
import org.junit.Test;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author LYC
 * @desc
 * @create 2020-09-08 17:50
 **/
public class GirlControllerApplicationTests extends Aop01ApplicationTests {
	/**
	 * 查询所有女生列表
	 */
	@Test
	public void listGirl() throws Exception {
		String response = mockMvc.perform(get("/girls")
				.contentType(APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andReturn()
				.getResponse()
				.getContentAsString();

		System.out.println(response);
	}
}
