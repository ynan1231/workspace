package cn.yn.bootdemo.durid.multiple.dao.r;

import cn.yn.bootdemo.durid.model.ZuanAccount;

public interface R_ZuanAccountDao {
    int deleteByPrimaryKey(Long userId);

    int insert(ZuanAccount record);

    int insertSelective(ZuanAccount record);

    ZuanAccount selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(ZuanAccount record);

    int updateByPrimaryKey(ZuanAccount record);
}