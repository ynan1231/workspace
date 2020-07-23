package cn.yn.bootdemo.durid.multiple;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;
/**
 * 德鲁伊
 */
@Configuration
@MapperScan(basePackages = "cn.yn.bootdemo.durid.multiple.dao.w",sqlSessionFactoryRef="w_sqlSessionFactory" )
public class W_DataSourceConfig {

    @Autowired
    private DBConfigProperties configProperties;

    @Autowired
    private Environment env;

    @Bean(name = "w_datasource")
    public DataSource dataSourceJmuMp() throws SQLException {

        // 使用Druid连接池
        DruidDataSource ds = new DruidDataSource();
        ds.setUrl(configProperties.getWUrl());
        ds.setUsername(configProperties.getWUsername());
        ds.setPassword(configProperties.getWPassword());
        ds.setFilters("wall,stat,slf4j");
        return ds;
    }

    @Bean(name = "w_sqlSessionFactory")
    public SqlSessionFactory createSqlSessionFactory(@Qualifier("w_datasource") DataSource ds) throws Exception {

        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setDataSource(ds);

        fb.setTypeAliasesPackage(env.getProperty("mybatis.type-aliases-package"));
        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapper-locations.W")));

        return fb.getObject();
    }

    @Bean(name = "transactionManager")
    @Primary
    public DataSourceTransactionManager transactionManager(@Qualifier("w_datasource") DataSource ds) throws Exception {
        return new DataSourceTransactionManager(ds);
    }

}