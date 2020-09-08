package com.lyc.aop01.service;

import com.lyc.aop01.Aop01ApplicationTests;
import com.lyc.aop01.entity.Girl;
import lombok.RequiredArgsConstructor;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author LYC
 * @desc
 * @create 2020-09-08 17:48
 **/

public class GirlServiceApplicationTests extends Aop01ApplicationTests {
	@Autowired
	private  GirlService girlService;

	@Test
	void selectAllGirls(){
		List<Girl>  list = girlService.selectGirls();
		//System.out.println(list);
		list.forEach(System.out::println);
	}
}
