/*
package cn.zf.backgroud.config;

import cn.zf.backgroud.filter.MySecurityMetadataSource;
import cn.zf.backgroud.loginUtil.NotLogin;
import cn.zf.backgroud.service.impl.UserDetailsServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsUtils;

*/
/**
 * 类描述:
 * 〈security配置类〉
 *
 * @author 张锋
 * @date 2019/12/16 14:10
 *//*

@Component
@Log4j2
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private NotLogin notLogin;
    @Autowired
    private MySecurityMetadataSource securityMetadataSource;
    */
/**
     * 函数功能描述:
     * 〈配置用户信息和权限〉
     *
     * @param auth 1 认证管理器构建器
     * @return : void
     * @author : 张锋
     * @date : 2019/12/16 14:23
     *//*

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {

        //BCryptPasswordEncoder 自定义的加密方式
        try {
            auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
        } catch (Exception e) {
            log.error("用户登录异常" + e.getMessage());
        }

    }

    */
/**
     * 函数功能描述:
     * 〈配置拦截的请求资源〉
     *
     * @param http 1
     * @return : void
     * @author : 张锋
     * @date : 2019/12/16 14:23
     *//*

    @Override
    protected void configure(HttpSecurity http) throws Exception {
             //配置跨域
        http.cors().and().authorizeRequests()
                //将PreflightRequest不做拦截
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                //设置不用登录的资源
                .antMatchers(notLogin.notLogin()).permitAll()
                //其他任何请求需要认证
                .anyRequest().authenticated()
                //
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O object) {
                        object.setSecurityMetadataSource(securityMetadataSource);
                        object.setAccessDecisionManager(accessDecisionManager);
                        return object;
                    }
                })
                .and()
                //
                .addFilter(new JwtFilterLogin(authenticationManager())).addFilter(new JwtAuthorizationFilter(authenticationManager()))
                //配置登录页面，登录页面无需验证
                .formLogin().loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/index").permitAll()
                .and()
                //
                .exceptionHandling().authenticationEntryPoint(customAuthenticationEntryPoint).accessDeniedHandler(customAccessDeniedHandler).and()
                //登出
                .logout().permitAll()
                .and()
                //关闭csrf
                .csrf().disable();


    }
}
*/
