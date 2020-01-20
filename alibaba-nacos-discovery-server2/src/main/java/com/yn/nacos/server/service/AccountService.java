package com.yn.nacos.server.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.yn.nacos.server.dao.AccountMapper;
import com.yn.nacos.server.model.Account;

@Service(value = "service.account")
public class AccountService {
	
	Logger logger = LoggerFactory.getLogger(AccountService.class);
	@Resource
	private AccountMapper accountMapper;
	
	public Account selectByPrimaryKey(int userId) {
		return accountMapper.selectByPrimaryKey(userId);
	}
}
