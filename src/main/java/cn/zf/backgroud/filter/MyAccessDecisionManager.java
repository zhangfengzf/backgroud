package cn.zf.backgroud.filter;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;

/**
 * 类描述:
 * 〈〉
 *
 * @author 张锋
 * @date 2020/1/15 15:40
 */
@Component
public class MyAccessDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        Iterator<ConfigAttribute> iterator = collection.iterator();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        while (iterator.hasNext()){
            ConfigAttribute configAttribute = iterator.next();
            String attribute = configAttribute.getAttribute();
            if (authentication instanceof AnonymousAuthenticationToken){
                throw new BadCredentialsException("当前账号未登录!");
            }
            for(GrantedAuthority grantedAuthority :authorities){
                if(attribute.equals(grantedAuthority.getAuthority())){
                    return;
                }
            }
        }
        throw new AccessDeniedException("用户没有权限");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return false;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
