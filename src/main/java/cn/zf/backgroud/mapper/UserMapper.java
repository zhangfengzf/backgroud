package cn.zf.backgroud.mapper;

import cn.zf.backgroud.pojo.User;
import org.springframework.stereotype.Component;

/**
 * 类描述:
 * 〈用户dao层〉
 *
 * @author 张锋
 * @date 2019/12/16 17:54
 */
@Component
public interface UserMapper {

    /**
     * 函数功能描述:
     * 〈通过用户名查询用户〉
     *
     * @param userName 1
     * @return : cn.zf.backgroud.pojo.User
     * @author : 张锋
     * @date : 2019/12/16 17:57
     */
    User getUserByName(String userName);



}
