package cn.pioneer.dcim.cmdb;

import cn.pioneer.dcim.cmdb.common.filter.PrePatchFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Michael Hunger
 * @author Mark Angrish
 */
@SpringBootApplication
@EnableScheduling
@EntityScan("cn.pioneer.dcim.cmdb.domain")
@MapperScan("cn.pioneer.dcim.cmdb.mapper")
@EnableNeo4jRepositories(basePackages = {"cn.pioneer.dcim.cmdb.repositories.", "cn.pioneer.dcim.cmdb.dao"})
public class FlexibleCmdbApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlexibleCmdbApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean registPrePatchFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new PrePatchFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("prePatchFilter");
        registration.setOrder(1);
        return registration;
    }
}
