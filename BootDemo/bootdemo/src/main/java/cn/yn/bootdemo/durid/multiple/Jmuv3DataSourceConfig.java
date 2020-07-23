package cn.yn.bootdemo.durid.multiple;


import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan(basePackages = "cn.yn.bootdemo.durid.dao.w", sqlSessionFactoryRef = "sqlSessionFactoryJmuv3")
public class Jmuv3DataSourceConfig {

    @Autowired
    private Environment env;

    @Bean(name = "jmuv3")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.jmuv3")
    public DataSource dataSourceJmuv3() {
        // 使用JDBC数据源
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "sqlSessionFactoryJmuv3")
    @Primary
    public SqlSessionFactory createSqlSessionFactory(@Qualifier("jmuv3") DataSource ds) throws Exception {

        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setDataSource(ds);
//可以配置文件配,也可以直接写
//        fb.setTypeAliasesPackage(env.getProperty("mybatis.type-aliases-package"));
//        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapper-locations.jmuv3")));

        fb.setTypeAliasesPackage(env.getProperty("mybatis.type-aliases-package"));
        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapping/w/*Dao.xml"));

        return fb.getObject();
    }

    /**
     * 多数据源事务应用
     * @@Transactional("transactionManagerJmuv3")
     * @param ds
     * @return
     * @throws Exception
     */
    @Bean(name = "transactionManagerJmuv3")
    @Primary
    public DataSourceTransactionManager transactionManager(@Qualifier("jmuv3") DataSource ds) throws Exception {
        return new DataSourceTransactionManager(ds);
    }
}
