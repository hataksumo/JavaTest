package indi.zhifa.learn.simpleweb.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import indi.zhifa.learn.simpleweb.bean.dto.auth.TokenObj;
import indi.zhifa.learn.simpleweb.generate.entity.User;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 * @author 芝法酱
 */
public class TokenUtil {

    public static final long expireSeccond = 48 * 60 * 60;
    public static final String tokenSerc = "Citc2021$#@!";
    public static final String perfix = "Bearer ";

    static public String generatorToken(User pUserInfo){
        TokenObj tokenObj = new TokenObj();
        tokenObj.setUserId(pUserInfo.getId());
        tokenObj.setUserName(pUserInfo.getUserName());
        List<String> roleIds = pUserInfo.getRoles();
        tokenObj.setRoleIds(roleIds);
        Date signTime = Date.from( LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
        Date expire = Date.from( LocalDateTime.now().plusSeconds(expireSeccond).atZone(ZoneId.systemDefault()).toInstant());

        String token = JWT.create()
                .withSubject(JSON.toJSONString(tokenObj))
                .withIssuedAt(signTime)
                .withExpiresAt(expire)
                .withIssuer("zhifa")
                .sign(Algorithm.HMAC256(tokenSerc));
        return perfix + token;
    }

    static public TokenObj test(String pToken) throws AccessDeniedException {
        DecodedJWT decodedJWT = null;
        try{
            decodedJWT = JWT.require(Algorithm.HMAC256(tokenSerc)).build().verify(pToken);
        }catch (SignatureVerificationException ex){
            throw new AccessDeniedException("签名不合法");
        }catch (TokenExpiredException ex){
            throw new AccessDeniedException("签名超期");
        }catch (Exception ex){
            throw new AccessDeniedException("发生未知错误，错误信息是 "+ex.toString());
        }
        String strToken =  decodedJWT.getSubject();
        TokenObj tokenObj = null;
        try{
            tokenObj = JSONObject.parseObject(strToken,TokenObj.class);
        }catch (Exception ex){
            throw new JSONException("解析token时发生错误，错误信息是 "+ex.toString());
        }
        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        req.setAttribute("tokenObject",tokenObj);
        return tokenObj;
    }

    static public TokenObj getTokenObj(){
        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return (TokenObj)req.getAttribute("tokenObject");
    }
}
