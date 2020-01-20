package cn.zf.backgroud.mapper;

import cn.zf.backgroud.pojo.Menu;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 类描述:
 * 〈资源dao层〉
 *
 * @author 张锋
 * @date 2019/12/19 14:06
 */
@Component
public interface MenuMapper {
    /**
     * 函数功能描述:
     * 〈获取不需要登录的资源列表〉
     *
     * @param  1
     * @return : java.util.List<cn.zf.backgroud.pojo.Menu>
     * @author : 张锋
     * @date : 2020/1/9 10:26
     */
    List<Menu> findAllMenuIsNotLogin();
    /**
     * 函数功能描述:
     * 〈获取需要登录认证的资源列表〉
     *
     * @param  1
     * @return : java.util.List<cn.zf.backgroud.pojo.Menu>
     * @author : 张锋
     * @date : 2020/1/9 10:27
     */
    List<Menu> findAllMenuIsLogin();

}
