package com.lyc.aop01.entity;



import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * @author LYC
 * @desc   女孩
 * @create 2020-09-08 15:16
 **/
@Data
@ToString
@Entity(name = "lyc_test_girl")
public class Girl {
	/**
	 * @id 表示主键
	 * @GeneratedValue 表示主键策略 (默认)
	 * @GeneratedValue(strategy = GenerationType.SEQUENCE) （序列）
	 * @GeneratedValue(strategy = GenerationType.AUTO)  (jpa选择合适的策略，默认)
	 * @GeneratedValue(strategy = GenerationType.IDENTITY)  （id自增长）
	 * @GeneratedValue(strategy = GenerationType.TABLE) 通过表产生主键，框架借由表模拟序列产生主键，使用该策略可以使应用更易于数据库移植
	 */
	@Id
	@GeneratedValue
	private Integer id;

	/**
	 * 大小
	 */
	private String cupSize;

	/**
	 * 金额
	 */
	//@NotNull(message = "金额必传")
	private Integer money;

	/**
	 * 年龄
	 */
	private Integer age;



}
