package com.lyc.aop01;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, properties = {"spring.profiles.active=dev"})
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public abstract class Aop01ApplicationTests {

	@Autowired
	protected MockMvc mockMvc;
	@Autowired
	protected TestRestTemplate restTemplate;
	@Autowired
	protected ObjectMapper objectMapper;

}
