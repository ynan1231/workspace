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
/**
 * 
 *DBCP2
 */
@Configuration
@MapperScan(basePackages = "cn.yn.bootdemo.durid.multiple.dao.r", sqlSessionFactoryRef = "r_sqlSessionFactory")
public class R_DataSourceConfig {

    @Autowired
    private Environment env;

    @Bean(name = "r_dataSorece")
    @ConfigurationProperties(prefix = "spring.datasource.r")
    public DataSource dataSourceCcjoinSettlement() {
        // 使用DBCP2数据源(在配置文件配置所使用的数据源类型)
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "r_sqlSessionFactory")
    public SqlSessionFactory createSqlSessionFactory(@Qualifier("r_dataSorece") DataSource ds) throws Exception {

        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setDataSource(ds);

        fb.setTypeAliasesPackage(env.getProperty("mybatis.type-aliases-package"));
        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapper-locations.R")));

        return fb.getObject();
    }

    @Bean(name = "r_transactionManager")
    @Primary
    public DataSourceTransactionManager transactionManager(@Qualifier("r_dataSorece") DataSource ds) throws Exception {
        return new DataSourceTransactionManager(ds);
    }
}