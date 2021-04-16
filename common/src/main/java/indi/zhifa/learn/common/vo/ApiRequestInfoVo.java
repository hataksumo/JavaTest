package indi.zhifa.learn.common.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Map;

/**
 * @author 芝法酱
 */
@Data
@Schema(name="API调用信息")
public class ApiRequestInfoVo {
    @Schema(name="参数信息")
    Map<String,Object> param;
    @Schema(name="报文体信息")
    String body;
}
