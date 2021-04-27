package indi.zhifa.learn.simpleweb.bean.dto.auth;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author 芝法酱
 */
@Data
public class VerifyCode {
    String code;
    LocalDateTime expire;
}
