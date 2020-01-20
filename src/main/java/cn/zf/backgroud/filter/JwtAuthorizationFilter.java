package cn.zf.backgroud.filter;

import cn.zf.backgroud.model.ResponseModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * 类描述:
 * 〈〉
 *
 * @author 张锋
 * @date 2020/1/16 14:50
 */
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    /**
     * 变量描述:
     * 〈自定义签名〉
     */
    private String signingKey = "me";

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        try {
            String header = request.getHeader("Authorization");

            if (header == null || !header.startsWith("Bearer")) {
                chain.doFilter(request, response);
                return;
            }
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = getAuthenticationToken(request);
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            chain.doFilter(request, response);
        }catch (ExpiredJwtException e) {
            ObjectMapper o = new ObjectMapper();
            logger.error("Token已过期: {} " + e);
            ResponseModel responseModel = new ResponseModel("token","error","token过期，请重新登录",false);
            PrintWriter printWriter = response.getWriter();
            printWriter.write(o.writeValueAsString(responseModel));
        }

    }

    public UsernamePasswordAuthenticationToken getAuthenticationToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty()) {
        }
        // parse the token.
        try{
            String user = null;
            user = Jwts.parser()
                    .setSigningKey(signingKey)
                    .parseClaimsJws(token.replace("Bearer ", ""))
                    .getBody()
                    .getSubject();
            if (user != null) {
                String u = user.split("-")[0];
                String[] split = user.split("-")[1].split(",");
                ArrayList<GrantedAuthority> authorities = new ArrayList<>();
                for (int i = 0; i < split.length; i++) {
                    authorities.add(new SimpleGrantedAuthority(split[i]));
                }
                return new UsernamePasswordAuthenticationToken(u, null, authorities);
            }
        }catch (UnsupportedJwtException e) {
            logger.error("Token格式错误: {} " + e);
        } catch (MalformedJwtException e) {
            logger.error("Token没有被正确构造: {} " + e);
        } catch (SignatureException e) {
            logger.error("签名失败: {} " + e);
        } catch (IllegalArgumentException e) {
            logger.error("非法参数异常: {} " + e);

        }
        return null;


    }
}
