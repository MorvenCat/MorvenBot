package indi.morven.config;

public class BaseConfigBean {
    private boolean isShard;
    private boolean debug_mode;
    private boolean autoReconnect;


    public BaseConfigBean() {
        this.isShard = false;
        this.debug_mode = false;
        this.autoReconnect = true;
    }

    /**
     * 获取
     *
     * @return isShard
     */
    public boolean isIsShard() {
        return isShard;
    }

    /**
     * 设置
     *
     * @param isShard
     */
    public void setIsShard(boolean isShard) {
        this.isShard = isShard;
    }

    /**
     * 获取
     *
     * @return debug_mode
     */
    public boolean isDebug_mode() {
        return debug_mode;
    }

    /**
     * 设置
     *
     * @param debug_mode
     */
    public void setDebug_mode(boolean debug_mode) {
        this.debug_mode = debug_mode;
    }

    /**
     * 获取
     *
     * @return autoReconnect
     */
    public boolean isAutoReconnect() {
        return autoReconnect;
    }

    /**
     * 设置
     *
     * @param autoReconnect
     */
    public void setAutoReconnect(boolean autoReconnect) {
        this.autoReconnect = autoReconnect;
    }


}
