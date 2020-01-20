package cn.zf.backgroud.service;


import cn.zf.backgroud.pojo.Menu;

import java.util.List;

/**
 * 类描述:
 * 〈〉
 *
 * @author 张锋
 * @date 2020/1/9 11:08
 */
public interface MenuService {

    /**
     * 函数功能描述:
     * 〈获取不需要登录的资源列表〉
     *
     * @param  1
     * @return : java.util.List<cn.zf.backgroud.pojo.Menu>
     * @author : 张锋
     * @date : 2020/1/9 11:11
     */
    List<Menu> findAllMenuIsNotLogin();


}
