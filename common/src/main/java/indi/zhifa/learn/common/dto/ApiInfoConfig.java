package indi.zhifa.learn.common.dto;


import cn.hutool.http.Method;
import indi.zhifa.learn.common.base.ParamDefine;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author 芝法酱
 */
@Data
@Schema(name="API配置")
public class ApiInfoConfig {
    /**
     * 描述
     */
    @Schema(name="描述")
    protected String description;
    /**
     * 调用url
     */
    @NotNull(message = "必须填写URL")
    @Schema(name="调用url")
    protected String url;
    /**
     * appId
     */
    @NotNull(message = "必须填写appId")
    @Schema(name="appId")
    protected String appId;
    /**
     * 密码
     */
    @NotNull(message = "必须填写secret")
    @Schema(name="secret")
    protected String secret;
    /**
     * http方法
     */
    @Schema(name="method")
    protected Method method = Method.POST;
    /**
     * 参数定义
     */
    @Schema(name="参数定义")
    protected List<ParamDefine> params;
}
