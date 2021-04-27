package indi.zhifa.learn.simpleweb.controller.api.user;

import indi.zhifa.learn.common.base.ServiceException;
import indi.zhifa.learn.common.response.RestResponse;
import indi.zhifa.learn.simpleweb.bean.dto.login.UserDto;
import indi.zhifa.learn.simpleweb.bean.response.LoginResponse;
import indi.zhifa.learn.simpleweb.generate.entity.User;
import indi.zhifa.learn.simpleweb.service.ILoginService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author 芝法酱
 */
@Api(tags = "UserApi:用户接口")
@RequestMapping("/api/v1.0/auth")
@AllArgsConstructor
@RestController
public class UserApi {

    private final ILoginService mLoginService;

    @Operation(summary = "注册用户")
    @PostMapping("/regist")
    public RestResponse<User> regist(@Parameter(description = "用户配置") @RequestBody UserDto pUserDto){
        User user = mLoginService.regist(pUserDto);
        return RestResponse.ok(user);
    }

    @Operation(summary = "登录")
    @GetMapping("/login")
    public RestResponse<LoginResponse> login(@Parameter(description = "用户名") @RequestParam(name = "userName") String pUserName,
                      @Parameter(description = "密码") @RequestParam(name = "password") String pPassword) throws ServiceException {
        LoginResponse loginResponse = mLoginService.login(pUserName,pPassword);
        return RestResponse.ok(loginResponse);
    }

}
