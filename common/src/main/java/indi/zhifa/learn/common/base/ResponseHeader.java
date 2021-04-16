package indi.zhifa.learn.common.base;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author 芝法酱
 */
public class ResponseHeader {
    @JSONField(
            name = "RESP_CODE"
    )
    private String RESP_CODE;
    @JSONField(
            name = "RESP_DESC"
    )
    private String RESP_DESC;
    @JSONField(
            name = "TIMESTAMP"
    )
    private String TIMESTAMP;

    public ResponseHeader() {
    }

    public String getRESP_CODE() {
        return this.RESP_CODE;
    }

    public void setRESP_CODE(String RESP_CODE) {
        this.RESP_CODE = RESP_CODE;
    }

    public String getRESP_DESC() {
        return this.RESP_DESC;
    }

    public void setRESP_DESC(String RESP_DESC) {
        this.RESP_DESC = RESP_DESC;
    }

    public String getTIMESTAMP() {
        return this.TIMESTAMP;
    }

    public void setTIMESTAMP(String TIMESTAMP) {
        this.TIMESTAMP = TIMESTAMP;
    }
}
