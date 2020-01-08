package cn.zf.backgroud.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * 类描述:
 * 〈角色实体类〉
 *
 * @author 张锋
 * @date 2019/12/16 14:58
 */
@Data
@Component
public class Role implements Serializable {

    /**
     * 变量描述:
     * 〈角色id〉
     */
    private int id;
    /**
     * 变量描述:
     * 〈角色验证码〉
     */
    private String roleCode;
    /**
     * 变量描述:
     * 〈角色名〉
     */
    private String roleName;
    private List<User> userEntities ;
    private List<Menu> menuEntities ;

}
