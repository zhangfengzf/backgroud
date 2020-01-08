package cn.zf.backgroud.loginUtil;

import cn.zf.backgroud.mapper.MenuMapper;
import cn.zf.backgroud.pojo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述:
 * 〈获取不需要登录的资源工具类〉
 *
 * @author 张锋
 * @date 2019/12/30 18:00
 */
@Component
public class NotLogin {

    @Autowired
    private MenuMapper menuMapper;

    /**
     * 函数功能描述:
     * 〈获取对应的资源〉
     *
     * @param  1
     * @return : java.lang.String[]
     * @author : 张锋
     * @date : 2019/12/30 18:20
     */
    public String[] notLogin() {

        List<Menu> menus = menuMapper.findAllMenuIsNotLogin();
        ArrayList<String> notLoginList = new ArrayList<>();
        if (null != menus) {
            for (Menu menu:menus
                    ) {
                notLoginList.add(menu.getUrl());
            }
            String[] notLoginS = new String[notLoginList.size()];
            return notLoginList.toArray(notLoginS);
        }
        return null;
    }

}
