package indi.zhifa.learn.simpleweb.bean.dto.login;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import indi.zhifa.learn.simpleweb.bean.enums.EPasswdEncode;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @author 芝法酱
 */
@Data
@Schema(name = "用户注册配置")
public class UserDto {

    @Schema(name = "用户名")
    private String userName;

    @Schema(name = "密码")
    private String passwd;

    @Schema(name = "编码格式")
    private EPasswdEncode passwdEncode;

    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    @ApiModelProperty(value = "角色")
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private List<String> roles;
}
