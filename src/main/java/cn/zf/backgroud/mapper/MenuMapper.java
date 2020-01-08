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

    List<Menu> findAllMenuIsNotLogin();
    List<Menu> findAllMenuIsLogin();

}
