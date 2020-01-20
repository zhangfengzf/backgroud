package cn.zf.backgroud.controller;

import cn.zf.backgroud.pojo.Menu;
import cn.zf.backgroud.service.MenuService;
import cn.zf.backgroud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 类描述:
 * 〈〉
 *
 * @author 张锋
 * @date 2020/1/15 15:13
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private UserService userService;
    @Autowired
    private MenuService menuService;

    @PostMapping("menu")
    public void test(){

        List<Menu> menus = menuService.findAllMenuIsNotLogin();
        menus.forEach(menu -> {

            System.out.println(menu);

        });
    }


}
