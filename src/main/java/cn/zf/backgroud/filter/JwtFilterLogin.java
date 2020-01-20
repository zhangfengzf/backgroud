package cn.zf.backgroud.filter;

import cn.zf.backgroud.model.ResponseModel;
import cn.zf.backgroud.pojo.Role;
import cn.zf.backgroud.pojo.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 类描述:
 * 〈登录认证，生成对应的token〉
 *
 * @author 张锋
 * @date 2020/1/15 17:00
 */
public class JwtFilterLogin extends UsernamePasswordAuthenticationFilter {

    /**
     * 变量描述:
     * 〈自定义签名〉
     */
    private String signingKey = "me";
    private AuthenticationManager authenticationManager;

    public JwtFilterLogin(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
    /**
     * 函数功能描述:
     * 〈登录入口〉
     *
     * @param request 1
     * @param response 2
     * @return : org.springframework.security.core.Authentication
     * @author : 张锋
     * @date : 2020/1/16 15:20
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        try {
            User user = new ObjectMapper().readValue(request.getInputStream(), User.class);
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword(),
                        new ArrayList<>()
                    )
            );
        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }
    /**
     * 函数功能描述:
     * 〈登录认证失败〉
     *
     * @param request 1
     * @param response 2
     * @param failed 3
     * @return : void
     * @author : 张锋
     * @date : 2020/1/16 15:20
     */
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {

        ResponseModel responseModel = null;
        if(failed instanceof BadCredentialsException){
            responseModel = new ResponseModel("","error","用户名或者密码错误！",false);
        }else if(failed instanceof LockedException){
            responseModel = new ResponseModel("","error","该账号已被注销！",false);
        }
        JsonMapper jsonMapper = new JsonMapper();
        PrintWriter writer = response.getWriter();
        writer.write(jsonMapper.writeValueAsString(responseModel));
        writer.flush();
        writer.close();

    }
    /**
     * 函数功能描述:
     * 〈认证成功，生成对应的token〉
     *
     * @param request 1
     * @param response 2
     * @param chain 3
     * @param authResult 4
     * @return : void
     * @author : 张锋
     * @date : 2020/1/16 15:21
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        User user = (User)authResult.getPrincipal();
        List<Role> roles = user.getRoles();

        Calendar instance = Calendar.getInstance();
        Date start = instance.getTime();
        instance.setTime(new Date());
        instance.add(Calendar.HOUR,24);
        Date end = instance.getTime();
        String token =Jwts.builder()
                .setSubject(user.getUsername()+"-"+roles.get(0).getRoleCode())
                .setIssuedAt(start)
                .setExpiration(end)
                .signWith(SignatureAlgorithm.HS512, signingKey)
                .compact();

        response.addHeader("Authorization", "Bearer " + token);
        response.addHeader("Access-Control-Expose-Headers", "Authorization");
        ResponseModel responseModel =null;
        //  一个用户，对应一个角色
        responseModel = new ResponseModel(user.getRealName()+"_"+ user.getRoles().get(0).getRoleCode(),"","登录成功！",true);
        ObjectMapper objectMapper = new ObjectMapper();
        PrintWriter out = response.getWriter();
        out.write(objectMapper.writeValueAsString(responseModel));
        out.flush();
        out.close();

    }
}
