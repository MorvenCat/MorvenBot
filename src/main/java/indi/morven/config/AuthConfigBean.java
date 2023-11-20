package indi.morven.config;

public class AuthConfigBean {
    private String botQQ;
    private String appId;
    private String token;
    private String appSecret;

    public AuthConfigBean() {
        this.botQQ = "botQQ";
        this.appId = "appId";
        this.token = "token";
        this.appSecret = "appSecret";
    }

    public AuthConfigBean(String botQQ, String appId, String token, String appSecret) {
        this.botQQ = botQQ;
        this.appId = appId;
        this.token = token;
        this.appSecret = appSecret;
    }


    /**
     * 获取
     *
     * @return botQQ
     */
    public String getBotQQ() {
        return botQQ;
    }

    /**
     * 设置
     *
     * @param botQQ
     */
    public void setBotQQ(String botQQ) {
        this.botQQ = botQQ;
    }

    /**
     * 获取
     *
     * @return appId
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置
     *
     * @param appId
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * 获取
     *
     * @return token
     */
    public String getToken() {
        return token;
    }

    /**
     * 设置
     *
     * @param token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 获取
     *
     * @return appSecret
     */
    public String getAppSecret() {
        return appSecret;
    }

    /**
     * 设置
     *
     * @param appSecret
     */
    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

}
