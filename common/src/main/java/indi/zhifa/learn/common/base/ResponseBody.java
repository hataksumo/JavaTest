package indi.zhifa.learn.common.base;

import com.alibaba.fastjson.annotation.JSONField;

import java.time.LocalDateTime;

/**
 * @author 芝法酱
 */
public class ResponseBody {
    @JSONField(
            name = "UNI_NET_HEAD"
    )
    private ResponseHeader UNI_NET_HEAD;
    @JSONField(
            name = "UNI_NET_BODY"
    )
    private Object UNI_NET_BODY;

    public ResponseBody() {
    }

    public ResponseHeader getUNI_NET_HEAD() {
        return this.UNI_NET_HEAD;
    }

    public void setUNI_NET_HEAD(ResponseHeader UNI_NET_HEAD) {
        this.UNI_NET_HEAD = UNI_NET_HEAD;
    }

    public Object getUNI_NET_BODY() {
        return this.UNI_NET_BODY;
    }

    public void setUNI_NET_BODY(Object UNI_NET_BODY) {
        this.UNI_NET_BODY = UNI_NET_BODY;
    }

    public static ResponseBody createError(String pCode, String pMsg){
        ResponseBody rb = new ResponseBody();
        ResponseHeader rh = new ResponseHeader();
        rh.setRESP_CODE(pCode);
        rh.setRESP_DESC(pMsg);
        rh.setTIMESTAMP(LocalDateTime.now().toString());
        rb.setUNI_NET_HEAD(rh);
        return rb;
    }

    public static ResponseBody ok(Object pRsp){
        ResponseBody rb = new ResponseBody();
        ResponseHeader rh = new ResponseHeader();
        rh.setRESP_CODE("0000");
        rh.setRESP_DESC("访问成功");
        rh.setTIMESTAMP(LocalDateTime.now().toString());
        rb.setUNI_NET_HEAD(rh);
        rb.setUNI_NET_BODY(pRsp);
        return rb;
    }
}
