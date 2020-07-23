package cn.yn.bootdemo.durid.dao.w;

import cn.yn.bootdemo.durid.model.ZuanAccount;

public interface ZuanAccountDao {
    int deleteByPrimaryKey(Long userId);

    int insert(ZuanAccount record);

    int insertSelective(ZuanAccount record);

    ZuanAccount selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(ZuanAccount record);

    int updateByPrimaryKey(ZuanAccount record);
}