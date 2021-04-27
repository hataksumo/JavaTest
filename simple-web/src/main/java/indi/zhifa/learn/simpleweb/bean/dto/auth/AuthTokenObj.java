package indi.zhifa.learn.simpleweb.bean.dto.auth;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.List;

public class AuthTokenObj extends UsernamePasswordAuthenticationToken {
    @Getter
    @Setter
    String userName;
    @Getter
    @Setter
    List<String> roleIds;
    @Getter
    @Setter
    Byte status;
    @Getter
    @Setter
    String depId;

    public AuthTokenObj(String pUserName, List<String> pRollIds, Byte pStatus, String pDept) {
        super(pUserName, null, AuthorityUtils.commaSeparatedStringToAuthorityList(String.join(",", pRollIds)));
        userName = pUserName;
        roleIds = pRollIds;
        status = pStatus;
        depId = pDept;
    }

    public static AuthTokenObj fromTokenObj(TokenObj pTokenObj){
        return new AuthTokenObj(pTokenObj.getUserName(),pTokenObj.getRoleIds(), pTokenObj.getStatus(), pTokenObj.getDepId());
    }
}
