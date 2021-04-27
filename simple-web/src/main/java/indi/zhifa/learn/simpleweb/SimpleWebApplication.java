package indi.zhifa.learn.simpleweb;

import indi.zhifa.learn.common.utils.DtoEntityUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @author 芝法酱
 */
@MapperScans(value = {
        @MapperScan("indi.zhifa.learn.simpleweb.generate.mapper")})
@EnableOpenApi
@SpringBootApplication
public class SimpleWebApplication {

    public static void main(String[] args) {
        DtoEntityUtil.init();
        SpringApplication.run(SimpleWebApplication.class, args);
    }

}
