package hz.config;

import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by xhz on 2017/11/18.
 * 安全框架配置
 */
@Configuration
@Import(ShiroManage.class)
public class ShiroConfig {

    @Value("${shiro.loginUrl}")
    private String loginUrl;

    @Value("${shiro.successUrl}")
    private String successUrl;

//    @Value("${shiro.filter-chain-definitions}")
//    private Map filterChainDefinitionMap;

    @Bean(name = "shiroFilter")
    @DependsOn("securityManager")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultSecurityManager securityManager){
        System.out.println(loginUrl);
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        FormAuthenticationFilter formAuthenticationFilter = new FormAuthenticationFilter();
        formAuthenticationFilter.setLoginUrl(loginUrl);
        formAuthenticationFilter.setSuccessUrl(successUrl);
        Map filterMap = new HashMap();
//        filterMap.put("myauthc",formAuthenticationFilter);  //自定义验证
        shiroFilter.setFilters(filterMap);
        shiroFilter.setSecurityManager(securityManager);
        Map<String,String> filterChainMap = new LinkedHashMap<String, String>();
        filterChainMap.put("/cms/*","authc");
        shiroFilter.setFilterChainDefinitionMap(filterChainMap);
        shiroFilter.setLoginUrl(loginUrl);
        shiroFilter.setSuccessUrl(successUrl);
        //        shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilter;
    }
}
