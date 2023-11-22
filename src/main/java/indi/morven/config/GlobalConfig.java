package indi.morven.config;

public class GlobalConfig {
    private static String botQQ;
    private static String appId;
    private static String token;
    private static String appSecret;
    private static boolean isShard;
    private static boolean debug_mode;
    private static boolean autoReconnect;


    public GlobalConfig() {
    }

    public GlobalConfig(String botQQ, String appId, String token, String appSecret, boolean isShard, boolean debug_mode, boolean autoReconnect) {
        this.botQQ = botQQ;
        this.appId = appId;
        this.token = token;
        this.appSecret = appSecret;
        this.isShard = isShard;
        this.debug_mode = debug_mode;
        this.autoReconnect = autoReconnect;
    }

    /**
     * 获取
     *
     * @return botQQ
     */
    public static String getBotQQ() {
        return botQQ;
    }

    /**
     * 设置
     *
     * @param botQQ
     */
    public static void setBotQQ(String botQQ) {
        GlobalConfig.botQQ = botQQ;
    }

    /**
     * 获取
     *
     * @return appId
     */
    public static String getAppId() {
        return appId;
    }

    /**
     * 设置
     *
     * @param appId
     */
    public static void setAppId(String appId) {
        GlobalConfig.appId = appId;
    }

    /**
     * 获取
     *
     * @return token
     */
    public static String getToken() {
        return token;
    }

    /**
     * 设置
     *
     * @param token
     */
    public static void setToken(String token) {
        GlobalConfig.token = token;
    }

    /**
     * 获取
     *
     * @return appSecret
     */
    public static String getAppSecret() {
        return appSecret;
    }

    /**
     * 设置
     *
     * @param appSecret
     */
    public static void setAppSecret(String appSecret) {
        GlobalConfig.appSecret = appSecret;
    }

    /**
     * 获取
     *
     * @return isShard
     */
    public static boolean isIsShard() {
        return isShard;
    }

    /**
     * 设置
     *
     * @param isShard
     */
    public static void setIsShard(boolean isShard) {
        GlobalConfig.isShard = isShard;
    }

    /**
     * 获取
     *
     * @return debug_mode
     */
    public static boolean isDebug_mode() {
        return debug_mode;
    }

    /**
     * 设置
     *
     * @param debug_mode
     */
    public static void setDebug_mode(boolean debug_mode) {
        GlobalConfig.debug_mode = debug_mode;
    }

    /**
     * 获取
     *
     * @return autoReconnect
     */
    public static boolean isAutoReconnect() {
        return autoReconnect;
    }

    /**
     * 设置
     *
     * @param autoReconnect
     */
    public static void setAutoReconnect(boolean autoReconnect) {
        GlobalConfig.autoReconnect = autoReconnect;
    }

    public static String getAUTHORIZATION() {
        return new StringBuilder().append("Bot ").append(GlobalConfig.getAppId() + ".").append(GlobalConfig.getToken()).toString();
    }

    public static String static2String() {
        return "GlobalConfig{botQQ = " + botQQ + ", appId = " + appId + ", token = " + token + ", appSecret = " + appSecret + ", isShard = " + isShard + ", debug_mode = " + debug_mode + ", autoReconnect = " + autoReconnect + "}";
    }
}
