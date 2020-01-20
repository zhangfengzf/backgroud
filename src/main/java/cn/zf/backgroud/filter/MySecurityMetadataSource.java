package cn.zf.backgroud.filter;

import cn.zf.backgroud.mapper.MenuMapper;
import cn.zf.backgroud.pojo.Menu;
import cn.zf.backgroud.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * 类描述:
 * 〈通过请求资源路径寻找路径对应的角色，存入security〉
 *
 * @author 张锋
 * @date 2020/1/2 14:51
 */
@Component
public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private MenuMapper menuMapper;
    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {

        //获取所有资源
        List<Menu> allMenuIsLogin = menuMapper.findAllMenuIsLogin();
        //获取http请求资源
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        for (Menu menu:allMenuIsLogin
             ) {
            if (antPathMatcher.match(menu.getUrl(),requestUrl)){
                List<Role> roles = menu.getRoles();
                int size = roles.size();
                String[] strings = new String[size];
                for (int i = 0; i <size ; i++) {
                    strings[i] = roles.get(i).getRoleCode();
                }
                return SecurityConfig.createList(strings);
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
