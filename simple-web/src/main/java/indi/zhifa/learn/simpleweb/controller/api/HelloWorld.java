package indi.zhifa.learn.simpleweb.controller.api;

import indi.zhifa.learn.common.base.ServiceException;
import indi.zhifa.learn.common.response.RestResponse;
import indi.zhifa.learn.simpleweb.bean.dto.auth.TokenObj;
import indi.zhifa.learn.simpleweb.bean.dto.login.UserDto;
import indi.zhifa.learn.simpleweb.generate.entity.User;
import indi.zhifa.learn.simpleweb.generate.service.IUserService;
import indi.zhifa.learn.simpleweb.utils.TokenUtil;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "HelloWorld:用户接口")
@RequestMapping("/api/v1.0/hello_world")
@AllArgsConstructor
@RestController
public class HelloWorld {

    private final IUserService mUserService;

    @Operation(summary = "hello_world")
    @PostMapping("")
    public RestResponse<User> hello() throws ServiceException {
        TokenObj tokenObj = TokenUtil.getTokenObj();
        if(null == tokenObj){
            throw new ServiceException("没有token");
        }
        User user = mUserService.getById(tokenObj.getUserId());
        return RestResponse.ok(user);
    }
}
