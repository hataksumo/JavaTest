package indi.zhifa.learn.simpleweb.controller.api;

import indi.zhifa.learn.common.base.ResponseBody;
import indi.zhifa.learn.common.math.ZfMath;
import indi.zhifa.learn.common.response.RestResponse;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * MathApi Created by IntelliJ IDEA.
 *
 * @author: 芝法酱
 * @create 2021/3/12 14:26
 */
@RestController
@Api(tags = "mathApi:数学库")
@RequestMapping("/api/v1.0/mathApi")
@Slf4j
public class MathApi {

    @Value("haha")
    String testV;

    @Operation(summary = "快速乘方")
    @GetMapping(path = "/fastPow")
    public RestResponse<Double> fastPow(
            @Parameter(description = "底数") @RequestParam(name = "base") Double pBase,
            @Parameter(description = "指数") @RequestParam(name = "index") Integer pIndex) throws InterruptedException {
        Double result = ZfMath.pow(pBase, pIndex);
        //Thread.sleep(2000);
        log.info("返回结果时间为"+System.currentTimeMillis());
        return RestResponse.ok(result);
    }

    @Operation(summary = "中台快速乘方")
    @GetMapping(path = "/central/fastPow")
    public ResponseBody centralFastPow(
            @Parameter(description = "底数") @RequestParam(name = "base") Double pBase,
            @Parameter(description = "指数") @RequestParam(name = "index") Integer pIndex) throws InterruptedException {
        //Thread.sleep(500);
        Double result = ZfMath.pow(pBase, pIndex);
        return ResponseBody.ok(result);
    }

    @PostMapping(path = "/testCallBack")
    public String testCallBack(@RequestBody String pBody){
        log.info("发生了调用 "+pBody);
        return "调用成功";
    }
}
