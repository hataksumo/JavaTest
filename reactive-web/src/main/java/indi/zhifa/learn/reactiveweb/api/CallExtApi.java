package indi.zhifa.learn.reactiveweb.api;

import indi.zhifa.learn.common.response.RestResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 芝法酱
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
@Slf4j
public class CallExtApi {

    @GetMapping("/callFastPow")
    public Mono<RestResponse> callFastPow(@RequestParam(name = "base") Double pBase,
                                                  @RequestParam(name = "index") Integer pIndex){
        WebClient webClient = WebClient.create();
        Map<String,Object> params = Map.of("base",pBase,"index",pIndex);
        log.info("当前线程Id = "+Thread.currentThread().getId()+" 调用前时间为 "+ System.currentTimeMillis());
        Mono<RestResponse> mono = webClient.get().uri("localhost:8081/api/v1.0/mathApi/fastPow?base={base}&index={index}",params)
                .retrieve().bodyToMono(RestResponse.class);
        log.info("当前线程Id = "+Thread.currentThread().getId()+" 调用后时间为 "+ System.currentTimeMillis());
        return mono;
    }

}
