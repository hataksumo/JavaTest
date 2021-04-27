package indi.zhifa.learn.simpleweb.bean.dto.auth;

import lombok.Data;

import java.util.List;

/**
 * @author 芝法酱
 */
@Data
public class TokenObj {
    Long userId;
    String userName;
    List<String> roleIds;
    Byte status;
    String depId;
}
