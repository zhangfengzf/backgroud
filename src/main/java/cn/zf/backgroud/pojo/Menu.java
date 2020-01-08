package cn.zf.backgroud.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * 类描述:
 * 〈资源实体类〉
 *
 * @author 张锋
 * @date 2019/12/16 17:06
 */
@Component
@Data
public class Menu implements Serializable {

    /**
     * 变量描述:
     * 〈资源id〉
     */
    private Integer id;
    /**
     * 变量描述:
     * 〈资源名字〉
     */
    private String name;
    /**
     * 变量描述:
     * 〈资源地址〉
     */
    private String url;
    /**
     * 变量描述:
     * 〈是否登录后才能访问〉
     */
    private String isLogin;
    @JsonIgnore
    private List<Role> roles;

}
