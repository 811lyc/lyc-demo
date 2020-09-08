package com.lyc.aop01.service;

import com.lyc.aop01.entity.Girl;

import java.util.List;

/**
 * @author LYC
 * @desc 操作
 * @create 2020-09-08 17:26
 **/
public interface GirlService {
	/**
	 * 查所有
	 * @return
	 */
	public List<Girl> selectGirls();

	/**
	 * 插入一个
	 * @param girl
	 */
	int saveGirl(Girl girl);

	/**
	 * 删除
	 * @param id
	 * @return
	 */
	int delectGirl(Integer id);

}
