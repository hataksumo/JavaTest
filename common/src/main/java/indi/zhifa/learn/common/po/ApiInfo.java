package indi.zhifa.learn.common.po;

import indi.zhifa.learn.common.dto.ApiInfoConfig;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * @author 芝法酱
 */
@Document(collection = "api_info")
@Data
public class ApiInfo extends ApiInfoConfig {
    /**
     * API调用名称
     */
    @Id
    String name;

    /**
     * 创建者名称
     */
    String creatorName;
    /**
     * 创建时间
     */
    LocalDateTime gmtCreate;
    /**
     * 修改时间
     */
    LocalDateTime gmtModify;
}
