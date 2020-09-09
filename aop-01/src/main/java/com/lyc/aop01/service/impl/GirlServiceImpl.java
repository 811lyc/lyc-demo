package com.lyc.aop01.service.impl;

import com.lyc.aop01.entity.Girl;
import com.lyc.aop01.repository.GirlRepository;
import com.lyc.aop01.service.GirlService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Override
	public int updateGirl(Integer id, Girl girl) {
		//irlRepository.
		return 0;
	}
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void saveTwoGirls() {
		Girl girl1 = new Girl();
		girl1.setAge(19);
		girl1.setCupSize("大小");
		girl1.setMoney(100);
		girlRepository.save(girl1);

		Girl girl2 = new Girl();
		girl2.setAge(21);
		girl2.setMoney(101);
		girl2.setCupSize("xiao小");
		girlRepository.save(girl2);
	}
}
