package com.lyc.aop01.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author LYC
 * @desc
 * @create 2020-09-11 14:54
 **/
@Data
@Component
@ConfigurationProperties(prefix = "girl")
public class GirlProperties {
	private String cupSize;
	private Integer age;
	private Integer money;
}
