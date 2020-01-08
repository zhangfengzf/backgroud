package cn.zf.backgroud.mapper;

import cn.zf.backgroud.BackgroudApplication;
import cn.zf.backgroud.pojo.Menu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


/**
 * 类描述:
 * 〈〉
 *
 * @author 张锋
 * @date 2019/12/20 15:01
 */
@SpringBootTest(classes = BackgroudApplication.class)
@RunWith(SpringRunner.class)
public class TestMapper {

    @Autowired
    private MenuMapper menuMapper;

    @Test
    public void testMapper() {
        List<Menu> allMenuIsLogin = menuMapper.findAllMenuIsLogin();
        allMenuIsLogin.forEach(e->{
            System.out.println(e.toString());
        });
    }

}
