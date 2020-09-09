package com.lyc.aop01.controller;

import com.lyc.aop01.entity.Girl;
import com.lyc.aop01.entity.Result;
import com.lyc.aop01.exception.ResponseException;
import com.lyc.aop01.repository.GirlRepository;
import com.lyc.aop01.service.GirlService;
import com.lyc.aop01.utils.ResultResponse;
import com.lyc.aop01.utils.ResultUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author LYC
 * @desc   put 更新，delect 删除，post 新增，get 查
 * @create 2020-09-09 9:27
 **/
@RestController
@RequiredArgsConstructor
@RequestMapping("girls")
public class GirlController {

	private final GirlService girlService;

	private final GirlRepository girlRepository;

	@GetMapping
	public List<Girl> getAllGirl(){
		List<Girl> girls = girlService.selectGirls();
		return girls;
	}

	/**
	 * 根据id获取
	 * @param id
	 * @return
	 */
	@GetMapping("/getById/{id}")
	public Girl getAllGirl(@PathVariable Integer id){
		//Girl girl = girlRepository.getOne(id);
		Girl girl = girlRepository.findById(id).orElse(null);
		if(Objects.isNull(girl)){
			throw new ResponseException(ResultResponse.NOT_FOUNT);
		}
		return girl;
	}

	/**
	 * 更新
	 * @param id
	 * @param cupSize
	 * @param age
	 * @return
	 */
	@PutMapping("/{id}")
	public Girl addGirl(@PathVariable("id") Integer id,
					   @RequestParam("cupSize") String cupSize,
					   @RequestParam("age") Integer age){
		Girl girl = new Girl();
		girl.setAge(age);
		girl.setCupSize(cupSize);
		girl.setId(id);
		girl.setMoney(45);
		Girl save = girlRepository.save(girl);
		return save;
	}

	/**
	 * 根据id删除
	 * @param id
	 */
	@DeleteMapping("/{id}")
	public void delectGirlById(@PathVariable Integer id){
		girlRepository.deleteById(id);
	}

	@PostMapping("/two")
	public void saveGirls(){
		girlService.saveTwoGirls();
	}
	@PostMapping
	public Result<Girl> addOneGirl(@RequestBody @Valid Girl girl, BindingResult bindingResult){
		// 验证参数是否正确
		if (bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			if(Objects.isNull(fieldError)){
				return ResultUtil.error(ResultUtil.RESPONSE_CODE_ERROR_PARAM,fieldError.getDefaultMessage());
			}
			// age <18 后，就会报异常
			return ResultUtil.error(ResultUtil.RESPONSE_CODE_ERROR_PARAM,"未知参数错误");
		}
		return ResultUtil.success(girlRepository.save(girl));
	}


}
