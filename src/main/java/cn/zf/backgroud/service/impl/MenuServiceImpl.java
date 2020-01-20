package cn.zf.backgroud.service.impl;

import cn.zf.backgroud.mapper.MenuMapper;
import cn.zf.backgroud.pojo.Menu;
import cn.zf.backgroud.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类描述:
 * 〈〉
 *
 * @author 张锋
 * @date 2020/1/9 11:08
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> findAllMenuIsNotLogin() {
        return menuMapper.findAllMenuIsNotLogin();
    }
}



