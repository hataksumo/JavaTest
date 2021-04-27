package indi.zhifa.learn.simpleweb.bean.response;

import indi.zhifa.learn.simpleweb.generate.entity.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author 芝法酱
 */
@Data
@Schema(name = "登录响应")
public class LoginResponse {
    @Schema(name = "用户信息")
    User user;
    @Schema(name = "token")
    String token;
}
