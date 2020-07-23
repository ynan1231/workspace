package cn.yn.bootdemo.durid.multiple;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 多数据源配置文件
 * 分别为每个数据源配置basePackages、mapper-locations、type-aliases-package即可
 * 本质上是配置多个sqlsessionFaction
 *
 */
@Data
@Component
@PropertySource("classpath:dbconfig.properties")
public class DBConfigProperties {

    @Value("${spring.datasource.jmuv3.jdbc-url}")
    private String jmuv3Url;

    @Value("${spring.datasource.jmuv3.driver-class-name}")
    private String jmuv3DriverClassName;

    @Value("${spring.datasource.jmuv3.username}")
    private String jmuv3Username;

    @Value("${spring.datasource.jmuv3.password}")
    private String jmuv3Password;

    @Value("${spring.datasource.r.jdbc-url}")
    private String rUrl;

    @Value("${spring.datasource.r.driver-class-name}")
    private String rDriverClassName;

    @Value("${spring.datasource.r.username}")
    private String rUsername;

    @Value("${spring.datasource.r.password}")
    private String rPassword;

    @Value("${spring.datasource.r.type}")
    private String rType;

    @Value("${spring.datasource.w.jdbc-url}")
    private String wUrl;

    @Value("${spring.datasource.w.driver-class-name}")
    private String wDriverClassName;

    @Value("${spring.datasource.w.username}")
    private String wUsername;

    @Value("${spring.datasource.w.password}")
    private String wPassword;

}