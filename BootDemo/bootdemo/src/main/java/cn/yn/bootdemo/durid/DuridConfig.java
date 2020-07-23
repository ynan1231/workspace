package cn.yn.bootdemo.durid;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 单数据源
 * 引入mybatis和durid
 * 一. pom文件必须引用完全,包括durid4个，mybatis2个
 * 二. 配置mybatis.mapper-locations、mybatis.type-aliases-package以及MapperScan，注意名称
 * 三. xml内的文件要和dao类匹配,否则会找不到dao对应的方法
 *
 * 监控地址： http://127.0.0.1:8080/druid/index.html
 *
 * 双数据源需要手动配置sqlsessionFaction
 */
//@Configuration
//@MapperScan(basePackages="cn.yn.bootdemo.durid.dao.w")
public class DuridConfig {
}
