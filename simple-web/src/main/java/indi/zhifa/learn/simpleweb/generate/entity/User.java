package indi.zhifa.learn.simpleweb.generate.entity;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import indi.zhifa.learn.simpleweb.bean.enums.EPasswdEncode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 芝法酱
 * @since 2021-04-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="User对象", description="")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户Id")
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "密码，密文")
    private String passwd;

    @ApiModelProperty(value = "密文编码格式")
    @JSONField(serialzeFeatures= SerializerFeature.WriteEnumUsingToString)
    private EPasswdEncode passwdEncode;

    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    @ApiModelProperty(value = "角色")
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private List<String> roles;
}
