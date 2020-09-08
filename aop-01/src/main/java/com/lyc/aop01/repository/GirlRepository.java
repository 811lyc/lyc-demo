package com.lyc.aop01.repository;

import com.lyc.aop01.entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author LYC
 * @desc   jpa 数据
 * @create 2020-09-08 17:24
 **/
public interface GirlRepository extends JpaRepository<Girl,Integer> {

}
