package indi.zhifa.learn.simpleweb.api;
import indi.zhifa.learn.common.math.*;
import indi.zhifa.learn.common.response.*;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * MathApi Created by IntelliJ IDEA.
 *
 * @author: 芝法酱
 * @create 2021/3/12 14:26
 */
@RestController
@Api(tags = "mathApi:数学库")
@RequestMapping("/api/v1.0/mathApi")
public class MathApi {

    @Operation(summary = "快速乘方")
    @GetMapping(path = "/fastPow")
    public RestResponse<Double> fastPow(
            @Parameter(description = "底数") @RequestParam(name = "base") Double pBase,
            @Parameter(description = "指数") @RequestParam(name = "index") Integer pIndex) {
        Double result = ZfMath.pow(pBase, pIndex);
        return RestResponse.ok(result);
    }
}
