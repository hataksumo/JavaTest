package indi.zhifa.learn.simpleweb.service;

import indi.zhifa.learn.common.base.ServiceException;
import indi.zhifa.learn.simpleweb.bean.dto.login.UserDto;
import indi.zhifa.learn.simpleweb.bean.response.LoginResponse;
import indi.zhifa.learn.simpleweb.generate.entity.User;

/**
 * @author 芝法酱
 */
public interface ILoginService {
    LoginResponse login(String pUserName, String pPasswd) throws ServiceException;
    User regist(UserDto pUserConfig);
}
