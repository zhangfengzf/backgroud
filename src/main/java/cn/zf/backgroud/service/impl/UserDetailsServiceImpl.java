package cn.zf.backgroud.service.impl;

import cn.zf.backgroud.mapper.UserMapper;
import cn.zf.backgroud.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 类描述:
 * 〈将用户存入security〉
 *
 * @author 张锋
 * @date 2019/12/16 17:44
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 函数功能描述:
     * 〈从数据库中获取该用户名对应的用户〉
     *
     * @param userName 1 用户名
     * @return : org.springframework.security.core.userdetails.UserDetails
     * @author : 张锋
     * @date : 2019/12/17 20:47
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User user = userMapper.getUserByName(userName);
        if (null == user){
            throw new UsernameNotFoundException("用户名不存在");
        }

        return user;
    }


}
