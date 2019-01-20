package com.ruoyi.framework.config;

import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.framework.datasource.DynamicDataSource;

/**
 * druid 配置多数据源
 *
 * @author ruoyi
 */
@Configuration
public class DruidConfig
{
    @Bean
    @ConfigurationProperties("spring.datasource.druid.master")
    public DataSource masterDataSource()
    {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid.slave")
    @ConditionalOnProperty(prefix = "spring.datasource.druid.slave", name = "enabled", havingValue = "true")
    public DataSource slaveDataSource()
    {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid.sxuser")
    @ConditionalOnProperty(prefix = "spring.datasource.druid.sxuser", name = "enabled", havingValue = "true")
    public DataSource sx_userDataSource()
    {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid.sxinfom")
    @ConditionalOnProperty(prefix = "spring.datasource.druid.sxinfom", name = "enabled", havingValue = "true")
    public DataSource sx_infomDataSource()
    {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid.sxrivervis")
    @ConditionalOnProperty(prefix = "spring.datasource.druid.sxrivervis", name = "enabled", havingValue = "true")
    public DataSource sx_rivervisDataSource()
    {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid.sxvillage")
    @ConditionalOnProperty(prefix = "spring.datasource.druid.sxvillage", name = "enabled", havingValue = "true")
    public DataSource sx_villageDataSource()
    {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "dynamicDataSource")
    @Primary
    public DynamicDataSource dataSource(DataSource masterDataSource, DataSource slaveDataSource,
                                        DataSource sx_userDataSource, DataSource sx_infomDataSource,
                                        DataSource sx_rivervisDataSource, DataSource sx_villageDataSource)
    {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceType.MASTER.name(), masterDataSource);
        targetDataSources.put(DataSourceType.SLAVE.name(), slaveDataSource);
        targetDataSources.put(DataSourceType.SXUSER.name(), sx_userDataSource);
        targetDataSources.put(DataSourceType.SXINFOM.name(), sx_infomDataSource);
        targetDataSources.put(DataSourceType.SXRIVERVIS.name(), sx_rivervisDataSource);
        targetDataSources.put(DataSourceType.SXVILLAGE.name(), sx_villageDataSource);
        return new DynamicDataSource(masterDataSource, targetDataSources);
    }
}
