package indi.zhifa.learn.simpleweb.controller.filter;

import indi.zhifa.learn.simpleweb.bean.dto.auth.AuthTokenObj;

import indi.zhifa.learn.simpleweb.bean.dto.auth.TokenObj;
import indi.zhifa.learn.simpleweb.utils.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lxr 2020/8/30
 * @DATE 2020/8/30
 */
@Slf4j
public class JWTAuthenticationFilter extends BasicAuthenticationFilter {

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String token = request.getHeader("Authorization");
        if (token == null || !token.startsWith("Bearer ")) {
            log.info("request " + request.getRequestURI());
            chain.doFilter(request, response);
            return;
        }else{
            AuthTokenObj authTokenObj = getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authTokenObj);
            chain.doFilter(request, response);
        }
    }

    private AuthTokenObj getAuthentication(String pToken) throws AccessDeniedException {
        TokenObj tokenObj = TokenUtil.test(pToken);
        if (tokenObj != null) {
            AuthTokenObj authTokenObj = AuthTokenObj.fromTokenObj(tokenObj);
            return authTokenObj;
        }else{
            return null;
        }
    }

}
