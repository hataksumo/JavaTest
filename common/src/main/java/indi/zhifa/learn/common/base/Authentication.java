package indi.zhifa.learn.common.base;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author 芝法酱
 */
public class Authentication {
    @JSONField(
            name = "APP_ID"
    )
    private String APP_ID;
    @JSONField(
            name = "TIMESTAMP"
    )
    private String TIMESTAMP;
    @JSONField(
            name = "TRANS_ID"
    )
    private String TRANS_ID;
    @JSONField(
            name = "TOKEN"
    )
    private String TOKEN;

    public Authentication() {
    }

    public String getAPP_ID() {
        return this.APP_ID;
    }

    public void setAPP_ID(String APP_ID) {
        this.APP_ID = APP_ID;
    }

    public String getTIMESTAMP() {
        return this.TIMESTAMP;
    }

    public void setTIMESTAMP(String TIMESTAMP) {
        this.TIMESTAMP = TIMESTAMP;
    }

    public String getTRANS_ID() {
        return this.TRANS_ID;
    }

    public void setTRANS_ID(String TRANS_ID) {
        this.TRANS_ID = TRANS_ID;
    }

    public String getTOKEN() {
        return this.TOKEN;
    }

    public void setTOKEN(String TOKEN) {
        this.TOKEN = TOKEN;
    }
}
