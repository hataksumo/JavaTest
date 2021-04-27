package indi.zhifa.learn.simpleweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author 芝法酱
 */
@Configuration
public class PasswordEncoderConfig {
    @Bean(name = "BCrypt")
    public PasswordEncoder getDefaultEncoder(){
        return new BCryptPasswordEncoder(5);
    }
}
