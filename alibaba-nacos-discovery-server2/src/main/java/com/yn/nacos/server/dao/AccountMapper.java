package com.yn.nacos.server.dao;

import com.yn.nacos.server.model.Account;

public interface AccountMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(int userId);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
}