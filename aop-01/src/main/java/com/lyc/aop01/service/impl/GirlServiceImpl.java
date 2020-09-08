package com.lyc.aop01.service.impl;

import com.lyc.aop01.entity.Girl;
import com.lyc.aop01.repository.GirlRepository;
import com.lyc.aop01.service.GirlService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LYC
 * @desc
 * @create 2020-09-08 17:26
 **/
@Service
@RequiredArgsConstructor
public class GirlServiceImpl implements GirlService {
	private  final GirlRepository girlRepository;

	@Override
	public List<Girl> selectGirls() {
		return girlRepository.findAll();
	}

	@Override
	public int saveGirl(Girl girl) {
		girlRepository.save(girl);
		return 0;
	}

	@Override
	public int delectGirl(Integer id) {
		girlRepository.deleteById(id);
		return 0;
	}
}
