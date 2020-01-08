package cn.zf.backgroud.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 类描述:
 * 〈用户实体类〉
 *
 * @author 张锋
 * @date 2019/12/16 14:48
 */
@Data
@Component
public class User implements UserDetails, Serializable {

    /**
     * 变量描述:
     * 〈用户id〉
     */
    private Integer id;
    /**
     * 变量描述:
     * 〈用户名〉
     */
    private String username;
    /**
     * 变量描述:
     * 〈用户密码〉
     */
    private String password;
    /**
     * 变量描述:
     * 〈用户姓名〉
     */
    private String realName;
    /**
     * 变量描述:
     * 〈电话号码〉
     */
    private String telPhone;
    /**
     * 变量描述:
     * 〈所属单位〉
     */
    private String department;
    /**
     * 变量描述:
     * 〈用户范围〉
     */
    private String userScope;
    /**
     * 变量描述:
     * 〈用户类型〉
     */
    private String userType;
    /**
     * 变量描述:
     * 〈用户状态〉
     */
    private String state;
    /**
     * 变量描述:
     * 〈创建时间〉
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
     * 变量描述:
     * 〈开始时间和结束时间〉
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private String[] startTime;
    /**
     * 变量描述:
     * 〈该用户是否被删除〉
     */
    private String isDelete;
    /**
     * 变量描述:
     * 〈用户对应的角色〉
     */
    @JsonIgnore
    private List<Role> roles;

    /**
     * 函数功能描述:
     * 〈获取并且返回用户所对应的权限〉
     *
     * @param
     * @return : java.util.Collection<? extends org.springframework.security.core.GrantedAuthority>
     * @author : 张锋
     * @date : 2019/12/16 15:51
     */
    @Override
    @JsonIgnore
    public List<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (null != roles) {
            for (Role role: roles
                 ) {
                authorities.add(new SimpleGrantedAuthority(role.getRoleCode()));
            }
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    /**
     * 函数功能描述:
     * 〈账户是否过期〉
     *
     * @param
     * @return : boolean
     * @author : 张锋
     * @date : 2019/12/16 14:55
     */
    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return false;
    }

    /**
     * 函数功能描述:
     * 〈账户是否被冻结〉
     *
     * @param
     * @return : boolean
     * @author : 张锋
     * @date : 2019/12/16 14:55
     */
    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        if (null != isDelete){
            return !isDelete.equals("1");
        }
        return true;
    }

    /**
     * 函数功能描述:
     * 〈账户密码是否过期〉
     *
     * @param
     * @return : boolean
     * @author : 张锋
     * @date : 2019/12/16 14:56
     */
    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return false;
    }

    /**
     * 函数功能描述:
     * 〈账户是否可用〉
     *
     * @param
     * @return : boolean
     * @author : 张锋
     * @date : 2019/12/16 14:56
     */
    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return false;
    }
}
