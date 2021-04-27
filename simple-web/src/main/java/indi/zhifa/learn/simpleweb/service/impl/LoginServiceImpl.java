package indi.zhifa.learn.simpleweb.service.impl;

import indi.zhifa.learn.common.base.ServiceException;
import indi.zhifa.learn.common.utils.DtoEntityUtil;
import indi.zhifa.learn.common.utils.SnowflakeIdWorker;
import indi.zhifa.learn.simpleweb.bean.dto.login.UserDto;
import indi.zhifa.learn.simpleweb.bean.enums.EPasswdEncode;
import indi.zhifa.learn.simpleweb.bean.response.LoginResponse;
import indi.zhifa.learn.simpleweb.generate.entity.User;
import indi.zhifa.learn.simpleweb.generate.service.IUserService;
import indi.zhifa.learn.simpleweb.service.ILoginService;
import indi.zhifa.learn.simpleweb.utils.TokenUtil;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author 芝法酱
 */
@AllArgsConstructor
@Component
public class LoginServiceImpl implements ILoginService {
    private final IUserService mUserService;
    private final PasswordEncoder mPasswordEncoder;
    @Override
    public LoginResponse login(String pUserName, String pPasswd) throws ServiceException {
        User user = mUserService.findByUserName(pUserName);
        if(null == user){
            throw new ServiceException("没有找到名为 "+pUserName+" 的用户");
        }
        String encodePwd = user.getPasswd();
        if(!mPasswordEncoder.matches(pPasswd,encodePwd)){
            throw new ServiceException("用户名密码不匹配");
        }
        String token = TokenUtil.generatorToken(user);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUser(user);
        loginResponse.setToken(token);
        return loginResponse;
    }

    @Override
    public User regist(UserDto pUserConfig) {
        User user = DtoEntityUtil.trans(pUserConfig,User.class);
        String encodePwd = mPasswordEncoder.encode(pUserConfig.getPasswd());
        user.setId(SnowflakeIdWorker.generateId());
        user.setPasswd(encodePwd);
        user.setPasswdEncode(EPasswdEncode.BCRYPT);
        mUserService.save(user);
        return user;
    }
}
