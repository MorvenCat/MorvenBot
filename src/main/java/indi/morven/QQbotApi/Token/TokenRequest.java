package indi.morven.QQbotApi.Token;

import indi.morven.config.GlobalConfig;

public class TokenRequest {
    private static String appId = GlobalConfig.getAppId();
    private static String clientSecret = GlobalConfig.getAppSecret();

    public TokenRequest() {
    }

    public TokenRequest(String appId, String clientSecret) {
        this.appId = appId;
        this.clientSecret = clientSecret;
    }

    /**
     * 获取
     * @return appId
     */
    public static String getAppId() {
        return appId;
    }

    /**
     * 设置
     * @param appId
     */
    public static void setAppId(String appId) {
        TokenRequest.appId = appId;
    }

    /**
     * 获取
     * @return clientSecret
     */
    public static String getClientSecret() {
        return clientSecret;
    }

    /**
     * 设置
     * @param clientSecret
     */
    public static void setClientSecret(String clientSecret) {
        TokenRequest.clientSecret = clientSecret;
    }
}
