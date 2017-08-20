package com.waterlove88.mis.login;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waterlove88.mis.common.model.ResultMaster;
import com.waterlove88.mis.login.model.LoginInfo;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@PostMapping("")
	public ResultMaster login(@Valid LoginInfo loginInfo, BindingResult bindingResult) {		
		if(bindingResult.hasErrors()) {
			return new ResultMaster("1001", "Bad request");
		}
		
		return new ResultMaster("200", "success");
	}
}
