package com.xiaobai.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;

@Configuration
/*@ComponentScan("com.xiaobai")*/
@PropertySource(value = {"classpath:jdbc.properties"})
public class SpringDaoConfig {

    /* @Value("${jdbc.driver}")
        String driver;
        @Value("${jdbc.url}")
        String url;
        @Value("${jdbc.user}")
        String user;
        @Value("${jdbc.password}")
        String password;
    */
    /*获取properties为后缀名的文件
     *
     * 第一种方法
     * @PropertySource注解 和Environment类（spring的）一起用
     *
     * 第二种方法
     *
     *
     * */
    @Autowired
    private Environment env;

    /*定义这个方法后就可以使用
     * 这样写： "${jdbc.url}"
     * */

    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource source = new ComboPooledDataSource();
        source.setDriverClass("org.mariadb.jdbc.Driver");
        source.setJdbcUrl("jdbc:mariadb://localhost:3306/test");
        source.setUser("root");
        source.setPassword("Qi1007..");


//        dataSource.setJdbcUrl("${jdbc.url}");
//        dataSource.setDriverClass("${jdbc.driver}");
//        dataSource.setUser("${jdbc.user}");
//        dataSource.setPassword("${jdbc.password}");
/*        dataSource.setJdbcUrl(this.url);
        dataSource.setDriverClass(this.driver);
        dataSource.setUser(this.user);
        dataSource.setPassword(this.password);*/

        return source;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws PropertyVetoException, IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        sqlSessionFactoryBean.setDataSource(this.dataSource());
        sqlSessionFactoryBean.setTypeAliasesPackage("com.xiaobai.entity");
        //sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        //PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        //sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mapper/*.class"));

        sqlSessionFactoryBean.setMapperLocations(new Resource[]{new ClassPathResource("mapper/StudentMapper.xml")});

        return sqlSessionFactoryBean;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() throws PropertyVetoException {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.xiaobai.dao");
        return mapperScannerConfigurer;
    }

}
