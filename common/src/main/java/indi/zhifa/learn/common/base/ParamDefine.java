package indi.zhifa.learn.common.base;

import indi.zhifa.learn.common.base.enums.ERequestField;
import indi.zhifa.learn.common.base.enums.EValueType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author 芝法酱
 */
@Data
public class ParamDefine {
    /**
     * 名称
     */
    @NotNull(message = "必须填写参数名称")
    @Schema(name="参数名称")
    String name;
    /**
     * 变量类型
     */
    @NotNull(message = "必须填写参数类型")
    @Schema(name="变量类型")
    EValueType valueType;
    /**
     * 请求参数所放位置
     */
    @Schema(name="请求参数所放位置")
    ERequestField field = ERequestField.BODY;
    /**
     * 是否必须
     */
    @Schema(name="是否必须")
    Boolean require;
}
